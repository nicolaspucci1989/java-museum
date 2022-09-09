package dcl.museum.dclmuseummanager.data.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "booths")
@Getter
@Setter
@Builder
@NoArgsConstructor
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

  @OneToMany
  private List<ArtworkEntity> artworks;

  @ManyToMany
  private List<UserEntity> guests;
}
