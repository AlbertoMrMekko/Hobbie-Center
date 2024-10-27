package com.AlbertoMrMekko.hobbiecenter.rest.api;

import com.AlbertoMrMekko.hobbiecenter.model.Saga;
import com.AlbertoMrMekko.hobbiecenter.model.enums.SagaStatusEnum;
import com.AlbertoMrMekko.hobbiecenter.service.SagaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sagas")
public class SagaController
{
    @Autowired
    private SagaService service;

    @PostMapping
    public ResponseEntity<Saga> addSaga(@RequestBody @Valid Saga saga)
    {
        Saga newSaga = this.service.addSaga(saga);

        return ResponseEntity.status(HttpStatus.CREATED).body(newSaga);
    }

// TODO de aqui hacia abajo no está hecho
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
        Book book =
                this.service.getBookById(id).orElseThrow(() -> new EntityNotFoundException("Book with id " + id +
                        "does not exist"));

        // TODO mirar GMV para hacer bien el orElseThrow

        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")  // TODO patch
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
