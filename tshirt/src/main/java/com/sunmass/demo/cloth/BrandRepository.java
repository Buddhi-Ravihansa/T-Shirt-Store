package com.sunmass.demo.cloth;

import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, Integer> {
    public Long countById(Integer id);
}
