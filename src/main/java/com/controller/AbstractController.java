package com.controller;

import com.model.daoEntity.EntityObject;
import com.model.entity.AbstractEntity;
import com.model.enums.TypeEntity;
import com.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public abstract class AbstractController<E extends AbstractEntity, S extends CommonService<E>> implements CommonController<E> {

    protected final S service;

    @Autowired
    protected AbstractController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<E> create(@RequestBody E entity) {
        service.save(entity);
        return ResponseEntity.ok(entity);
    }


    @Override
    public ResponseEntity<E> findById(@PathVariable int id) {
        try {
            E entity = service.findById(id);
            return new ResponseEntity<>(entity,HttpStatus.OK);
        } catch (NoSuchFieldException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @Override
    public ResponseEntity<E> deleteById(int id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<E> update(@PathVariable("id") int id, @RequestBody E entity){
        try {
            service.update(id, entity);
            return ResponseEntity.ok(entity);
        }
        catch (NoSuchFieldException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
