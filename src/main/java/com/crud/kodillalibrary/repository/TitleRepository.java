package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TitleRepository extends CrudRepository<Title, Long> {

    @Override
    Title save(Title title);

    @Override
    Title findOne(Long aLong);

    @Override
    List<Title> findAll();

    @Override
    void deleteAll();
}
