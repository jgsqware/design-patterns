package be.snypit.design.pattern.strategy.strategies.impl;

import be.snypit.design.pattern.strategy.strategies.PreProcessorStrategy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringPreProcessorStrategy implements PreProcessorStrategy<String, Date> {

    private final SimpleDateFormat simpleDateFormat;

    public StringPreProcessorStrategy() {
        this("yyyy-MM-dd");
    }

    public StringPreProcessorStrategy(String dateformat) {
        simpleDateFormat = new SimpleDateFormat(dateformat);
    }

    public Date apply(String s) {
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
