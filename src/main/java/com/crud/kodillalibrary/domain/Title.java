package com.crud.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TITLES")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "TITLE")
    @NotNull
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "ISSUE_DATE")
    @NotNull
    private int issueDate;

    @JsonIgnore
    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "title",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER
    )
    private List<Book> books = new ArrayList<>();

    public Title(String title, String author, int issueDate) {
        this.title = title;
        this.author = author;
        this.issueDate = issueDate;
    }
}
