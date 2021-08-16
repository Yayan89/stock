package com.rbc.stock.service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.rbc.stock.domain.model.StockBody;
import com.rbc.stock.entity.StockEntity;
import com.rbc.stock.mapper.StockMapper;
import com.rbc.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    @Autowired
    public StockService(StockRepository stockRepository, StockMapper stockMapper) {
        this.stockRepository = stockRepository;
        this.stockMapper = stockMapper;
    }

    public void uploadFile(MultipartFile multipartFile) throws IOException {
        List<StockEntity> reader = new CsvToBeanBuilder<StockEntity>(new BufferedReader(new InputStreamReader(multipartFile.getInputStream())))
                .withType(StockEntity.class)
                .build()
                .parse();

        stockRepository.saveAll(reader);
    }

    public List<StockEntity> getStock(String ticker) {
        return stockRepository.findAllByStock(ticker);
    }

    public StockEntity postStock(StockBody stockBody) {
        StockEntity stockEntity = stockMapper.convertStockToStockEntity(stockBody);
        return stockRepository.save(stockEntity);
    }
}