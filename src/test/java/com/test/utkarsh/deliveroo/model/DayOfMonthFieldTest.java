package com.test.utkarsh.deliveroo.model;

import com.utkarsh.deliveroo.exceptions.InvalidCronFieldFormatException;
import com.utkarsh.deliveroo.model.DayOfMonthField;
import com.utkarsh.deliveroo.parser.FieldParser;
import com.utkarsh.deliveroo.parser.StandardFieldParser;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DayOfMonthFieldTest {
    private final FieldParser parser = new StandardFieldParser();

    @Test
    public void testValidDayOfMonthField() {
        DayOfMonthField field = new DayOfMonthField("1,15,31", parser);
        assertDoesNotThrow(field::validate);
    }

    @Test
    public void testInvalidDayOfMonthField() {
        DayOfMonthField field = new DayOfMonthField("0", parser);
        assertThrows(InvalidCronFieldFormatException.class, field::validate);
    }
}
