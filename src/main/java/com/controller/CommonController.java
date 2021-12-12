package com.controller;

import com.model.daoEntity.EntityObject;
import com.model.entity.AbstractEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CommonController <E extends AbstractEntity> {
    @PostMapping("/create")
    ResponseEntity<E> create(@RequestBody E entity);

    @GetMapping("/list")
    ResponseEntity<List<E>> getAll();

    @GetMapping("find/{id}")
    ResponseEntity<E> findById(@PathVariable int id);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<E> deleteById(@PathVariable int id);

    @PutMapping("update/{id}")
    ResponseEntity<E> update(@PathVariable("id") int id, @RequestBody E entity);


}
