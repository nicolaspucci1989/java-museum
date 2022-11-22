package dcl.museum.dclmuseummanager.data.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "booths")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoothEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(name = "artist_name")
  private String artistName;

  @Column(name = "artist_bio")
  private String artistBio;

  @Column(name = "artist_url")
  private String artistUrl;

  @Column(name = "expires_at")
  private LocalDateTime expiresAt;

  @OneToMany(mappedBy = "booth")
  private List<ArtworkEntity> artworks;

  @ManyToMany
  @JoinTable(name = "booths_users",
      joinColumns = @JoinColumn(name = "booth_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
  )
  private Set<UserEntity> users = new java.util.LinkedHashSet<>();

  public void addUser(UserEntity user) {
    this.users.add(user);
    user.getBooths().add(this);
  }

  public void removeUser(UserEntity user) {
    users.remove(user);
    user.getBooths().remove(this);
  }
}
