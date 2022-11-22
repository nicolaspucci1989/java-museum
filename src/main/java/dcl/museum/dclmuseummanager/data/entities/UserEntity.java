package dcl.museum.dclmuseummanager.data.entities;

import lombok.*;

import javax.persistence.*;

import java.util.List;

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

  @ManyToMany
  @JoinTable(
      name="booths_users",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "booth_id")
  )
  private List<BoothEntity> booths;
}
