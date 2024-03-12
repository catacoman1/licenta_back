package com.RestAPIdb.RestApiDB.repository;

import com.RestAPIdb.RestApiDB.entity.Glicemie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GlicemieRepository extends JpaRepository<Glicemie,Long> {
    List<Glicemie> findByUserId(Long userId);
}
