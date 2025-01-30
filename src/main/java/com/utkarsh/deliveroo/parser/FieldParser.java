package com.utkarsh.deliveroo.parser;

import java.util.List;

public interface FieldParser {
    List<Integer> parse(String expression, int min, int max);
}
