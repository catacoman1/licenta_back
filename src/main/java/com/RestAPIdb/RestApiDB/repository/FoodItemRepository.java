package com.RestAPIdb.RestApiDB.repository;

import com.RestAPIdb.RestApiDB.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//aici JpaRepository<x,y> x=Entitatea de JPA, y=tipul Primary Key-ululi

public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {

    List<FoodItem> findByCategory(String category);

}
