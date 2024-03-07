package com.RestAPIdb.RestApiDB.repository;

import com.RestAPIdb.RestApiDB.entity.MenuFoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuFoodItemRepository extends JpaRepository<MenuFoodItem,Long> {

}
