package be.snypit.design.pattern.strategy.strategies.impl;

import be.snypit.design.pattern.strategy.strategies.PreProcessorStrategy;

import java.util.Date;

public class LongPreProcessorStrategy implements PreProcessorStrategy<Long, Date> {

    public Date apply(Long aLong) {
        return new Date(aLong);
    }
}
