package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.*;
import com.crud.kodillalibrary.mapper.BookMapper;
import com.crud.kodillalibrary.mapper.ReaderMapper;
import com.crud.kodillalibrary.mapper.RentalMapper;
import com.crud.kodillalibrary.mapper.TitleMapper;
import com.crud.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("v1/library/")
public class LibraryController {
    @Autowired
    DbService service;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    ReaderMapper readerMapper;
    @Autowired
    RentalMapper rentalMapper;
    @Autowired
    TitleMapper titleMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBook")
    public BookDto getBook(@RequestParam Long Id) {
        return bookMapper.mapToBookDto(service.getBook(Id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllBooks")
    public List<BookDto> getAllBooks() {
        return bookMapper.mapToBookDtoList(service.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto bookDto) {
        service.createBook(bookMapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBookStatus", consumes = APPLICATION_JSON_VALUE)
    public BookDto updateBookStatus(@RequestBody BookDto bookDto) {
        return bookMapper.mapToBookDto(service.updateBookStatus(bookMapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReader")
    public ReaderDto getReader(@RequestParam Long Id) {
        return readerMapper.mapToReaderDto(service.getReader(Id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllReaders")
    public List<ReaderDto> getAllReaders() {
        return readerMapper.mapToReaderDtoList(service.getAllReaders());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto) {
        service.createReader(readerMapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTitle")
    public TitleDto getTitle(@RequestParam Long Id) {
        return titleMapper.mapToTitleDto(service.getTitle(Id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllTitles")
    public List<TitleDto> getAllTitles() {
        return titleMapper.mapToTitleDtoList(service.getAllTitles());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTitle", consumes = APPLICATION_JSON_VALUE)
    public void createTitle(@RequestBody TitleDto titleDto) {
        service.createTitle(titleMapper.mapToTitle(titleDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getRental")
    public RentalDto getRental(@RequestParam Long Id) {
        return rentalMapper.mapToRentalDto(service.getRental(Id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllRentals")
    public List<RentalDto> getAllRentals() {
        return rentalMapper.mapToRentalDtoList(service.getAllRentals());
    }

    @RequestMapping(method = RequestMethod.POST, value = "bookRental", consumes = APPLICATION_JSON_VALUE)
    public void bookRental(@RequestBody RentalDto rentalDto) {
        System.out.println("in book Rental");
        if (rentalDto.getBook().getStatus().equals("available")) {
            service.createRental(rentalMapper.mapToRental(rentalDto));
            service.updateBookStatus(rentalMapper.mapToRental(rentalDto).getBook(), "rented");
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "bookReturn", consumes = APPLICATION_JSON_VALUE)
    public RentalDto bookReturn(@RequestBody RentalDto rentalDto) {
        if (rentalDto.getBook().getStatus().equals("rented")) {
            service.updateBookStatus(rentalMapper.mapToRental(rentalDto).getBook(), "available");
        }
        return rentalMapper.mapToRentalDto(service.updateRentalByReturn(rentalMapper.mapToRental(rentalDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "checkQuantityBookAvailable")
    public long checkQuantityBookAvailable(@RequestParam String titleName) {
        return service.checkQuantityBookAvailable(titleName);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteAll")
    public void deleteAll() {
        service.deleteAll();
    }

}
