package com.test.utkarsh.deliveroo.parser;

import com.utkarsh.deliveroo.parser.StandardFieldParser;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StandardFieldParserTest {
    private final StandardFieldParser parser = new StandardFieldParser();

    @Test
    public void testParseAll() {
        assertEquals(List.of(1, 2, 3, 4, 5), parser.parse("*", 1, 5));
    }

    @Test
    public void testParseList() {
        assertEquals(List.of(1, 3, 5), parser.parse("1,3,5", 1, 5));
    }

    @Test
    public void testParseRange() {
        assertEquals(List.of(2, 3, 4), parser.parse("2-4", 1, 5));
    }

    @Test
    public void testParseStep() {
        assertEquals(List.of(0, 15, 30, 45), parser.parse("*/15", 0, 59));
    }

    @Test
    public void testParseComplex() {
        assertEquals(List.of(0, 15, 30, 45, 50), parser.parse("*/15,50", 0, 59));
    }
}
