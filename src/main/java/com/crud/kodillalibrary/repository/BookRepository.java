package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    Book save(Book book);

    @Override
    List<Book> findAll();

    @Override
    void deleteAll();

    @Override
    Book findOne(Long aLong);
}
