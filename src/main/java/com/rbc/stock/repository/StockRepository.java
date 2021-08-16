package com.rbc.stock.repository;

import com.rbc.stock.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends CrudRepository<StockEntity, Integer> {
    List<StockEntity> findAllByStock(String ticker);
}