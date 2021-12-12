package com.factory;

import com.model.daoEntity.EntityObject;
import com.model.entity.AbstractEntity;
import org.springframework.stereotype.Service;

@Service
public interface EntityFactory {
    <E extends AbstractEntity> E getRealEntity(EntityObject commonEntityDao);

    <E extends EntityObject> EntityObject getDaoEntity(AbstractEntity abstractEntity);
}
