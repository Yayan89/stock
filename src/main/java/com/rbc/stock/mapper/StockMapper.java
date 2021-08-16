package com.rbc.stock.mapper;

import com.rbc.stock.domain.model.StockBody;
import com.rbc.stock.entity.StockEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StockMapper {
    @Mapping(target = "id", ignore = true)
    StockEntity convertStockToStockEntity(StockBody stockBody);
}
