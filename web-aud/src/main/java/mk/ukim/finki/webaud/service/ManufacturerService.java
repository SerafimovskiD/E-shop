package mk.ukim.finki.webaud.service;

import mk.ukim.finki.webaud.model.Manufacturer;

import java.util.List;
import java.util.Optional;


public interface ManufacturerService {
    List<Manufacturer> findAll();
    Optional<Manufacturer> findById(Long id);
    Optional<Manufacturer>save(String name,String address);
    void deletebyId(Long id);
}
