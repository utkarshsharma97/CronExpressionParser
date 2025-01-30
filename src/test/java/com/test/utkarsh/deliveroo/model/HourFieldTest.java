package com.test.utkarsh.deliveroo.model;

import com.utkarsh.deliveroo.exceptions.InvalidCronFieldFormatException;
import com.utkarsh.deliveroo.model.HourField;
import com.utkarsh.deliveroo.parser.FieldParser;
import com.utkarsh.deliveroo.parser.StandardFieldParser;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HourFieldTest {
    private final FieldParser parser = new StandardFieldParser();

    @Test
    public void testValidHourField() {
        HourField field = new HourField("0,12,23", parser);
        assertDoesNotThrow(field::validate);
    }

    @Test
    public void testInvalidHourField() {
        HourField field = new HourField("24", parser);
        assertThrows(InvalidCronFieldFormatException.class, field::validate);
    }
}
