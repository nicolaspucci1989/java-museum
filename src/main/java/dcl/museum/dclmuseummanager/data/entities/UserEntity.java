package dcl.museum.dclmuseummanager.data.entities;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
