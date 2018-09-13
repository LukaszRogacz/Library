package com.crud.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private Title title;
    private String status;
    @JsonIgnore
    private List<Rental> rentals;

    public BookDto(String status) {
        this.status = status;
    }

    public BookDto(Title title, String status) {
        this.title = title;
        this.status = status;
    }
}
