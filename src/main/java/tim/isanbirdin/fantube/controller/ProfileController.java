package tim.isanbirdin.fantube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import tim.isanbirdin.fantube.domain.User;
import tim.isanbirdin.fantube.domain.Video;
import tim.isanbirdin.fantube.repo.UserRepo;
import tim.isanbirdin.fantube.repo.VideoRepo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class ProfileController {
    @Value("${video.store.path}")
    private String videoStorePath;

    private final UserRepo userRepo;
    private final VideoRepo videoRepo;

    public ProfileController(UserRepo userRepo, VideoRepo videoRepo) {
        this.userRepo = userRepo;
        this.videoRepo = videoRepo;
    }

    @GetMapping("/profile")
    public String showPage(@AuthenticationPrincipal User user, Model model) {
        List<Video> videos = videoRepo.findAllByAuthor(user);

        model.addAttribute("videoList", videos);

        return "profile";
    }

    @PostMapping("/profile")
    public String changeData(
            @RequestParam String email,
            @RequestParam String password,
            @AuthenticationPrincipal User user
    ) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        userFromDb.setEmail(email);
        userFromDb.setPassword(password);

        userRepo.save(userFromDb);

        return "/profile";
    }

    @PostMapping("/profile/addVideo")
    public String addVideo(@RequestParam("file") MultipartFile file,
                           @RequestParam("name") String name,
                           @RequestParam("theme") String theme,
                           @AuthenticationPrincipal User user,
                           Model model) throws IOException {
        if (file != null && !file.isEmpty()) {
            Video video = new Video(name, theme);

            File videoDir = new File(videoStorePath);
            if (!videoDir.exists()) {
                videoDir.mkdir();
            }

            String uuidPath = UUID.randomUUID().toString();
            String resultFilename = uuidPath + "." + file.getOriginalFilename();

            file.transferTo(new File(videoStorePath + "/" + resultFilename));

            video.setFilename(resultFilename);
            video.setAuthor(user);
            user.addVideo(resultFilename);

            videoRepo.save(video);
            userRepo.save(user);

            model.addAttribute("load_success", "Video was load success.");

            return "addVideo";
        } else {
            model.addAttribute("load_wrong", "Something went wrong. Video wasn't load.");

            return "addVideo";
        }
    }
}
