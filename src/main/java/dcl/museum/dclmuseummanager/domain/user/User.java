package dcl.museum.dclmuseummanager.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {
  private Long id;
  private String name;
  private String lastName;
  private String username;
  private String email;
}
