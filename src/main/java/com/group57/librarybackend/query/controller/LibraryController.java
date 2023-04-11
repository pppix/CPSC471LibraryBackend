package com.group57.librarybackend.query.controller;

import com.group57.librarybackend.query.model.Book;
import com.group57.librarybackend.query.model.Movie;
import com.group57.librarybackend.query.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping
@ResponseBody
public class LibraryController {
    @Autowired(required = false)
    AdminRepository adminRepo;
    @Autowired(required = false)
    BookRepository bookRepo;
    @Autowired(required = false)
    CheckedOutBooksRepository checkedOutBooksRepo;
    @Autowired(required = false)
    CheckedOutJournalsRepository checkedOutJournalsRepo;
    @Autowired(required = false)
    CheckedOutMoviesRepository checkedOutMoviesRepo;
    @Autowired(required = false)
    CustomerRepository customerRepo;
    @Autowired(required = false)
    DependantRepository dependantRepo;
    @Autowired(required = false)
    EmployeeRepository employeeRepo;
    @Autowired(required = false)
    JournalRepository journalRepo;
    @Autowired(required = false)
    MovieRepository movieRepo;

    @GetMapping("/product")
    public ResponseEntity<List<Book>> getAllBook() {
        try {
            List<Book> books = new ArrayList<Book>();

            bookRepo.findAllNative().forEach(books::add);


            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
