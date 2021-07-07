package com.kbaez.karinabaezch.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kbaez.karinabaezch.domain.Price;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long>  {

    Price save(Price price);

    Price findByCreateDate(LocalDateTime date);

	List<Price> findByCreateDateGreaterThanEqualAndCreateDateLessThanEqual(LocalDateTime start, LocalDateTime end);
}
