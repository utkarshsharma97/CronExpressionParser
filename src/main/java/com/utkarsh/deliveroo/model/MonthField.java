package com.utkarsh.deliveroo.model;

import com.utkarsh.deliveroo.Constants;
import com.utkarsh.deliveroo.exceptions.InvalidCronFieldFormatException;
import com.utkarsh.deliveroo.parser.FieldParser;

import java.util.List;

public class MonthField extends CronField {
    public MonthField(String expression, FieldParser parser) {
        super(expression, 1, 12, Constants.MONTH_FIELD, parser);
    }

    @Override
    public void validate() throws InvalidCronFieldFormatException {
        List<Integer> values = getValues();
        for (int value : values) {
            if (value < 1 || value > 12) {
                throw new InvalidCronFieldFormatException(
                        "Month values must be between 1 and 12");
            }
        }
    }
}
