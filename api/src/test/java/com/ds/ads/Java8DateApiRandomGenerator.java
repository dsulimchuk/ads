package com.ds.ads;

import com.openpojo.random.RandomFactory;
import com.openpojo.random.RandomGenerator;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

/**
 * Created by ds on 10/04/16.
 */
public class Java8DateApiRandomGenerator implements RandomGenerator {
    private static final Class<?>[] TYPES = new Class<?>[]{
            ZonedDateTime.class,
            ZoneId.class
    };
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final String[] AVAILABLE_ZONES = ZoneId.getAvailableZoneIds().toArray(new String[0]);


    @Override
    public Collection<Class<?>> getTypes() {
        return Arrays.asList(TYPES);
    }

    @Override
    public Object doGenerate(Class<?> type) {
        if (ZonedDateTime.class.equals(type)) {
            Timestamp ts = RandomFactory.getRandomValue(Timestamp.class);
            ZoneId zoneId = RandomFactory.getRandomValue(ZoneId.class);
            return ZonedDateTime.of(ts.toLocalDateTime(), zoneId);
        } else if (ZoneId.class.equals(type)) {
            return ZoneId.of(AVAILABLE_ZONES[RANDOM.nextInt(AVAILABLE_ZONES.length - 1)]);
        } else {
            throw new RuntimeException(this.getClass().toString() + " can handle only " + Arrays.toString(TYPES));
        }
    }
}
