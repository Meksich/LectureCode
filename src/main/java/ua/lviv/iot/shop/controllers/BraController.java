package ua.lviv.iot.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.shop.exception.BraNotFoundException;
import ua.lviv.iot.shop.models.Bra;
import ua.lviv.iot.shop.service.BraService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/bra")
public class BraController {

    private static final Logger LOGGER = Logger.getLogger("ua.lviv.iot.shop.controllers.BraController");

    @Autowired
    private BraService braService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Bra> getBra(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(braService.getBra(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            LOGGER.severe("Bra with" + id + "id does not exists");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Bra> getBras(){
        return braService.getBras();
    }

    @PostMapping
    public ResponseEntity<Bra> createBra(@RequestBody Bra bra){
        if (bra.getId() == null) {
            braService.addBra(bra);
            return new ResponseEntity<Bra>(bra, HttpStatus.OK);
        }
        LOGGER.severe("Failed to create a Bra with passed id. Bra creation should not use external ids");
        return new ResponseEntity<Bra>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Bra> updateBra(@PathVariable Integer id, @RequestBody Bra bra){
        try {
            bra.setId(id);
            braService.updateBra(id, bra);
            return new ResponseEntity<>(bra, HttpStatus.OK);
        } catch (BraNotFoundException e) {
            LOGGER.severe("Can't update an bra with non-existing id");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteBra(@PathVariable Integer id){
        if (braService.deleteBra(id)){
            return ResponseEntity.ok("Successfully deleted");
        }
        return ResponseEntity.notFound().build();
    }
}
