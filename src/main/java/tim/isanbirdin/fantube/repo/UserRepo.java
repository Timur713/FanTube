package tim.isanbirdin.fantube.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tim.isanbirdin.fantube.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByFilenames(String filename);
}
