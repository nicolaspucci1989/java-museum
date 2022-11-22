package dcl.museum.dclmuseummanager.data.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

  @ManyToMany(mappedBy = "booths")
  private List<UserEntity> guests;
}
