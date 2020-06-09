package tim.isanbirdin.fantube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tim.isanbirdin.fantube.domain.Video;
import tim.isanbirdin.fantube.repo.UserRepo;
import tim.isanbirdin.fantube.repo.VideoRepo;

import java.util.List;

@Controller
public class UserController {
    private final VideoRepo videoRepo;
    private final UserRepo userRepo;

    public UserController(VideoRepo videoRepo, UserRepo userRepo) {
        this.videoRepo = videoRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/users")
    public String showProfilePage() {

        return "redirect:/profile";
    }

    @GetMapping("users/{username}")
    public String currentUser(@PathVariable String username, Model model) {
        List<Video> author_videos = videoRepo.findAllByAuthor(userRepo.findByUsername(username));
        model.addAttribute("author_videos", author_videos);
        model.addAttribute("author_name", username);

        return "users";
    }

}
