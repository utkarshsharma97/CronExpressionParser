package com.utkarsh.deliveroo.model;

import com.utkarsh.deliveroo.Constants;
import com.utkarsh.deliveroo.exceptions.InvalidCronFieldFormatException;
import com.utkarsh.deliveroo.parser.FieldParser;

import java.util.List;

public class HourField extends CronField {
    public HourField(String expression, FieldParser parser) {
        super(expression, 0, 23, Constants.HOUR_FIELD, parser);
    }

    @Override
    public void validate() throws InvalidCronFieldFormatException {
        List<Integer> values = getValues();
        for (int value : values) {
            if (value < 0 || value > 23) {
                throw new InvalidCronFieldFormatException(
                        "Hour values must be between 0 and 23");
            }
        }
    }
}
