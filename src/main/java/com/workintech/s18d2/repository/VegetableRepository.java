package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable,Long> {

    @Query(value = "select v.id,v.name, v.price,v.is_grown_on_tree from fsweb.vegetable v order by v.price DESC",nativeQuery = true )
    List<Vegetable> getByPriceDesc();

    @Query(value = "select v.id,v.name, v.price,v.is_grown_on_tree from fsweb.vegetable v order by v.price ASC",nativeQuery = true )
    List<Vegetable> getByPriceAsc();

    @Query(value = "SELECT v FROM vegetable v WHERE v.name LIKE %:name%")
    List<Vegetable> searchByName(String name);
}
