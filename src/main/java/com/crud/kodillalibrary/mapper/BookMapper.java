package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public Book mapToBook(BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getStatus(),
                bookDto.getRentals()
        );
    }

    public BookDto mapToBookDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getStatus(),
                book.getRentals()
        );
    }

    public List<BookDto> mapToBookDtoList(List<Book> bookList) {
        return bookList.stream()
                .map(n -> new BookDto(n.getId(), n.getTitle(), n.getStatus(), n.getRentals()))
                .collect(Collectors.toList());
    }
}
