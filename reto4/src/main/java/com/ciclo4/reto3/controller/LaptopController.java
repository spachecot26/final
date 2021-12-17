package com.ciclo4.reto3.controller;

import com.ciclo4.reto3.model.Laptop;
import com.ciclo4.reto3.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/laptop")
@CrossOrigin("*")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @GetMapping("/all")
    public List<Laptop> getAllLaptops(){
        return laptopService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Laptop> getLaptop(@PathVariable("id")int id){
        return laptopService.getLaptop(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop create(@RequestBody Laptop laptop){
        return laptopService.create(laptop);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Laptop update(@RequestBody Laptop laptop){
        return laptopService.update(laptop);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return laptopService.delete(id);
    }
       @GetMapping("/price/{price}")
    public Laptop authuser(@PathVariable("price") double price) {
        List<Laptop> usuarios = laptopService.getAll();
        return laptopService.authUser(usuarios, price);
    }
           @GetMapping("/description/{description}")
    public Laptop descript(@PathVariable("description") String description) {
        List<Laptop> usuarios = laptopService.getAll();
        return laptopService.descript(usuarios, description);
    }

}
