package be.snypit.design.pattern.strategy.strategies.impl;

import be.snypit.design.pattern.strategy.strategies.PreProcessorStrategy;

public class DefaultPreProcessorStrategy implements PreProcessorStrategy<Object, Object> {

    public Object apply(Object o) {
        return o;
    }
}
