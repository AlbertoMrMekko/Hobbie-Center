package com.AlbertoMrMekko.hobbiecenter.model;

import com.AlbertoMrMekko.hobbiecenter.model.enums.BookEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "books")
public class Book
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "number_of_pages")
    private int numberOfPages;

    @Column(name = "cover_url")
    private String coverUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookEnum status;

    @Column(name = "rating", precision = 2, scale = 1)
    private BigDecimal rating;

    @ManyToOne
    @JoinColumn(name = "saga_id")
    private Saga saga;

    // TODO constructor

    
}
