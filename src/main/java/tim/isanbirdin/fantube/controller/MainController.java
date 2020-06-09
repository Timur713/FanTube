package tim.isanbirdin.fantube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tim.isanbirdin.fantube.domain.Video;
import tim.isanbirdin.fantube.repo.VideoRepo;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    private final VideoRepo videoRepo;

    public MainController(VideoRepo videoRepo) {
        this.videoRepo = videoRepo;
    }


    @GetMapping
    public String main(Model model) {
        List<Video> allVideos = videoRepo.findAll();

        model.addAttribute("allVideos", allVideos);
        return "main";
    }
}
