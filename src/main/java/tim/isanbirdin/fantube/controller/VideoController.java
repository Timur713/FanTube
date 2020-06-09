package tim.isanbirdin.fantube.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tim.isanbirdin.fantube.domain.User;
import tim.isanbirdin.fantube.domain.Video;
import tim.isanbirdin.fantube.service.VideoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class VideoController {
    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/videos")
    public String showPage() {

        return "video";
    }

    @GetMapping("/videos/{filename}")
    public String showCertainVideo(
            @PathVariable String filename,
            Model model
    ) {
        Video video = videoService.findByFilename(filename);
        User user = videoService.getUserRepo().findByFilenames(filename);

        model.addAttribute("user", user);
        model.addAttribute("video", video);

        return "video";
    }

    @PostMapping("/videos/{filename}")
    public String videoEstimating(
            @AuthenticationPrincipal User user,
            @PathVariable String filename,
            Model model,
            @RequestParam String estimate
    ) {
        Video video = videoService.findByFilename(filename);

        videoService.makeEstimation(user, estimate, video);

        model.addAttribute("user", user);
        model.addAttribute("video", video);

        return "video";
    }

    @GetMapping("/likedVideos")
    public String showPage2(@AuthenticationPrincipal User user, Model model) {
        Set<Long> likedVideosIds = user.getLikedVideos();

        List<Video> likedVideos = new ArrayList<>();

        for (Long id : likedVideosIds) {
            likedVideos.add(videoService.findById(id));
        }

        model.addAttribute("likedVideos", likedVideos);

        return "likedVideos";
    }
}
