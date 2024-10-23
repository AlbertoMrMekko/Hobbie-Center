package com.AlbertoMrMekko.hobbiecenter.rest.api;

import com.AlbertoMrMekko.hobbiecenter.model.Book;
import com.AlbertoMrMekko.hobbiecenter.model.enums.BookStatusEnum;
import com.AlbertoMrMekko.hobbiecenter.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController
{
    @Autowired
    private BookService service;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody @Valid Book book)
    {
        if (book.getId() != null || book.getRating() != null || (book.getStatus() != BookStatusEnum.AVAILABLE && book.getStatus() != BookStatusEnum.NOT_AVAILABLE))
        {
            throw new IllegalArgumentException("Validations failed");
        }
        Book newBook = this.service.addBook(book);

        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(@RequestParam(required = false) BookStatusEnum status)
    {
        List<Book> books;

        if (status == null)
        {
            books = this.service.getAllBooks();
        }
        else
        {
            books = this.service.getBooksByStatus(status);
        }

        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id)
    {
        Book book = this.service.getBookById(id).orElseThrow(() -> new EntityNotFoundException("Book with id " + id + "does not exist"));

        // TODO mirar GMV para hacer bien el orElseThrow

        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book)
    {
        // TODO update con orElseThrow EntityNotFoundEx (y comprobaciones correspondientes de book
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id)
    {
        this.service.deleteBook(id);

        return ResponseEntity.noContent().build();
    }
}
