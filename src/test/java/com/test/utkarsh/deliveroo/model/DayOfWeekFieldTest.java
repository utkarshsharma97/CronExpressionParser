package com.test.utkarsh.deliveroo.model;

import com.utkarsh.deliveroo.exceptions.InvalidCronFieldFormatException;
import com.utkarsh.deliveroo.model.DayOfWeekField;
import com.utkarsh.deliveroo.parser.FieldParser;
import com.utkarsh.deliveroo.parser.StandardFieldParser;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DayOfWeekFieldTest {
    private final FieldParser parser = new StandardFieldParser();

    @Test
    public void testValidDayOfWeekField() {
        DayOfWeekField field = new DayOfWeekField("1,3,7", parser);
        assertDoesNotThrow(field::validate);
    }

    @Test
    public void testInvalidDayOfWeekField() {
        DayOfWeekField field = new DayOfWeekField("8", parser);
        assertThrows(InvalidCronFieldFormatException.class, field::validate);
    }
}
