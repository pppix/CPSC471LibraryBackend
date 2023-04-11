package com.group57.librarybackend.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group57.librarybackend.query.model.*;

@Repository
public interface CheckedOutMoviesRepository extends JpaRepository<CheckedOutMovies, CheckedOutMoviesID>{

    @Query(value = "SELECT * FROM checked_out_movies", nativeQuery = true)
    List<CheckedOutMovies> findAllNative();

    @Query(value = "SELECT * FROM checked_out_movies t WHERE t.MovieCID LIKE  ?1", nativeQuery = true)
    CheckedOutMovies findByProductIDEqualsNative(int ProductID);

}