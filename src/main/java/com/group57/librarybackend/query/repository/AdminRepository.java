package com.group57.librarybackend.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group57.librarybackend.query.model.*;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

    @Query(value = "SELECT * FROM admin", nativeQuery = true)
    List<Admin> findAllNative();

    @Query(value = "SELECT * FROM admin t WHERE t.ID LIKE  ?1", nativeQuery = true)
    Admin findByProductIDEqualsNative(int ProductID);

}