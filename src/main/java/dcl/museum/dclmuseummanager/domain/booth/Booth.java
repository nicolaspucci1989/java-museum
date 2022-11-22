package dcl.museum.dclmuseummanager.domain.booth;

import dcl.museum.dclmuseummanager.domain.artwork.Artwork;
import dcl.museum.dclmuseummanager.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
public class Booth {
  private Long id;
  private String name;
  private String artistName;
  private String artistBio;
  private String artistUrl;
  private LocalDateTime expiresAt;
  private List<Artwork> artworks;
  private List<User> guests;
}
