package com.cyren.interview;

import lombok.SneakyThrows;
import reactor.core.publisher.Flux;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utility {

    public static Flux<Event> buildOrderedInputFlux() {
        return Flux.fromStream(buildOrderedInputStream());
    }

    public static List<Event> buildUnorderedInputList() {
        List<Event> eventList = buildOrderedInputStream().collect(Collectors.toList());
        Collections.shuffle(eventList);
        return eventList;
    }

    @SneakyThrows
    public static Stream<Event> buildOrderedInputStream() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return Stream.of(
                Event.builder()
                        .id("id1")
                        .type("type1")
                        .timestamp(df.parse("2021-01-17 11:23:17"))
                        .message("Message1")
                        .build(),
                Event.builder()
                        .id("id2")
                        .type("type2")
                        .timestamp(df.parse("2021-01-17 15:23:17"))
                        .message("Message2")
                        .build(),
                Event.builder()
                        .id("id3")
                        .type("type1")
                        .timestamp(df.parse("2021-01-17 15:26:17"))
                        .message("Message3")
                        .build(),
                Event.builder()
                        .id("id4")
                        .type("type1")
                        .timestamp(df.parse("2021-01-18 11:23:17"))
                        .message("Message4")
                        .build(),
                Event.builder()
                        .id("id5")
                        .type("type2")
                        .timestamp(df.parse("2021-01-18 11:24:17"))
                        .message("Message5")
                        .build(),
                Event.builder()
                        .id("id6")
                        .type("type1")
                        .timestamp(df.parse("2021-01-18 11:25:17"))
                        .message("Message6")
                        .build(),
                Event.builder()
                        .id("id7")
                        .type("type2")
                        .timestamp(df.parse("2021-01-18 11:26:17"))
                        .message("Message7")
                        .build(),
                Event.builder()
                        .id("id8")
                        .type("type2")
                        .timestamp(df.parse("2021-01-18 11:27:17"))
                        .message("Message8")
                        .build(),
                Event.builder()
                        .id("id9")
                        .type("type1")
                        .timestamp(df.parse("2021-01-18 11:28:17"))
                        .message("Message9")
                        .build(),
                Event.builder()
                        .id("id0")
                        .type("type2")
                        .timestamp(df.parse("2021-01-18 11:28:17"))
                        .message("Message0")
                        .build()

        );
    }

    @SneakyThrows
    public static List<Aggregation> getExpectedOutput() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return Arrays.asList(
                Aggregation.builder()
                        .periodStart(df.parse("2021-01-17 00:00:00"))
                        .type("type1")
                        .count(2)
                        .build(),
                Aggregation.builder()
                        .periodStart(df.parse("2021-01-17 00:00:00"))
                        .type("type2")
                        .count(1)
                        .build(),
                Aggregation.builder()
                        .periodStart(df.parse("2021-01-18 00:00:00"))
                        .type("type1")
                        .count(3)
                        .build(),
                Aggregation.builder()
                        .periodStart(df.parse("2021-01-18 00:00:00"))
                        .type("type2")
                        .count(4)
                        .build()
        );
    }

    public static <T> boolean collectionContentsEqual(Collection<T> c1, Collection<T> c2) {
        return c1.size() == c2.size()
                && c1.containsAll(c2)
                && c2.containsAll(c1);
    }
}
