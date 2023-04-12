package com.group57.librarybackend.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

import com.group57.librarybackend.query.repository.*;
import com.group57.librarybackend.query.model.*;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.group57.librarybackend.query"})
public class LibrarybackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LibrarybackendApplication.class, args);
	}
	@Autowired(required = false)
	CustomerRepository customerRepo;
	@Override
	public void run(String... args) throws Exception {
		// call Repository methods here

	}
}
