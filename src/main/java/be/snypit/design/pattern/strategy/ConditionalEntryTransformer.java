package be.snypit.design.pattern.strategy;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

public class ConditionalEntryTransformer<K, F, T> implements Maps.EntryTransformer<K, F, T> {

    private final Predicate<K> predicate;
    private final Function<F, T> transformer;

    public ConditionalEntryTransformer(Predicate<K> predicate, Function<F, T> transformer) {
        this.predicate = predicate;
        this.transformer = transformer;
    }

    public T transformEntry(K key, F value) {
        return predicate.apply(key)
                ? transformer.apply(value)
                : (T) value;
    }
}
