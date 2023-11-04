package com.RestAPIdb.RestApiDB.repository;

import com.RestAPIdb.RestApiDB.entity.Nutrient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutrientRepository extends JpaRepository<Nutrient,Long> {
}
