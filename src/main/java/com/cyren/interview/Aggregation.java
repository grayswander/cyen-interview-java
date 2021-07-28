package com.cyren.interview;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public class Aggregation {
    private Date periodStart;
    private String type;
    private long count;
}
