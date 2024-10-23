package com.AlbertoMrMekko.hobbiecenter.repository;

import com.AlbertoMrMekko.hobbiecenter.model.Book;
import com.AlbertoMrMekko.hobbiecenter.model.enums.BookStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>
{
    List<Book> findByStatus(BookStatusEnum status);
}
