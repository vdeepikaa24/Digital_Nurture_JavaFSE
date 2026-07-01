package com.cognizant.orm_learn_2.repository;

import com.cognizant.orm_learn_2.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);

    List<Stock> findByCodeAndCloseGreaterThan(String code, double price);

    List<Stock> findTop3ByOrderByVolumeDesc();

    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}