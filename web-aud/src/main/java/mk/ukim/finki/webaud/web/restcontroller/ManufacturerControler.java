package mk.ukim.finki.webaud.web.restcontroller;

import mk.ukim.finki.webaud.bootstrap.DataHolder;
import mk.ukim.finki.webaud.model.Manufacturer;
import mk.ukim.finki.webaud.service.ManufacturerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manufacturers")
public class ManufacturerControler {
    private final ManufacturerService manufacturerService;

    public ManufacturerControler(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }
    @GetMapping
    public List<Manufacturer>findAll(){
        return this.manufacturerService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> findById(@PathVariable Long id){
            return this.manufacturerService.findById(id).map(manufacturer -> ResponseEntity.ok().body(manufacturer)).orElseGet(()->ResponseEntity.notFound().build());

    }
    @PostMapping
    public ResponseEntity<Manufacturer> save(@RequestParam String name,@RequestParam String address){
        return this.manufacturerService.save(name,address).map(manufacturer -> ResponseEntity.ok().body(manufacturer)).orElseGet(()->ResponseEntity.badRequest().build());

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Manufacturer> deletebyId(@PathVariable Long id) {
        this.manufacturerService.deletebyId(id);
        if(this.manufacturerService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
