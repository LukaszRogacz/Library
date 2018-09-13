package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Rental;
import com.crud.kodillalibrary.domain.RentalDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentalMapper {
    public Rental mapToRental(RentalDto rentalDto) {
        return new Rental(
                rentalDto.getId(),
                rentalDto.getBook(),
                rentalDto.getReader(),
                rentalDto.getRentalDate(),
                rentalDto.getReturnDate()
        );
    }

    public RentalDto mapToRentalDto(Rental rental) {
        return new RentalDto(
                rental.getId(),
                rental.getBook(),
                rental.getReader(),
                rental.getRentalDate(),
                rental.getReturnDate()
        );
    }

    public List<RentalDto> mapToRentalDtoList(List<Rental> rentalList) {
        return rentalList.stream()
                .map(n -> new RentalDto(n.getId(), n.getBook(), n.getReader(), n.getRentalDate(), n.getReturnDate()))
                .collect(Collectors.toList());
    }

}
