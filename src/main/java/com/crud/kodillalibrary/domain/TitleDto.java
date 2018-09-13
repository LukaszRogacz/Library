package com.crud.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TitleDto {
    private Long id;
    private String title;
    private String author;
    private int issueDate;
    @JsonIgnore
    private List<Book> books;

    public TitleDto(String title, String author, int issueDate) {
        this.title = title;
        this.author = author;
        this.issueDate = issueDate;
    }
}
