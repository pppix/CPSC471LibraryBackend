package com.group57.librarybackend.query.repository;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group57.librarybackend.query.model.*;

@Repository
public interface CheckedOutBooksRepository extends JpaRepository<CheckedOutBooks, Integer>{

    @Query(value = "SELECT * FROM checked_out_books", nativeQuery = true)
    List<CheckedOutBooks> findAllNative();

    @Query(value = "SELECT * FROM checked_out_books t WHERE t.BookCID LIKE  ?1", nativeQuery = true)
    List<CheckedOutBooks> findByProductIDEqualsNative(int BookCID);
    @Query(value = "SELECT * FROM checked_out_books t WHERE t.BookID LIKE  ?1", nativeQuery = true)
    CheckedOutBooks findByProductID(int BookID);
    @Transactional
    @Modifying
    @Query(value = "UPDATE checked_out_books SET OverDueFee= 'Paid' WHERE BookID=?1", nativeQuery = true)
    int payOverdueBookNative(int id);

}