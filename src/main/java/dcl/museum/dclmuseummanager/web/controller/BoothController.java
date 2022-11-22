package dcl.museum.dclmuseummanager.web.controller;

import dcl.museum.dclmuseummanager.domain.artwork.Artwork;
import dcl.museum.dclmuseummanager.domain.booth.Booth;
import dcl.museum.dclmuseummanager.domain.booth.BoothService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/booths")
@RequiredArgsConstructor
public class BoothController {
  private final BoothService boothService;

  @GetMapping
  public ResponseEntity<List<BoothListDto>> findAll() {
    return ResponseEntity.ok().body(toListDto(boothService.findAll()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<BoothDto> findById(@PathVariable Long id) throws Exception {
    return ResponseEntity.ok(toDetailDto(boothService.findById(id)));
  }

  private BoothDto toDetailDto(Booth booth) {
    return BoothDto.builder()
        .id(booth.getId())
        .name(booth.getName())
        .artistName(booth.getArtistName())
        .artistBio(booth.getArtistBio())
        .artistUrl(booth.getArtistUrl())
        .artworks(artworksToDto(booth.getArtworks()))
        .build();
  }

  private List<ArtworkDto> artworksToDto(List<Artwork> artworks) {
    return artworks.stream()
        .map(this::artworkToDto)
        .collect(toList());
  }

  private ArtworkDto artworkToDto(Artwork artwork) {
    return ArtworkDto.builder()
        .id(artwork.getId())
        .name(artwork.getName())
        .nftAddress(artwork.getNftAddress())
        .build();
  }

  private List<BoothListDto> toListDto(List<Booth> booths) {
    return booths.stream()
        .map(this::toDto)
        .collect(toList());
  }

  private BoothListDto toDto(Booth booth) {
    return BoothListDto.builder()
        .id(booth.getId())
        .name(booth.getName())
        .artistName(booth.getArtistName())
        .build();
  }

  @Builder
  @Getter
  @Setter
  public static class BoothListDto {
    private Long id;
    private String name;
    private String artistName;
  }

  @Builder
  @Getter
  @Setter
  public static class ArtworkDto {
    private Long id;
    private String nftAddress;
    private String name;
  }
  @Builder
  @Getter
  @Setter
  public static class BoothDto{
    private Long id;
    private String name;
    private String artistName;
    private String artistBio;
    private String artistUrl;
    private List<ArtworkDto> artworks;
  }
}
