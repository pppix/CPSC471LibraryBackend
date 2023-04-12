package com.group57.librarybackend.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group57.librarybackend.query.model.*;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Integer>{

    @Query(value = "SELECT * FROM journal", nativeQuery = true)
    List<Journal> findAllNative();

    @Query(value = "SELECT * FROM journal t WHERE t.ProductID LIKE  %?1%", nativeQuery = true)
    List<Journal> findByProductIDEqualsNative(int ProductID);
    @Query(value = "SELECT * FROM journal t WHERE t.ProductID LIKE  %?1%", nativeQuery = true)
    Journal findByProductIDEqualsNativeOne(int ProductID);

}