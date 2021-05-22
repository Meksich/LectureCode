package ua.lviv.iot.shop.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import ua.lviv.iot.shop.dal.BraRepository;
import ua.lviv.iot.shop.exception.BraNotFoundException;
import ua.lviv.iot.shop.models.Bra;
import java.util.List;

@Service
@Data
@ApplicationScope
public class BraService {

    private BraRepository repository;

    @Autowired
    public BraService(BraRepository braRepository) {
        this.repository = braRepository;
    }
    public void addBra(Bra bra){
        repository.save(bra);
    }

    public Bra updateBra(Integer id, Bra bra) throws BraNotFoundException {
        if (repository.existsById(bra.getId())) {
            return repository.save(bra);
        }
        throw new BraNotFoundException("Bra with id: " + bra.getId() + "not found");
    }

    public List<Bra> getBras(){
        return repository.findAll();
    }

    public Bra getBra(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public boolean deleteBra(Integer id){
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
