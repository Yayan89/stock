package com.rbc.stock.entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.rbc.stock.converter.DateConverter;
import com.rbc.stock.converter.MonetaryConverter;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "STOCK")
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CsvBindByName(column = "quarter")
    private int quarter;
    @CsvBindByName(column = "stock")
    private String stock;
    @CsvCustomBindByName(column = "date", converter = DateConverter.class)
    private String date;
    @CsvCustomBindByName(column = "open", converter = MonetaryConverter.class)
    private BigDecimal open;
    @CsvCustomBindByName(column = "high", converter = MonetaryConverter.class)
    private BigDecimal high;
    @CsvCustomBindByName(column = "low", converter = MonetaryConverter.class)
    private BigDecimal low;

    @CsvCustomBindByName(column = "close", converter = MonetaryConverter.class)
    private BigDecimal close;
    @CsvBindByName(column = "volume")
    private Long volume;
    @CsvBindByName(column = "percent_change_price")
    private BigDecimal percent_change_price;
    @CsvBindByName(column = "percent_change_volume_over_last_wk")
    private BigDecimal percent_change_volume_over_last_wk;
    @CsvBindByName(column = "previous_weeks_volume")
    private Long previous_weeks_volume;

    @CsvCustomBindByName(column = "next_weeks_open", converter = MonetaryConverter.class)
    private BigDecimal next_weeks_open;
    @CsvCustomBindByName(column = "next_weeks_close", converter = MonetaryConverter.class)
    private BigDecimal next_weeks_close;
    @CsvBindByName(column = "percent_change_next_weeks_price")
    private BigDecimal percent_change_next_weeks_price;
    @CsvBindByName(column = "days_to_next_dividend")
    private int days_to_next_dividend;
    @CsvBindByName(column = "percent_return_next_dividend")
    private BigDecimal percent_return_next_dividend;
}
