package dcl.museum.dclmuseummanager.web.controller;

import dcl.museum.dclmuseummanager.domain.artwork.Artwork;
import dcl.museum.dclmuseummanager.domain.booth.Booth;
import dcl.museum.dclmuseummanager.domain.booth.BoothService;
import dcl.museum.dclmuseummanager.domain.user.User;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

  @PostMapping
  public ResponseEntity<BoothDto> create(@RequestBody BoothDto boothDto) {
    Booth newBooth = boothDtoToDomain(boothDto);
    Booth savedBooth = boothService.create(newBooth);
    BoothDto savedBoothDto = toDetailDto(savedBooth);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedBoothDto);
  }

  private Booth boothDtoToDomain(BoothDto boothDto) {
    return Booth.builder()
        .artistUrl(boothDto.getArtistUrl())
        .artistBio(boothDto.getArtistBio())
        .artistName(boothDto.getArtistName())
        .name(boothDto.getName())
        .artworks(artworksDtosToModel(boothDto.getArtworks()))
        .build();
  }

  private List<Artwork> artworksDtosToModel(List<ArtworkDto> artworks) {
    if (artworks == null) return new ArrayList<>();

    return artworks.stream().map(this::artworkDtoToModel)
        .collect(Collectors.toList());
  }

  private Artwork artworkDtoToModel(ArtworkDto artworkDto) {
    return Artwork.builder()
        .name(artworkDto.getName())
        .nftAddress(artworkDto.getNftAddress())
        .build();
  }

  private BoothDto toDetailDto(Booth booth) {
    return BoothDto.builder()
        .id(booth.getId())
        .name(booth.getName())
        .artistName(booth.getArtistName())
        .artistBio(booth.getArtistBio())
        .artistUrl(booth.getArtistUrl())
        .artworks(artworksToDto(booth.getArtworks()))
        .users(usersToDto(booth.getGuests()))
        .build();
  }

  private List<UserDto> usersToDto(List<User> users) {
    return users.stream()
        .map(this::userToDto)
        .collect(toList());
  }

  private UserDto userToDto(User user) {
    return UserDto.builder()
        .id(user.getId())
        .name(user.getName())
        .lastName(user.getLastName())
        .email(user.getEmail())
        .username(user.getUsername())
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

  @Data
  @Builder
  public static class BoothDto {
    private Long id;
    private String name;
    private String artistName;
    private String artistBio;
    private String artistUrl;
    private List<ArtworkDto> artworks;
    private List<UserDto> users;
  }

  @Builder
  @Getter
  @Setter
  public static class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String username;
  }
}
