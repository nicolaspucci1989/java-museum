package dcl.museum.dclmuseummanager.domain.artwork;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Artwork {
  private Long id;
  private String nftAddress;
  private String name;
}
