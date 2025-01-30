package com.test.utkarsh.deliveroo.model;

import com.utkarsh.deliveroo.model.CommandField;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandFieldTest {
    @Test
    public void testCommandFieldFormat() {
        CommandField field = new CommandField("/usr/bin/find");
        assertEquals("command       /usr/bin/find", field.format());
    }
}
