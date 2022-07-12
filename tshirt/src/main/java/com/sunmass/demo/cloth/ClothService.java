package com.sunmass.demo.cloth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothService {

    @Autowired private ClothRepository clo;

    public List<Cloth> listAll() { return (List<Cloth>) clo.findAll();}

    public void save(Cloth cloth) {clo.save(cloth); }

    public Cloth get(Integer id) throws ClothNotFoundException {
        Optional<Cloth> result = clo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new ClothNotFoundException(" Could not find any users with ID "+id);
    }

    public void delete(Integer id) throws ClothNotFoundException {
        Long count = clo.countById(id);
        if (count == null || count == 0) {
            throw new ClothNotFoundException(" Could not find any users with ID "+ id);
        }
       clo.deleteById(id);
    }
}
