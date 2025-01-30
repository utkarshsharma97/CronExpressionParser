package com.test.utkarsh.deliveroo.model;

import com.utkarsh.deliveroo.exceptions.InvalidCronFieldFormatException;
import com.utkarsh.deliveroo.model.MinuteField;
import com.utkarsh.deliveroo.parser.FieldParser;
import com.utkarsh.deliveroo.parser.StandardFieldParser;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MinuteFieldTest {
    private final FieldParser parser = new StandardFieldParser();

    @Test
    public void testValidMinuteField() {
        MinuteField field = new MinuteField("0,15,30,45", parser);
        assertDoesNotThrow(field::validate);
    }

    @Test
    public void testInvalidMinuteField() {
        MinuteField field = new MinuteField("60", parser);
        assertThrows(InvalidCronFieldFormatException.class, field::validate);
    }
}
