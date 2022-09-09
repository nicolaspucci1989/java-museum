package dcl.museum.dclmuseummanager.data.repositories;

import dcl.museum.dclmuseummanager.data.entities.BoothEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoothRepository extends JpaRepository<BoothEntity, Long> {
}
