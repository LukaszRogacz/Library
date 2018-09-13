package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.Reader;
import com.crud.kodillalibrary.domain.Rental;
import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.repository.BookRepository;
import com.crud.kodillalibrary.repository.ReaderRepository;
import com.crud.kodillalibrary.repository.RentalRepository;
import com.crud.kodillalibrary.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DbService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    ReaderRepository readerRepository;
    @Autowired
    RentalRepository rentalRepository;
    @Autowired
    TitleRepository titleRepository;

    public Book getBook(Long id) {
        return bookRepository.findOne(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBookStatus(Book book) {
        Book originalBook = bookRepository.findOne(book.getId());
        return bookRepository.save(new Book(
                originalBook.getId(),
                originalBook.getTitle(),
                book.getStatus(),
                originalBook.getRentals()
        ));
    }

    public Book updateBookStatus(Book book, String newStatus) {
        Book originalBook = bookRepository.findOne(book.getId());
        return bookRepository.save(new Book(
                originalBook.getId(),
                originalBook.getTitle(),
                newStatus,
                originalBook.getRentals()
        ));
    }


    public Reader getReader(Long id) {
        return readerRepository.findOne(id);
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public Reader createReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public Rental getRental(Long id) {
        return rentalRepository.findOne(id);
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental createRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    public Rental updateRentalByReturn(Rental rental) {
        Rental originalRental = rentalRepository.findOne(rental.getId());
        return rentalRepository.save(new Rental(
                originalRental.getId(),
                originalRental.getBook(),
                originalRental.getReader(),
                originalRental.getRentalDate(),
                new Date()
        ));
    }

    public Title getTitle(Long id) {
        return titleRepository.findOne(id);
    }

    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }

    public Title createTitle(Title title) {
        return titleRepository.save(title);
    }

    public long checkQuantityBookAvailable(String titleName) {
        System.out.println(titleName);
        return bookRepository.findAll().stream()
                .filter(n -> ("available").equals(n.getStatus()))
                .filter(n -> titleName.equals(n.getTitle().getTitle()))
                .count();

    }

    public void deleteAll() {
        rentalRepository.deleteAll();
        titleRepository.deleteAll();
        bookRepository.deleteAll();
        readerRepository.deleteAll();
    }

}
