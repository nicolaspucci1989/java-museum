package dcl.museum.dclmuseummanager.data.repositories;

import dcl.museum.dclmuseummanager.data.entities.ArtworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtworkRepository extends JpaRepository<ArtworkEntity, Long> {
}
