package com.AlbertoMrMekko.hobbiecenter.model;

import com.AlbertoMrMekko.hobbiecenter.model.enums.BookStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Entity
@Table(name = "books")
public class Book
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "title", unique = true, nullable = false)
    @NotEmpty
    private String title;

    @Column(name = "number_of_pages", nullable = false)
    @Min(1)
    private Integer numberOfPages;

    @Column(name = "cover_url", nullable = false)
    @NotEmpty
    private String coverUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BookStatusEnum status;

    @Column(name = "rating", precision = 2, scale = 1)
    private BigDecimal rating;

    @ManyToOne
    @JoinColumn(name = "saga_id")
    @NotNull
    private Saga saga;

    // TODO constructor
}
