package com.cyren.interview;

public class Application {
    public static void main(String[] args) {
        String periodFormat = "yyyy-MM-dd";
        EventAggregator aggregator = new EventAggregatorSupplier().get();

        System.out.println("Input data");
        System.out.println("----------");
        Utility.buildUnorderedInputList().forEach(System.out::println);

        System.out.println();
        System.out.println("Period spec: " + periodFormat);

        System.out.println();
        System.out.println("Stream");
        System.out.println("----------");
        aggregator.aggregateOrderedStream(Utility.buildOrderedInputStream(), periodFormat).forEach(System.out::println);

        System.out.println();
        System.out.println("Collection");
        System.out.println("----------");
        aggregator.aggregateUnorderedCollection(Utility.buildUnorderedInputList(), periodFormat).forEach(System.out::println);
    }

}
