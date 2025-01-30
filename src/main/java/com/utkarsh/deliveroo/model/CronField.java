package com.utkarsh.deliveroo.model;

import com.utkarsh.deliveroo.exceptions.InvalidCronFieldFormatException;
import com.utkarsh.deliveroo.parser.FieldParser;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CronField {
    protected final String expression;
    protected final int minValue;
    protected final int maxValue;
    protected final String fieldName;
    protected final FieldParser parser;

    public CronField(String expression, int minValue, int maxValue,
                     String fieldName, FieldParser parser) {
        this.expression = expression;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.fieldName = fieldName;
        this.parser = parser;
    }

    public List<Integer> getValues() {
        return parser.parse(expression, minValue, maxValue);
    }

    public String format() {
        return String.format("%-14s%s", fieldName,
                getValues().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ")));
    }

    public abstract void validate() throws InvalidCronFieldFormatException;
}
