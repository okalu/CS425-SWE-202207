package edu.miu.cs.cs425.fairfieldlibrarycliapp.service.impl;

import edu.miu.cs.cs425.fairfieldlibrarycliapp.model.Book;
import edu.miu.cs.cs425.fairfieldlibrarycliapp.repository.BookRepository;
import edu.miu.cs.cs425.fairfieldlibrarycliapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addNewBook(Book book) {
        return bookRepository.save(book);
    }
}
