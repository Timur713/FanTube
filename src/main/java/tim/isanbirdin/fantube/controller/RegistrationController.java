package tim.isanbirdin.fantube.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tim.isanbirdin.fantube.domain.Role;
import tim.isanbirdin.fantube.domain.User;
import tim.isanbirdin.fantube.repo.UserRepo;

import java.util.Collections;

@Controller
public class RegistrationController {
    private final UserRepo userRepo;

    public RegistrationController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/registration")
    public String showPage() {

        return "registration";
    }

    @PostMapping("/registration")
    public String regUser(User user, Model model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.addAttribute("userExists", "This username is already used");
        } else {
            user.setRoles(Collections.singleton(Role.USER));
            userRepo.save(user);

            return "redirect:/login";
        }

        return "registration";
    }
}
