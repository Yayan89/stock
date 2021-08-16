package com.rbc.stock.converter;

import com.opencsv.bean.AbstractBeanField;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;

public class DateConverter extends AbstractBeanField {
    @SneakyThrows
    @Override
    protected Object convert(String s) {
        var simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        var date = simpleDateFormat.parse(s);
        return simpleDateFormat.format(date);
    }
}
