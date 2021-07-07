package com.kbaez.karinabaezch.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kbaez.karinabaezch.domain.Price;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {

	@SuppressWarnings("unchecked")
	Price save(Price price);

	Price findByCreateDate(LocalDateTime date);

	@Query(value = "SELECT AVG(p.lprice) from Prices p where p.create_date between :start and :end", nativeQuery = true)
	Double findByAvg(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

	@Query(value = "SELECT MAX(p.lprice) from Prices p", nativeQuery = true)
	Double getMaxPrice();
}
