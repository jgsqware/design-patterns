package be.snypit.design.pattern.strategy;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PreProcessorTest {


    @Test
    public void preProcess() throws Exception {
        Date date = new Date();
        Map map = new HashMap();
        Long dateAsLong = date.getTime();
        String dateAsString = new SimpleDateFormat("yyyy-MM-dd").format(date);

        Map<String, Object> stringObjectMap = ImmutableMap.<String, Object>builder()
                .put("date_as_String", new SimpleDateFormat("yyyy-MM-dd").format(date))
                .put("date_as_Long", date.getTime())
                .put("String", "Only_a_string")
                .put("Map", map)
                .build();


        Map<String, Object> preProcessedMap = Maps.transformEntries(
                stringObjectMap,
                new ConditionalEntryTransformer<String, Object, Object>(
                        new PreProcessorPredicate(),
                        new PreProcessor()));

        assertThat(dateAsLong, equalTo(((Date) preProcessedMap.get("date_as_Long")).getTime()));
        assertThat(dateAsString, equalTo(new SimpleDateFormat("yyyy-MM-dd").format((Date) preProcessedMap.get("date_as_String"))));
        assertThat("Only_a_string",equalTo(preProcessedMap.get("String")));
        assertThat(map, equalTo(preProcessedMap.get("Map")));
    }
}