package com.spring_boot.Books;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.selectAllBooks();
    }

    public Optional<Book> getBook(String name) {
        return bookRepository.selectBook(name);
    }
}
