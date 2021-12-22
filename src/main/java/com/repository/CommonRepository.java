package com.repository;

import com.model.daoEntity.EntityObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonRepository<E extends EntityObject> extends JpaRepository<E,Integer> {

    @Query(value = "Select e from EntityObject AS e where e.typeId=:typeId")
    List<E> getAll(int typeId);

}
