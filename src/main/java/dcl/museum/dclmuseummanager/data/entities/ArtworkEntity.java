package dcl.museum.dclmuseummanager.data.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "artworks")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArtworkEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nft_address")
  private String nftAddress;

  private String name;
}
