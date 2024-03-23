package com.RestAPIdb.RestApiDB.repository;

import com.RestAPIdb.RestApiDB.entity.FoodItem;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//aici JpaRepository<x,y> x=Entitatea de JPA, y=tipul Primary Key-ululi

public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {

    List<FoodItem> findByCategory(String category);

    @Query("SELECT f.name AS name, f.category AS category, n.IG AS ig FROM FoodItem f JOIN f.nutrient n WHERE f.category = :category AND n.IG < :ig")
    List<Tuple> findLowerIgAlternativesByCategory(@Param("category")String category, @Param("ig")Float ig);



}
