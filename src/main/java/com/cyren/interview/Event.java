package com.cyren.interview;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public class Event {
    private String id;
    private String type;
    private Date timestamp;
    private String message;
}
