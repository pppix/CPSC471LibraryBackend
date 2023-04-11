package com.group57.librarybackend.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group57.librarybackend.query.model.*;

@Repository
public interface CheckedOutBooksRepository extends JpaRepository<CheckedOutBooks, CheckedOutBooksID>{

    @Query(value = "SELECT * FROM checked_out_books", nativeQuery = true)
    List<CheckedOutBooks> findAllNative();

}