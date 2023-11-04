package com.RestAPIdb.RestApiDB.repository;

import com.RestAPIdb.RestApiDB.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
