package tim.isanbirdin.fantube.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String name;
    private String theme;
    private String filename;

    private int likes;
    private int dislikes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ElementCollection
    private List<Integer> likedUsersHash = new ArrayList<>();

    @ElementCollection
    private List<Integer> dislikedUsersHash = new ArrayList<>();

    public Video(String name, String theme) {
        this.name = name;
        this.theme = theme;
        likes = 0;
        dislikes = 0;
    }

    public String getAuthorName() {
        return author.getUsername();
    }

    public void addToLiked(User user) {
        likedUsersHash.add((Integer) user.hashCode());
    }
    public void addToDisliked(User user) {
        dislikedUsersHash.add((Integer) user.hashCode());
    }

    public void removeFromLiked(User user) {
        likedUsersHash.remove((Integer) user.hashCode());
    }
    public void removeFromDisliked(User user) {
        dislikedUsersHash.remove((Integer) user.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return likes == video.likes &&
                dislikes == video.dislikes &&
                Objects.equals(id, video.id) &&
                Objects.equals(name, video.name) &&
                Objects.equals(theme, video.theme) &&
                Objects.equals(filename, video.filename) &&
                Objects.equals(author, video.author) &&
                Objects.equals(likedUsersHash, video.likedUsersHash) &&
                Objects.equals(dislikedUsersHash, video.dislikedUsersHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}