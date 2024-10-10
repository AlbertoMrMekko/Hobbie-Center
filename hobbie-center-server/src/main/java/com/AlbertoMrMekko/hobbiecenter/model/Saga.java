package com.AlbertoMrMekko.hobbiecenter.model;

import com.AlbertoMrMekko.hobbiecenter.model.enums.SagaEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "sagas")
public class Saga {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "cover_url")
    private String coverUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SagaEnum status;

    @Column(name = "rating", precision = 2, scale = 1)
    private BigDecimal rating;

    @OneToMany(mappedBy = "saga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    // TODO constructor
}
