package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RentalRepository extends CrudRepository<Rental, Long> {
    @Override
    Rental save(Rental rental);

    @Override
    List<Rental> findAll();

    @Override
    Rental findOne(Long aLong);

    @Override
    void deleteAll();
}
