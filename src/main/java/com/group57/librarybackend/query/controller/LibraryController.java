package com.group57.librarybackend.query.controller;

import com.group57.librarybackend.query.model.*;
import com.group57.librarybackend.query.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    /*
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
    */
    @GetMapping(value = "/product", params = "id")
    public ResponseEntity<List> getProduct(@RequestParam("id") String id) {
        try {
            int idInt = Integer.parseInt(id);
            List<Book> book = bookRepo.findByProductIDEqualsNative(idInt);
            List<Movie> movie = movieRepo.findByProductIDEqualsNative(idInt);
            List<Journal> journal = journalRepo.findByProductIDEqualsNative(idInt);

            if(!journal.isEmpty()){

                return new ResponseEntity<>(journal, HttpStatus.OK);
            }else if(!movie.isEmpty()){
                return new ResponseEntity<>(movie, HttpStatus.OK);
            }else if(!book.isEmpty()){
                return new ResponseEntity<>(book, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/overdue", params = "id")
    public ResponseEntity<List> getOverdue(@RequestParam("id") String id) {
        try {
            int idInt = Integer.parseInt(id);
            LocalDate current = LocalDate.now();
            ArrayList product = new ArrayList<>();

            if(!checkedOutBooksRepo.findByProductIDEqualsNative(idInt).isEmpty()){

                List<CheckedOutBooks> placeVal = checkedOutBooksRepo.findByProductIDEqualsNative(idInt);
                for(CheckedOutBooks book : placeVal){

                    String[] dateVal = book.duedate.split("-");

                    LocalDate date = LocalDate.of(Integer.parseInt(dateVal[0]), Integer.parseInt(dateVal[1]), Integer.parseInt(dateVal[2]));
                    if(date.isBefore(current)){
                        Book tmpBook = bookRepo.findByProductIDEqualsNativeOne(book.bookID);
                        Overdue tmpProd = new Overdue(tmpBook.title, book.overduefee);
                        product.add(tmpProd);
                    }
                }
            }else{
                product.add("Nothing");
            }
            if(!checkedOutMoviesRepo.findByProductIDEqualsNative(idInt).isEmpty()){
                List<CheckedOutMovies> placeVal = checkedOutMoviesRepo.findByProductIDEqualsNative(idInt);
                for(CheckedOutMovies movie : placeVal){
                    String[] dateVal = movie.duedate.split("-");
                    LocalDate date = LocalDate.of(Integer.parseInt(dateVal[0]), Integer.parseInt(dateVal[1]), Integer.parseInt(dateVal[2]));
                    if(date.isBefore(current)){
                        Movie tmpMovie = movieRepo.findByProductIDEqualsNativeOne(movie.movieID);
                        Overdue tmpProd = new Overdue(tmpMovie.title, movie.overduefee);
                        product.add(tmpProd);
                    }
                }
            }else{
                product.add("Nothing");
            }
            if(!checkedOutJournalsRepo.findByProductIDEqualsNative(idInt).isEmpty()){
                List<CheckedOutJournals> placeVal = checkedOutJournalsRepo.findByProductIDEqualsNative(idInt);
                for(CheckedOutJournals journal : placeVal){
                    String[] dateVal = journal.duedate.split("-");
                    LocalDate date = LocalDate.of(Integer.parseInt(dateVal[0]), Integer.parseInt(dateVal[1]), Integer.parseInt(dateVal[2]));
                    if(date.isBefore(current)){
                        Journal tmpJournal = journalRepo.findByProductIDEqualsNativeOne(journal.journalID);
                        Overdue tmpProd = new Overdue(tmpJournal.title, journal.overduefee);
                        product.add(tmpProd);
                    }
                }
            }else{
                product.add("Nothing");
            }
            if(!product.isEmpty()){
                return new ResponseEntity<>(product, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/checkpickup", params = "id")
    public ResponseEntity<List> getPickup(@RequestParam("id") String id) {
        try {
            int idInt = Integer.parseInt(id);
            LocalDate current = LocalDate.now();
            ArrayList<Object> product = new ArrayList<Object>();
            if(!checkedOutBooksRepo.findByProductIDEqualsNative(idInt).isEmpty()){
                List<CheckedOutBooks> placeVal = checkedOutBooksRepo.findByProductIDEqualsNative(idInt);
                for(CheckedOutBooks book : placeVal){
                    String[] dateVal = book.borrowdate.split("-");
                    LocalDate date = LocalDate.of(Integer.parseInt(dateVal[0]), Integer.parseInt(dateVal[1]), Integer.parseInt(dateVal[2]));
                    if(date.isAfter(current)){
                        Book tmpBook = bookRepo.findByProductIDEqualsNativeOne(book.bookID);
                        Pickup tmpProd = new Pickup(tmpBook.title, book.borrowdate);
                        product.add(tmpProd);
                    }
                }
            }else{
                product.add("Nothing");
            }
            if(!checkedOutMoviesRepo.findByProductIDEqualsNative(idInt).isEmpty()){
                List<CheckedOutMovies> placeVal = checkedOutMoviesRepo.findByProductIDEqualsNative(idInt);
                for(CheckedOutMovies movie : placeVal){
                    String[] dateVal = movie.borrowdate.split("-");
                    LocalDate date = LocalDate.of(Integer.parseInt(dateVal[0]), Integer.parseInt(dateVal[1]), Integer.parseInt(dateVal[2]));
                    if(date.isAfter(current)){
                        Movie tmpMovie = movieRepo.findByProductIDEqualsNativeOne(movie.movieID);
                        Pickup tmpProd = new Pickup(tmpMovie.title, movie.borrowdate);
                        product.add(tmpProd);
                    }
                }
            }else{
                product.add("Nothing");
            }
            if(!checkedOutJournalsRepo.findByProductIDEqualsNative(idInt).isEmpty()){
                List<CheckedOutJournals> placeVal = checkedOutJournalsRepo.findByProductIDEqualsNative(idInt);
                for(CheckedOutJournals journal : placeVal){
                    String[] dateVal = journal.borrowdate.split("-");
                    LocalDate date = LocalDate.of(Integer.parseInt(dateVal[0]), Integer.parseInt(dateVal[1]), Integer.parseInt(dateVal[2]));
                    if(date.isAfter(current)){
                        Journal tmpJournal = journalRepo.findByProductIDEqualsNativeOne(journal.journalID);
                        Pickup tmpProd = new Pickup(tmpJournal.title, journal.borrowdate);
                        product.add(tmpProd);
                    }
                }
            }else{
                product.add("Nothing");
            }
            if(!product.isEmpty()){
                return new ResponseEntity<>(product, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody String loginInfo){

        try {
            int idInt = Integer.parseInt(loginInfo.substring(0, loginInfo.length() - 1));
            Customer customer =  customerRepo.findByProductIDEqualsNative(idInt);
            Admin admin =  adminRepo.findByProductIDEqualsNative(idInt);
            Employee employee = employeeRepo.findByProductIDEqualsNative(idInt);

            if(customer != null){
                return new ResponseEntity<>(customer, HttpStatus.OK);
            }else if(admin != null){
                return new ResponseEntity<>(admin, HttpStatus.OK);
            }else if(employee != null){
                return new ResponseEntity<>(employee, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/productregis")
    public ResponseEntity bookProduct(@RequestBody String id){
        try {

            int idInt = Integer.parseInt(id);
            List<Book> book = bookRepo.findByProductIDEqualsNative(idInt);
            List<Movie> movie = movieRepo.findByProductIDEqualsNative(idInt);
            List<Journal> journal = journalRepo.findByProductIDEqualsNative(idInt);

            if(!journal.isEmpty()){
                journalRepo.reserveJournalNative(idInt);
                return new ResponseEntity<>(HttpStatus.OK);
            }else if(!movie.isEmpty()){
                movieRepo.reserveMovieNative(idInt);
                return new ResponseEntity<>(HttpStatus.OK);
            }else if(!book.isEmpty()){

                bookRepo.reserveBookNative(idInt);
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "signup")
    public ResponseEntity register(@RequestBody Customer customer){
        try {
            customerRepo.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

