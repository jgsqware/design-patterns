package be.snypit.design.pattern.strategy;

import be.snypit.design.pattern.strategy.strategies.impl.DefaultPreProcessorStrategy;
import be.snypit.design.pattern.strategy.strategies.impl.LongPreProcessorStrategy;
import be.snypit.design.pattern.strategy.strategies.PreProcessorStrategy;
import be.snypit.design.pattern.strategy.strategies.impl.StringPreProcessorStrategy;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class PreProcessor implements Function<Object,Object> {

    private final Map<Class, PreProcessorStrategy> preprocessors;
    private final PreProcessorStrategy defaultPreProcessorStrategy;

    public PreProcessor() {
        this.preprocessors = ImmutableMap.<Class, PreProcessorStrategy>builder()
                .put(String.class, new StringPreProcessorStrategy())
                .put(Long.class, new LongPreProcessorStrategy())
                .build();
        this.defaultPreProcessorStrategy = new DefaultPreProcessorStrategy();
    }


    public <F> Object preprocess(F from) {
        return Optional
                .fromNullable(preprocessors.get(from.getClass()))
                .or(defaultPreProcessorStrategy)
                .apply(from);
    }

    public Object apply(Object o) {
        return preprocess(o);
    }

    public boolean equals(Object o) {
        return false;
    }
}
