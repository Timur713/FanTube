package tim.isanbirdin.fantube.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tim.isanbirdin.fantube.domain.User;
import tim.isanbirdin.fantube.domain.Video;

import java.util.List;
import java.util.Optional;

public interface VideoRepo extends JpaRepository<Video, Long> {
    List<Video> findAllByAuthor(User author);

    Video findByFilename(String filename);
    Optional<Video> findById(Long id);
}
