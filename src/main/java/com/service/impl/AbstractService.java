package com.service.impl;

import com.factory.EntityFactory;
import com.model.daoEntity.EntityObject;
import com.model.daoEntity.ValueEntity;
import com.model.entity.AbstractEntity;
import com.model.entity.impl.Doctor;
import com.repository.CommonRepository;
import com.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractService<R extends CommonRepository<EntityObject>, F extends EntityFactory, E extends AbstractEntity> implements CommonService<E> {

    protected final R repo;

    protected final F factory;

    @Autowired
    public AbstractService(R repo, F factory) {
        this.repo = repo;
        this.factory = factory;
    }

    @Override
    public EntityObject save(E entity) {
        EntityObject entityObject = factory.getDaoEntity(entity);
        return repo.save(entityObject);
    }

    @Override
    public E findById(int id) throws NoSuchFieldException {
        EntityObject entityObject = repo.findById(id).orElseThrow(NoSuchFieldError::new);
        return factory.getRealEntity(entityObject);
    }

    @Override
    public List<E> findAll(int typeId) {
        List<E> list = new ArrayList<>();
        for(EntityObject entityObject : repo.getAll(typeId)){
            list.add(factory.getRealEntity(entityObject));
        }
        return list;
    }

    @Override
    public Boolean deleteById(int id) {
        repo.deleteById(id);
        return !repo.findById(id).isPresent();
    }

    @Override
    public EntityObject update(int id, E entity){
        EntityObject entityObject = factory.getDaoEntity(entity);
        entityObject.setId(id);
        entityObject.setValueEntities(entityObject.getValueDBList());
        entityObject.setReferenceEntities(repo.findById(id).get().getReferenceEntities());
        entityObject.setBackReferenceEntities(repo.findById(id).get().getBackReferenceEntities());
        return repo.save(entityObject);
    }

}
