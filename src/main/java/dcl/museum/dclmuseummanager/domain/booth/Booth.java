package dcl.museum.dclmuseummanager.domain.booth;

import dcl.museum.dclmuseummanager.domain.artwork.Artwork;
import dcl.museum.dclmuseummanager.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
  @Builder.Default
  private LocalDateTime expiresAt = LocalDateTime.now();
  private List<Artwork> artworks;
  @Builder.Default
  private List<User> guests = new ArrayList<>();
}
