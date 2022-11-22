package dcl.museum.dclmuseummanager.data.gateways;

import dcl.museum.dclmuseummanager.data.entities.ArtworkEntity;
import dcl.museum.dclmuseummanager.data.entities.BoothEntity;
import dcl.museum.dclmuseummanager.data.entities.UserEntity;
import dcl.museum.dclmuseummanager.data.repositories.BoothRepository;
import dcl.museum.dclmuseummanager.domain.artwork.Artwork;
import dcl.museum.dclmuseummanager.domain.booth.Booth;
import dcl.museum.dclmuseummanager.domain.booth.BoothGateway;
import dcl.museum.dclmuseummanager.domain.user.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Component
public class BoothDefaultGateway implements BoothGateway {
  BoothRepository boothRepository;

  public BoothDefaultGateway(BoothRepository boothRepository) {
    this.boothRepository = boothRepository;
  }

  @Override
  public List<Booth> findAll() {
    return boothRepository.findAll()
        .stream()
        .map(this::boothToModel)
        .collect(toList());
  }

  @Override
  public Booth findById(Long id) {
    BoothEntity boothEntity = boothRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    return boothToModel(boothEntity);
  }

  @Override
  public Booth save(Booth booth) {
    BoothEntity boothEntity = boothToEntity(booth);
    BoothEntity savedBooth = boothRepository.save(boothEntity);
    return boothToModel(savedBooth);
  }

  @Override
  public void delete(Long id) {
    boothRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    boothRepository.deleteById(id);
  }

  @Override
  public Booth update(Long id, Booth booth) {
    BoothEntity boothEntity = boothRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    boothEntity.setArtistName(booth.getArtistName());
    boothEntity.setArtistBio(booth.getArtistBio());
    boothEntity.setArtistUrl(booth.getArtistUrl());
    boothEntity.setName(booth.getName());
    // TODO: check how artworks are saved
    boothEntity.setArtworks(artworksToEntity(booth.getArtworks()));
    BoothEntity savedBooth = boothRepository.save(boothEntity);
    return boothToModel(savedBooth);
  }

  private Booth boothToModel(BoothEntity boothEntity) {
    return Booth.builder()
        .id(boothEntity.getId())
        .name(boothEntity.getName())
        .artistName(boothEntity.getArtistName())
        .artistBio(boothEntity.getArtistBio())
        .artistUrl(boothEntity.getArtistUrl())
        .expiresAt(boothEntity.getExpiresAt())
        .artworks(artworksToModels(boothEntity.getArtworks()))
        .users(usersToModels(boothEntity.getUsers()))
        .build();
  }

  private List<User> usersToModels(Set<UserEntity> users) {
    return users.stream()
        .map(this::userToModel)
        .collect(toList());
  }

  private User userToModel(UserEntity user) {
    return User.builder()
        .id(user.getId())
        .username(user.getUsername())
        .email(user.getEmail())
        .name(user.getName())
        .lastName(user.getLastName())
        .build();
  }

  private List<Artwork> artworksToModels(List<ArtworkEntity> artworkEntities) {
    return artworkEntities.stream()
        .map(this::artworkToModel)
        .collect(toList());
  }

  private Artwork artworkToModel(ArtworkEntity artworkEntity) {
    return Artwork.builder()
        .id(artworkEntity.getId())
        .nftAddress(artworkEntity.getNftAddress())
        .name(artworkEntity.getName())
        .build();
  }

  private BoothEntity boothToEntity(Booth booth) {
    return BoothEntity.builder()
        .name(booth.getName())
        .artistName(booth.getArtistName())
        .artistBio(booth.getArtistBio())
        .artistUrl(booth.getArtistUrl())
        .artworks(artworksToEntity(booth.getArtworks()))
        .build();
  }

  private ArtworkEntity artworkToEntity (Artwork artwork) {
    return ArtworkEntity.builder()
        .nftAddress(artwork.getNftAddress())
        .name(artwork.getName())
        .build();
  }

  private List<ArtworkEntity> artworksToEntity(List<Artwork> artworks) {
    return artworks.stream()
        .map(this::artworkToEntity)
        .collect(toList());
  }
}
