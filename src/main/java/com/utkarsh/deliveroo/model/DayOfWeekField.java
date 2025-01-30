package com.utkarsh.deliveroo.model;

import com.utkarsh.deliveroo.Constants;
import com.utkarsh.deliveroo.exceptions.InvalidCronFieldFormatException;
import com.utkarsh.deliveroo.parser.FieldParser;

import java.util.List;

public class DayOfWeekField extends CronField {
    public DayOfWeekField(String expression, FieldParser parser) {
        super(expression, 1, 7, Constants.DAY_OF_WEEK_FIELD, parser);
    }

    @Override
    public void validate() throws InvalidCronFieldFormatException {
        List<Integer> values = getValues();
        for (int value : values) {
            if (value < 1 || value > 7) {
                throw new InvalidCronFieldFormatException(
                        "Day of week values must be between 1 and 7");
            }
        }
    }
}
