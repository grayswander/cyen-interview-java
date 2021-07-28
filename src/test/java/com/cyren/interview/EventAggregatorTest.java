package com.cyren.interview;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class EventAggregatorTest {

    @Test
    void aggregateUnorderedCollection() {
        EventAggregator aggregator = new EventAggregatorSupplier().get();
        Collection<Aggregation> aggregations = aggregator.aggregateUnorderedCollection(Utility.buildUnorderedInputList(), "yyyy-MM-dd");
        assertTrue(Utility.collectionContentsEqual(Utility.getExpectedOutput(), aggregations));
    }

    @Test
    void aggregateOrderedStream() {
        EventAggregator aggregator = new EventAggregatorSupplier().get();
        List<Aggregation> aggregations = aggregator.aggregateOrderedStream(Utility.buildOrderedInputStream(), "yyyy-MM-dd").collect(Collectors.toList());
        assertTrue(Utility.collectionContentsEqual(Utility.getExpectedOutput(), aggregations));
    }
}