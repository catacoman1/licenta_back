package com.RestAPIdb.RestApiDB.repository;

import com.RestAPIdb.RestApiDB.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
