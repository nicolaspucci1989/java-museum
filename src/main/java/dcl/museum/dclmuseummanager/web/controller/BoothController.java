package dcl.museum.dclmuseummanager.web.controller;

import dcl.museum.dclmuseummanager.domain.booth.Booth;
import dcl.museum.dclmuseummanager.domain.booth.BoothService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
  @NoArgsConstructor
  public static class BoothListDto {
    private Long id;
    private String name;
    private String artistName;
  }
}
