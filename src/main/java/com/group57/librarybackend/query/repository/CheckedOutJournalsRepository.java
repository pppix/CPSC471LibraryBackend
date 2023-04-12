package com.group57.librarybackend.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group57.librarybackend.query.model.*;

@Repository
public interface CheckedOutJournalsRepository extends JpaRepository<CheckedOutJournals, CheckedOutJournalsID>{

    @Query(value = "SELECT * FROM checked_out_journals", nativeQuery = true)
    List<CheckedOutJournals> findAllNative();

    @Query(value = "SELECT * FROM checked_out_journals t WHERE t.JournalCID LIKE  ?1", nativeQuery = true)
    List<CheckedOutJournals> findByProductIDEqualsNative(int ProductID);

}