package com.rbc.stock.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockBody {
    private int quarter;
    private String stock;
    private String date;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;

    private BigDecimal close;
    private Long volume;
    private BigDecimal percent_change_price;
    private BigDecimal percent_change_volume_over_last_wk;
    private Long previous_weeks_volume;

    private BigDecimal next_weeks_open;
    private BigDecimal next_weeks_close;
    private BigDecimal percent_change_next_weeks_price;
    private int days_to_next_dividend;
    private BigDecimal percent_return_next_dividend;
}
