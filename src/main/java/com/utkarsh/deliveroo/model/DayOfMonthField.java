package com.utkarsh.deliveroo.model;

import com.utkarsh.deliveroo.Constants;
import com.utkarsh.deliveroo.exceptions.InvalidCronFieldFormatException;
import com.utkarsh.deliveroo.parser.FieldParser;

import java.util.List;

public class DayOfMonthField extends CronField {
    public DayOfMonthField(String expression, FieldParser parser) {
        super(expression, 1, 31, Constants.DAY_OF_MONTH_FIELD, parser);
    }

    @Override
    public void validate() throws InvalidCronFieldFormatException {
        List<Integer> values = getValues();
        for (int value : values) {
            if (value < 1 || value > 31) {
                throw new InvalidCronFieldFormatException(
                        "Day of month values must be between 1 and 31");
            }
        }
    }
}
