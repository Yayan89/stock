package com.rbc.stock.controller;

import com.rbc.stock.domain.model.StockBody;
import com.rbc.stock.entity.StockEntity;
import com.rbc.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/rbc/stock/")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/file/")
    public void uploadFile(@RequestPart("file") MultipartFile multipartFile) throws IOException {
        stockService.uploadFile(multipartFile);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockEntity>> getStock(@RequestParam String ticker) {
        return new ResponseEntity<>(stockService.getStock(ticker), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StockEntity> uploadStock(@RequestBody StockBody stockBody) {
        return new ResponseEntity<>(stockService.postStock(stockBody), HttpStatus.CREATED);
    }
}