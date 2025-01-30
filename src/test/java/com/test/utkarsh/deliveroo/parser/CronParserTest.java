package com.test.utkarsh.deliveroo.parser;

import com.utkarsh.deliveroo.exceptions.InvalidCronExpressionFormatException;
import com.utkarsh.deliveroo.exceptions.InvalidCronFieldFormatException;
import com.utkarsh.deliveroo.model.CronExpression;
import com.utkarsh.deliveroo.parser.CronParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CronParserTest {
    private final CronParser parser = new CronParser();

    @Test
    public void testBasicCronExpression() throws InvalidCronExpressionFormatException, InvalidCronFieldFormatException {
        String cronString = "*/15 0 1,15 * 1-5 /usr/bin/find";
        CronExpression expression = parser.parse(cronString);
        String result = expression.format();

        String expected =
                "minute        0 15 30 45\n" +
                "hour          0\n" +
                "day of month  1 15\n" +
                "month         1 2 3 4 5 6 7 8 9 10 11 12\n" +
                "day of week   1 2 3 4 5\n" +
                "command       /usr/bin/find";

        assertEquals(expected, result);
    }

    @Test
    public void testValidCronString() throws InvalidCronExpressionFormatException, InvalidCronFieldFormatException {
        String cronString = "*/15 0 1,15 * 1-5 /usr/bin/find";
        CronExpression expression = parser.parse(cronString);
        assertNotNull(expression);
    }

    @Test
    public void testInvalidCronString() {
        assertThrows(InvalidCronExpressionFormatException.class, () -> {
            parser.parse("* * * * /usr/bin/find");
        });
    }

    @Test
    public void testInvalidFieldValues() {
        assertThrows(InvalidCronFieldFormatException.class, () -> {
            parser.parse("60 24 32 13 8 /usr/bin/find");
        });
    }
}
