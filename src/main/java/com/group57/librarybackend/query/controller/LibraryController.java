package com.group57.librarybackend.query.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
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

    @PutMapping(value = "/productemp/productsearch")
    public ResponseEntity productUpdate(@RequestBody String id) {
        try {

            int idInt = Integer.parseInt(id);
            List<Book> book = bookRepo.findByProductIDEqualsNative(idInt);
            List<Movie> movie = movieRepo.findByProductIDEqualsNative(idInt);
            List<Journal> journal = journalRepo.findByProductIDEqualsNative(idInt);

            if (!journal.isEmpty()) {
                CheckedOutJournals checkedOutJournals = checkedOutJournalsRepo.findByProductID(idInt);
                checkedOutJournalsRepo.delete(checkedOutJournals);
                journalRepo.returnJournalNative(idInt);
                return new ResponseEntity<>(HttpStatus.OK);
            } else if (!movie.isEmpty()) {
                CheckedOutMovies checkedOutMovies = checkedOutMoviesRepo.findByProductID(idInt);
                checkedOutMoviesRepo.delete(checkedOutMovies);
                movieRepo.returnMovieNative(idInt);
                return new ResponseEntity<>(HttpStatus.OK);
            } else if (!book.isEmpty()) {
                CheckedOutBooks checkedOutBook = checkedOutBooksRepo.findByProductID(idInt);
                checkedOutBooksRepo.delete(checkedOutBook);
                bookRepo.returnBookNative(idInt);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/product", params = "id")
    public ResponseEntity<List> getProduct(@RequestParam("id") String id) {
        try {
            int idInt = Integer.parseInt(id);
            List<Book> book = bookRepo.findByProductIDEqualsNative(idInt);
            List<Movie> movie = movieRepo.findByProductIDEqualsNative(idInt);
            List<Journal> journal = journalRepo.findByProductIDEqualsNative(idInt);

            if (!journal.isEmpty()) {

                return new ResponseEntity<>(journal, HttpStatus.OK);
            } else if (!movie.isEmpty()) {
                return new ResponseEntity<>(movie, HttpStatus.OK);
            } else if (!book.isEmpty()) {
                return new ResponseEntity<>(book, HttpStatus.OK);
            } else {
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

            if (!checkedOutBooksRepo.findByProductIDEqualsNative(idInt).isEmpty()) {

                List<CheckedOutBooks> placeVal = checkedOutBooksRepo.findByProductIDEqualsNative(idInt);
                for (CheckedOutBooks book : placeVal) {

                    String[] dateVal = book.duedate.split("-");

                    LocalDate date = LocalDate.of(Integer.parseInt(dateVal[0]), Integer.parseInt(dateVal[1]), Integer.parseInt(dateVal[2]));
                    if (date.isBefore(current)) {
                        Book tmpBook = bookRepo.findByProductIDEqualsNativeOne(book.bookID);
                        Overdue tmpProd = new Overdue(tmpBook.title, book.overduefee, book.bookID);
                        product.add(tmpProd);
                    }
                }
            } else {
                product.add("Nothing");
            }
            if (!checkedOutMoviesRepo.findByProductIDEqualsNative(idInt).isEmpty()) {
                List<CheckedOutMovies> placeVal = checkedOutMoviesRepo.findByProductIDEqualsNative(idInt);
                for (CheckedOutMovies movie : placeVal) {
                    String[] dateVal = movie.duedate.split("-");
                    LocalDate date = LocalDate.of(Integer.parseInt(dateVal[0]), Integer.parseInt(dateVal[1]), Integer.parseInt(dateVal[2]));
                    if (date.isBefore(current)) {
                        Movie tmpMovie = movieRepo.findByProductIDEqualsNativeOne(movie.movieID);
                        Overdue tmpProd = new Overdue(tmpMovie.title, movie.overduefee, movie.movieID);
                        product.add(tmpProd);
                    }
                }
            } else {
                product.add("Nothing");
            }
            if (!checkedOutJournalsRepo.findByProductIDEqualsNative(idInt).isEmpty()) {
                List<CheckedOutJournals> placeVal = checkedOutJournalsRepo.findByProductIDEqualsNative(idInt);
                for (CheckedOutJournals journal : placeVal) {
                    String[] dateVal = journal.duedate.split("-");
                    LocalDate date = LocalDate.of(Integer.parseInt(dateVal[0]), Integer.parseInt(dateVal[1]), Integer.parseInt(dateVal[2]));
                    if (date.isBefore(current)) {
                        Journal tmpJournal = journalRepo.findByProductIDEqualsNativeOne(journal.journalID);
                        Overdue tmpProd = new Overdue(tmpJournal.title, journal.overduefee, journal.journalID);
                        product.add(tmpProd);
                    }
                }
            } else {
                product.add("Nothing");
            }
            if (!product.isEmpty()) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            } else {
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
            ArrayList<Object> product = new ArrayList<Object>();
            if (!checkedOutBooksRepo.findByProductIDEqualsNative(idInt).isEmpty()) {
                List<CheckedOutBooks> placeVal = checkedOutBooksRepo.findByProductIDEqualsNative(idInt);
                for (CheckedOutBooks book : placeVal) {
                    Book tmpBook = bookRepo.findByProductIDEqualsNativeOne(book.bookID);
                    Pickup tmpProd = new Pickup(tmpBook.title, book.borrowdate);
                    product.add(tmpProd);

                }
            } else {
                product.add("Nothing");
            }
            if (!checkedOutMoviesRepo.findByProductIDEqualsNative(idInt).isEmpty()) {
                List<CheckedOutMovies> placeVal = checkedOutMoviesRepo.findByProductIDEqualsNative(idInt);
                for (CheckedOutMovies movie : placeVal) {

                    Movie tmpMovie = movieRepo.findByProductIDEqualsNativeOne(movie.movieID);
                    Pickup tmpProd = new Pickup(tmpMovie.title, movie.borrowdate);
                    product.add(tmpProd);
                }
            } else {
                product.add("Nothing");
            }
            if (!checkedOutJournalsRepo.findByProductIDEqualsNative(idInt).isEmpty()) {
                List<CheckedOutJournals> placeVal = checkedOutJournalsRepo.findByProductIDEqualsNative(idInt);
                for (CheckedOutJournals journal : placeVal) {
                    Journal tmpJournal = journalRepo.findByProductIDEqualsNativeOne(journal.journalID);
                    Pickup tmpProd = new Pickup(tmpJournal.title, journal.borrowdate);
                    product.add(tmpProd);
                }
            } else {
                product.add("Nothing");
            }
            if (!product.isEmpty()) {
                return new ResponseEntity<>(product, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody String loginInfo) {

        try {
            int idInt = Integer.parseInt(loginInfo.substring(0, loginInfo.length() - 1));
            Customer customer = customerRepo.findByProductIDEqualsNative(idInt);
            Admin admin = adminRepo.findByProductIDEqualsNative(idInt);
            Employee employee = employeeRepo.findByProductIDEqualsNative(idInt);

            if (customer != null) {
                return new ResponseEntity<>(customer, HttpStatus.OK);
            } else if (admin != null) {
                return new ResponseEntity<>(admin, HttpStatus.OK);
            } else if (employee != null) {
                return new ResponseEntity<>(employee, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/productregis")
    public ResponseEntity bookProduct(@RequestBody String id) {
        try {
            String noChara = id.replaceAll("[^a-zA-Z0-9_-]", "");
            int idInt = Integer.parseInt(noChara.substring(noChara.indexOf("prodId") + 6, noChara.indexOf("custId")));
            int custIdInt = Integer.parseInt(noChara.substring(noChara.indexOf("custId") + 6));

            List<Book> book = bookRepo.findByProductIDEqualsNative(idInt);
            List<Movie> movie = movieRepo.findByProductIDEqualsNative(idInt);
            List<Journal> journal = journalRepo.findByProductIDEqualsNative(idInt);

            if (!journal.isEmpty()) {
                CheckedOutJournals checkedOutJournals =
                        new CheckedOutJournals(idInt, custIdInt,
                                LocalDate.now().plusWeeks(2).toString(), LocalDate.now().toString(), "$15.00");
                checkedOutJournalsRepo.save(checkedOutJournals);
                journalRepo.reserveJournalNative(idInt);
                return new ResponseEntity<>(HttpStatus.OK);
            } else if (!movie.isEmpty()) {
                CheckedOutMovies checkedOutMovies =
                        new CheckedOutMovies(idInt, custIdInt,
                                LocalDate.now().plusWeeks(2).toString(), LocalDate.now().toString(), "$15.00");
                checkedOutMoviesRepo.save(checkedOutMovies);
                movieRepo.reserveMovieNative(idInt);
                return new ResponseEntity<>(HttpStatus.OK);
            } else if (!book.isEmpty()) {
                CheckedOutBooks checkedOutBooks =
                        new CheckedOutBooks(idInt, custIdInt,
                                LocalDate.now().plusWeeks(2).toString(), LocalDate.now().toString(), "$15.00");
                checkedOutBooksRepo.save(checkedOutBooks);
                bookRepo.reserveBookNative(idInt);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/overdue/pay")
    public ResponseEntity payOverdue(@RequestBody String id) {
        try {
            int idInt = Integer.parseInt(id);
            CheckedOutJournals journal = checkedOutJournalsRepo.findByProductID(idInt);
            CheckedOutBooks book = checkedOutBooksRepo.findByProductID(idInt);
            CheckedOutMovies movie = checkedOutMoviesRepo.findByProductID(idInt);
            if (journal != null) {
                checkedOutJournalsRepo.payOverdueJournalNative(idInt);
            } else if (book != null) {
                checkedOutBooksRepo.payOverdueBookNative(idInt);
            } else if (movie != null) {
                checkedOutMoviesRepo.payOverdueMovieNative(idInt);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/signup")
    public ResponseEntity register(@RequestBody Customer customer) {
        try {
            customerRepo.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/create/book")
    public ResponseEntity registerNewBook(@RequestBody Book book) {
        try {
            bookRepo.save(book);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/create/journal")
    public ResponseEntity registerNewJournal(@RequestBody Journal journal) {
        try {
            journalRepo.save(journal);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/create/movie")
    public ResponseEntity registerNewMovie(@RequestBody Movie movie) {
        try {
            movieRepo.save(movie);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

