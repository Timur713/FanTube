package tim.isanbirdin.fantube.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usr")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String email;
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_videos", joinColumns = @JoinColumn(name = "user_id"))
    private List<String> filenames;


    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Long> likedVideos = new HashSet<>();

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public void addVideo(String filename) {
        filenames.add(filename);
    }

    public void addToLiked(Video video) {
        likedVideos.add(video.getId());
    }

    public void removeFromLiked(Video video) {
        likedVideos.remove(video.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(roles, user.roles) &&
                Objects.equals(filenames, user.filenames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
