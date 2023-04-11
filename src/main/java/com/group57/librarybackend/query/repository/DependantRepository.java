package com.group57.librarybackend.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group57.librarybackend.query.model.*;

@Repository
public interface DependantRepository extends JpaRepository<Dependant, DependantID>{

    @Query(value = "SELECT * FROM dependant", nativeQuery = true)
    List<Dependant> findAllNative();

}