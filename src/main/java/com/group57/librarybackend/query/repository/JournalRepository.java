package com.group57.librarybackend.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import com.group57.librarybackend.query.model.*;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Integer>{

    @Query(value = "SELECT * FROM journal", nativeQuery = true)
    List<Journal> findAllNative();

    @Query(value = "SELECT * FROM journal t WHERE t.ProductID LIKE  ?1", nativeQuery = true)
    List<Journal> findByProductIDEqualsNative(int ProductID);
    @Query(value = "SELECT * FROM journal t WHERE t.ProductID LIKE ?1", nativeQuery = true)
    Journal findByProductIDEqualsNativeOne(int ProductID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE journal SET Status= 'Unavailable' WHERE ProductID=?1", nativeQuery = true)
    int reserveJournalNative(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE journal SET Status= 'Available' WHERE ProductID=?1", nativeQuery = true)
    int returnJournalNative(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE journal SET ProductID=?1 , Title=?2 , Status=?3, JournalAdminID=?4, Genre=?5 , Author=?6 , Count=?7 WHERE ProductID=?1", nativeQuery = true)
    int addBookNative(int productID, String title, String status, int journalAdminID, String genre, String author, int count);


}