package tim.isanbirdin.fantube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tim.isanbirdin.fantube.domain.User;
import tim.isanbirdin.fantube.domain.Video;
import tim.isanbirdin.fantube.repo.VideoRepo;

import java.util.List;

@Controller
public class LibraryController {
    private final VideoRepo videoRepo;

    public LibraryController(VideoRepo videoRepo) {
        this.videoRepo = videoRepo;
    }

    @GetMapping("/library")
    public String showPage(@AuthenticationPrincipal User user, Model model) {
        List<Video> videos = videoRepo.findAllByAuthor(user);

        model.addAttribute("videos", videos);

        return "library";
    }
}
