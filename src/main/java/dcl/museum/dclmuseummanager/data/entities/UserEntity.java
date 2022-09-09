package dcl.museum.dclmuseummanager.data.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class UserEntity {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  private String name;

  @Column(name = "last_name")
  private String lastName;

  private String username;

  private String email;
}
