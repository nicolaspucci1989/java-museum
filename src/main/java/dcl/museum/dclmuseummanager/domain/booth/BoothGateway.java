package dcl.museum.dclmuseummanager.domain.booth;

import java.util.List;

public interface BoothGateway {
  List<Booth> findAll();

  Booth findById(Long id) throws Exception;

  Booth save(Booth booth);

  void delete(Long id);

  Booth update(Long id, Booth booth);
}
