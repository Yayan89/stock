package com.rbc.stock.converter;

import com.opencsv.bean.AbstractBeanField;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
public class MonetaryConverter extends AbstractBeanField {
    @SneakyThrows
    @Override
    protected Object convert(String s) {
        return new BigDecimal(StringUtils.remove(s, '$'));
    }
}