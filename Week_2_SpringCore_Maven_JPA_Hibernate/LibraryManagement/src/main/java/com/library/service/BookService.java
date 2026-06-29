package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method (Spring XML isi ko use karega injection ke liye)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void manageLibrary() {
        System.out.println("🛠️ [Service Layer] Managing library operations...");
        bookRepository.fetchBooks(); 
    }
}