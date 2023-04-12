package com.group57.librarybackend.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import com.group57.librarybackend.query.model.*;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

    @Query(value = "SELECT * FROM movie", nativeQuery = true)
    List<Movie> findAllNative();

    @Query(value = "SELECT * FROM movie t WHERE t.ProductID LIKE  ?1", nativeQuery = true)
    List<Movie> findByProductIDEqualsNative(int ProductID);
    @Query(value = "SELECT * FROM movie t WHERE t.ProductID LIKE  ?1", nativeQuery = true)
    Movie findByProductIDEqualsNativeOne(int ProductID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE movie SET Status= 'Unavailable' WHERE ProductID=?1", nativeQuery = true)
    int reserveMovieNative(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE movie SET Status= 'Available' WHERE ProductID=?1", nativeQuery = true)
    int returnMovieNative(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE movie SET ProductID=?1 , Title=?2 , Director=?3, Length=?4 , Status=?5, MovieAdminID=?6, Genre=?7 , Count=?8 WHERE ProductID=?1", nativeQuery = true)
    int addBookNative(int productID, String title, String director, int length, String status, int movieAdminID, String genre, int count);


}