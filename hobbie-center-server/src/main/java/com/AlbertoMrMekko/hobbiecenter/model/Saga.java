package com.AlbertoMrMekko.hobbiecenter.model;

import com.AlbertoMrMekko.hobbiecenter.model.enums.SagaStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Entity
@Table(name = "sagas")
public class Saga
{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "title", unique = true, nullable = false)
    @NotEmpty
    private String title;

    @Column(name = "author", nullable = false)
    @NotEmpty
    private String author;

    @Column(name = "cover_url")
    private String coverUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SagaStatusEnum status;

    @Column(name = "rating", precision = 2, scale = 1)
    private BigDecimal rating;

    @OneToMany(mappedBy = "saga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    // TODO constructor

    public boolean validateSagaCreation()
    {
        return (id != null || rating != null || status != null || books != null);
    }
}
