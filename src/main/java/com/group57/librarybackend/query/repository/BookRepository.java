package com.group57.librarybackend.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group57.librarybackend.query.model.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    
    // @Query("SELECT t FROM book t")
    // List<Book> findAll();

    @Query(value = "SELECT * FROM book", nativeQuery = true)
    List<Book> findAllNative();

    @Query(value = "SELECT * FROM book t WHERE t.ProductID LIKE  ?1", nativeQuery = true)
    List<Book> findByProductIDEqualsNative(int ProductID);
    @Query(value = "SELECT * FROM book t WHERE t.ProductID LIKE  ?1", nativeQuery = true)
    Book findByProductIDEqualsNativeOne(int ProductID);

}
