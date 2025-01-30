package com.test.utkarsh.deliveroo.model;

import com.utkarsh.deliveroo.exceptions.InvalidCronFieldFormatException;
import com.utkarsh.deliveroo.model.MonthField;
import com.utkarsh.deliveroo.parser.FieldParser;
import com.utkarsh.deliveroo.parser.StandardFieldParser;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MonthFieldTest {
    private final FieldParser parser = new StandardFieldParser();

    @Test
    public void testValidMonthField() {
        MonthField field = new MonthField("1,6,12", parser);
        assertDoesNotThrow(field::validate);
    }

    @Test
    public void testInvalidMonthField() {
        MonthField field = new MonthField("13", parser);
        assertThrows(InvalidCronFieldFormatException.class, field::validate);
    }
}
