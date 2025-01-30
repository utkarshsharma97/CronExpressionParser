package com.utkarsh.deliveroo.model;

import com.utkarsh.deliveroo.Constants;

public class CommandField {
    private final String command;

    public CommandField(String command) {
        this.command = command;
    }

    public String format() {
        return String.format("%-14s%s", Constants.COMMAND_FIELD, command);
    }
}
