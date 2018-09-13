package com.crud.kodillalibrary.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity
@Table(name = "RENTALS")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @JoinColumn(name = "BOOK_ID")
    @ManyToOne
    private Book book;

    @NotNull
    @JoinColumn(name = "READER_ID")
    @ManyToOne
    private Reader reader;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Warsaw", locale = "PL")
    @NotNull
    @Column(name = "RENTAL_DATE")
    private Date rentalDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Warsaw", locale = "PL")
    @Column(name = "RETURN_DATE")
    private Date returnDate;

    public Rental(Date rentalDate, Date returnDate) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }
}
