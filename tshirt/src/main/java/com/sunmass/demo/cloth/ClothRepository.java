package com.sunmass.demo.cloth;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClothRepository extends CrudRepository<Cloth, Integer> {
    public Long countById(Integer id);
}
