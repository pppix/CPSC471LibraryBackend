package com.group57.librarybackend.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import com.group57.librarybackend.query.model.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    
    // @Query("SELECT t FROM book t")
    // List<Book> findAll();


    @Query(value = "SELECT * FROM book", nativeQuery = true)
    List<Book> findAllNative();

    @Query(value = "SELECT * FROM book t WHERE t.ProductID LIKE  ?1", nativeQuery = true)
    Book findByProductIDEqualsNative(int ProductID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE book SET Status= 'Unavailable' WHERE ProductID=?1", nativeQuery = true)
    int reserveBookNative(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE book SET Status= 'Available' WHERE ProductID=?1", nativeQuery = true)
    int returnBookNative(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE book SET ProductID=?1 , Title=?2 , Status=?3, BookAdminID=?4, Genre=?5 , Author=?6 , Count=?7 WHERE ProductID=?1", nativeQuery = true)
    int addBookNative(int productID, String title, String status, int bookAdminID, String genre, String author, int count);

    // @Modifying
    // @Query("INSERT INTO book (ProductID, Title, Status, BookAdminID, Genre, Author, Count) VALUES (3,'none','none',1,'none','none',1)")
    // int insertBook(int productID, String title, String status, int bookAdminID, String genre, String author, int count);
}
