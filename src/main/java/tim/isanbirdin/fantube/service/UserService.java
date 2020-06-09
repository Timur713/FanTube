package tim.isanbirdin.fantube.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tim.isanbirdin.fantube.domain.User;
import tim.isanbirdin.fantube.repo.UserRepo;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user  = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }

        return user;
    }
}
