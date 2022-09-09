package dcl.museum.dclmuseummanager.domain.booth;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoothService {

  private final BoothGateway boothGateway;

  public BoothService(BoothGateway boothGateway) {
    this.boothGateway = boothGateway;
  }

  public List<Booth> findAll() {
    return boothGateway.findAll();
  }

  public Booth findById(Long id) throws Exception {
    return boothGateway.findById(id);
  }

  public Booth save(Booth booth) {
    return boothGateway.save(booth);
  }

  public void delete(Long id) {
    boothGateway.delete(id);
  }

  public Booth update(Long id, Booth booth) {
    return boothGateway.update(id, booth);
  }
}
