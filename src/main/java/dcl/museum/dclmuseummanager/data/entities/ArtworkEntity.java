package dcl.museum.dclmuseummanager.data.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "artworks")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class ArtworkEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nft_address")
  private String nftAddress;

  private String name;
}
