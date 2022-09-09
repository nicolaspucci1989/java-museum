package dcl.museum.dclmuseummanager.data.repositories;

import dcl.museum.dclmuseummanager.data.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
