package com.AlbertoMrMekko.hobbiecenter.service;

import com.AlbertoMrMekko.hobbiecenter.model.Book;
import com.AlbertoMrMekko.hobbiecenter.model.enums.BookStatusEnum;
import com.AlbertoMrMekko.hobbiecenter.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService
{
    @Autowired
    private BookRepository repository;

    public Book addBook(Book book)
    {
        return repository.save(book);
    }

    public List<Book> getAllBooks()
    {
        return this.repository.findAll();
    }

    public List<Book> getBooksByStatus(BookStatusEnum status)
    {
        return this.repository.findByStatus(status);
    }

    public Optional<Book> getBookById(Long id)
    {
        return this.repository.findById(id);
    }

    public void deleteBook(Long id)
    {
        if (this.repository.existsById(id))
        {
            this.repository.deleteById(id); // TODO comprobar delete/deleteById
        }
        else
        {
            throw new EntityNotFoundException("Book with id " + id + " not found"); // TODO no es obtenido por el ControllerExceptionHandler, cambiar
        }
    }
}
