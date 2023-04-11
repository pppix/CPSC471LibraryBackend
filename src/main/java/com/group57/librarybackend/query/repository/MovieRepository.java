package com.group57.librarybackend.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group57.librarybackend.query.model.*;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

    @Query(value = "SELECT * FROM movie", nativeQuery = true)
    List<Movie> findAllNative();

    @Query(value = "SELECT * FROM movie t WHERE t.ProductID LIKE  %?1%", nativeQuery = true)
    Movie findByProductIDEqualsNative(int ProductID);

}