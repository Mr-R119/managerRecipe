package com.service;

import com.model.daoEntity.EntityObject;
import com.model.entity.AbstractEntity;

import java.util.List;
import java.util.Optional;

public interface CommonService<E extends AbstractEntity> {
    EntityObject save(E entity);

    E findById(int id) throws NoSuchFieldException;

    List<E> findAll(int typeId);

    Boolean deleteById(int id);

    EntityObject update(int id, E entity) throws NoSuchFieldException;
}
