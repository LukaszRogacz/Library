package com.crud.kodillalibrary;


import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.Reader;
import com.crud.kodillalibrary.domain.Rental;
import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.repository.BookRepository;
import com.crud.kodillalibrary.repository.ReaderRepository;
import com.crud.kodillalibrary.repository.RentalRepository;
import com.crud.kodillalibrary.repository.TitleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KodillaLibraryTestSuite {

    @Autowired
    TitleRepository titleRepository;
    @Autowired
    RentalRepository rentalRepository;
    @Autowired
    ReaderRepository readerRepository;
    @Autowired
    BookRepository bookRepository;

    @Test
    public void testRentalSave() {
        //Given
        Title title = new Title("M or N", "Agatha Christie", 1956);
        titleRepository.save(title);
        Book book1 = new Book(title, "available");
        bookRepository.save(book1);
        title.getBooks().add(book1);
        Reader reader = new Reader("Lukasz", "Rogacz", new Date());
        Rental rental = new Rental(new Date(), new Date());
        rental.setReader(reader);
        rental.setBook(book1);
        reader.getRentals().add(rental);
        book1.getRentals().add(rental);

        //When
        titleRepository.save(title);
        bookRepository.save(book1);
        readerRepository.save(reader);
        rentalRepository.save(rental);

        long titleId = title.getId();
        long readerId = reader.getId();
        long bookId = book1.getId();
        long rentalId = rental.getId();

        //Then
        Assert.assertNotEquals(0, titleId);
        Assert.assertNotEquals(0, readerId);
        Assert.assertNotEquals(0, bookId);
        Assert.assertNotEquals(0, rentalId);
        //CleanUp
        titleRepository.delete(titleId);
        readerRepository.delete(readerId);

    }

}
