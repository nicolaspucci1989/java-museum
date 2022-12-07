package dcl.museum.dclmuseummanager.data.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
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

  @OneToMany(mappedBy = "booth", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  @Builder.Default
  private List<ArtworkEntity> artworks = new ArrayList<>();

  @ManyToMany
  @JoinTable(name = "booths_guests",
      joinColumns = @JoinColumn(name = "booth_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "guest_id", referencedColumnName = "id")
  )
  @Builder.Default
  private Set<UserEntity> guests = new HashSet<>();

  public void addUser(UserEntity user) {
    this.guests.add(user);
    user.getBooths().add(this);
  }

  public void removeUser(UserEntity user) {
    guests.remove(user);
    user.getBooths().remove(this);
  }

  public void addArtwork(ArtworkEntity artwork) {
    artworks.add(artwork);
    artwork.setBooth(this);
  }

  public void removeArtwork(ArtworkEntity artwork) {
    artworks.remove(artwork);
    artwork.setBooth(null);
  }
}
