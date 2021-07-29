package com.cyren.interview;

import reactor.core.publisher.Flux;

import java.util.Collection;
import java.util.InvalidPropertiesFormatException;
import java.util.stream.Stream;

public interface EventAggregator {

    /**
     * Aggregates unsorted events collection by type and period.
     * @param events Unsorted collection of events
     * @param periodFormat Period format string in Simple Date Format. Ex. "yyyy-MM-dd" will aggregate by date.
     * @return A collection of aggregates
     */
    Collection<Aggregation> aggregateUnorderedCollection(Collection<Event> events, String periodFormat);

    /**
     * Aggregates stream of events, sorted by timestamp, by type and period.
     * @param events Stream of events, sorted by timestamp.
     * @param periodFormat Period format string in Simple Date Format. Ex. "yyyy-MM-dd hh:mm" will aggregate by minute.
     * @return Stream of event aggregates
     */
    Stream<Aggregation> aggregateOrderedStream(Stream<Event> events, String periodFormat);

    /**
     * Aggregate reactive stream (Flux) of events, sorted by timestamp, by type and period.
     * @param events Flux of events, sorted by timestamp.
     * @param periodFormat Period format string in Simple Date Format. Ex. "yyyy-MM-dd hh" will aggregate by hour
     * @return Flux of event aggergates
     */
    Flux<Aggregation> aggregateOrderedFlux(Flux<Event> events, String periodFormat);
}
