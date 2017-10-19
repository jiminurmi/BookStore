package com.example.bookstore;


import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BookstoreApplication {

    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}


	@Bean
    public CommandLineRunner book(BookRepository repository, UserRepository urepository) {
	    return (args) -> {
	        log.info("books to the list!");
	        repository.save(new Book("Testauksen Salat", "Jarmo Testaaja", 2013, "123456789-1234", 30.00));
            repository.save(new Book("NHL", "Hoki-Tero", 1999, "123456789-1235", 13.99));
            repository.save(new Book("Koodaa peli", "Pelimias", 2018, "123456789-1236", 100.99));

            User user1 = new User("user",
                    "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
            User user2 = new User("admin",
                    "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
            urepository.save(user1);
            urepository.save(user2);


            log.info("retrieve booklist");
	        for (Book book : repository.findAll()){
	                log.info(book.toString());
            }
            log.info("");
	    };

    }

}
