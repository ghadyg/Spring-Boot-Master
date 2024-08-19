package com.spring_boot.Books;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    public List<Book> selectAllBooks() {
        return List.of(new Book("LOTR","JKROWling"));
    }

    public Optional<Book> selectBook(String name) {
        return Optional.of(new Book(name, "Ghady"));
    }
}
