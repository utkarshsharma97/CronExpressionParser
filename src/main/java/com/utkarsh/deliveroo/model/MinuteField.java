package com.utkarsh.deliveroo.model;

import com.utkarsh.deliveroo.Constants;
import com.utkarsh.deliveroo.exceptions.InvalidCronFieldFormatException;
import com.utkarsh.deliveroo.parser.FieldParser;

import java.util.List;

public class MinuteField extends CronField {
    public MinuteField(String expression, FieldParser parser) {
        super(expression, 0, 59, Constants.MINUTE_FIELD, parser);
    }

    @Override
    public void validate() throws InvalidCronFieldFormatException {
        List<Integer> values = getValues();
        for (int value : values) {
            if (value < 0 || value > 59) {
                throw new InvalidCronFieldFormatException(
                        "Minute values must be between 0 and 59");
            }
        }
    }
}
