package com.rbc.stock;

import com.rbc.stock.entity.StockEntity;
import com.rbc.stock.mapper.StockMapper;
import com.rbc.stock.mapper.StockMapperImpl;
import com.rbc.stock.repository.StockRepository;
import com.rbc.stock.service.StockService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UnitTestsExample {

    @Mock
    private StockRepository stockRepository;

    @Test
    void simple_unitTest() {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setStock("AA");
        stockEntity.setClose(new BigDecimal("99.99"));

        Mockito.when(stockRepository.findAllByStock(Mockito.anyString()))
                .thenReturn(List.of(stockEntity));

        StockMapper stockMapper = new StockMapperImpl();
        StockService stockService = new StockService(stockRepository, stockMapper);

        List<StockEntity> list = stockService.getStock("AA");

        assertThat(list).isEqualTo(List.of(stockEntity));
    }

}
