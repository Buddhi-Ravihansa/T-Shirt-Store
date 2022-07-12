package com.sunmass.demo.cloth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository bro;

    public List<Brand> listAll() { return (List<Brand>) bro.findAll();}

    public void save(Brand brand) {bro.save(brand); }
}
