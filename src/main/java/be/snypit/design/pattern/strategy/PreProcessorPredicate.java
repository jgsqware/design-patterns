package be.snypit.design.pattern.strategy;

import com.google.common.base.Predicate;

import java.util.regex.Pattern;

public class PreProcessorPredicate implements Predicate<String> {

    private static final Pattern pattern = Pattern.compile("date", Pattern.CASE_INSENSITIVE + Pattern.LITERAL);

    public boolean apply(String s) {
        return pattern.matcher(s).find();
    }
}
