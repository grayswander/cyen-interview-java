package com.cyren.interview;

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
}
