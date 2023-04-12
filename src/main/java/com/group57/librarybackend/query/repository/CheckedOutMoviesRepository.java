package com.group57.librarybackend.query.repository;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group57.librarybackend.query.model.*;

@Repository
public interface CheckedOutMoviesRepository extends JpaRepository<CheckedOutMovies, CheckedOutMoviesID>{

    @Query(value = "SELECT * FROM checked_out_movies", nativeQuery = true)
    List<CheckedOutMovies> findAllNative();

    @Query(value = "SELECT * FROM checked_out_movies t WHERE t.MovieCID LIKE  ?1", nativeQuery = true)
    List<CheckedOutMovies> findByProductIDEqualsNative(int ProductID);
    @Query(value = "SELECT * FROM checked_out_movies t WHERE t.MovieID LIKE  ?1", nativeQuery = true)
    CheckedOutMovies findByProductID(int MovieID);
    @Transactional
    @Modifying
    @Query(value = "UPDATE checked_out_movies SET OverDueFee= 'Paid' WHERE MovieID=?1", nativeQuery = true)
    int payOverdueMovieNative(int id);
}