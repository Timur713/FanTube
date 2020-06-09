package tim.isanbirdin.fantube.service;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import tim.isanbirdin.fantube.domain.User;
import tim.isanbirdin.fantube.domain.Video;
import tim.isanbirdin.fantube.repo.UserRepo;
import tim.isanbirdin.fantube.repo.VideoRepo;

@Service
public class VideoService {
    private final VideoRepo videoRepo;
    private final UserRepo userRepo;

    public VideoService(VideoRepo videoRepo, UserRepo userRepo) {
        this.videoRepo = videoRepo;
        this.userRepo = userRepo;
    }

    public Video findByFilename(String filename) {
        return videoRepo.findByFilename(filename);
    }

    public Video findById(Long id) {
        return videoRepo.findById(id).get();
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public void makeEstimation(
            @AuthenticationPrincipal User user,
            @RequestParam String estimate,
            Video video
    ) {
        if (estimate.equals("like")) {
            if (!video.getLikedUsersHash().contains(user.hashCode())) {
                if (video.getDislikedUsersHash().contains(user.hashCode())) {
                    video.removeFromDisliked(user);
                }

                video.addToLiked(user);
                user.addToLiked(video);
            } else {
                video.removeFromLiked(user);
                user.removeFromLiked(video);
            }
        } else {
            if (!video.getDislikedUsersHash().contains(user.hashCode())) {
                if (video.getLikedUsersHash().contains(user.hashCode())) {
                    video.removeFromLiked(user);
                    user.removeFromLiked(video);
                }

                video.addToDisliked(user);
            } else {
                video.removeFromDisliked(user);
            }
        }

        video.setLikes(video.getLikedUsersHash().size());
        video.setDislikes(video.getDislikedUsersHash().size());

        videoRepo.save(video);
        userRepo.save(user);
    }
}
