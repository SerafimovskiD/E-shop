package mk.ukim.finki.webaud.repository.jpa;

import mk.ukim.finki.webaud.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {
//    void deleteById(Long id);
}
