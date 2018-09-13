package com.crud.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    @NotNull
    private Title title;

    @Column(name = "STATUS")
    @NotNull
    private String status;

    @JsonIgnore
    @OneToMany(
            targetEntity = Rental.class,
            mappedBy = "book",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER
    )
    private List<Rental> rentals = new ArrayList<>();

    public Book(Title title, String status) {
        this.title = title;
        this.status = status;
    }

    public Book(String status) {
        this.status = status;
    }
}
