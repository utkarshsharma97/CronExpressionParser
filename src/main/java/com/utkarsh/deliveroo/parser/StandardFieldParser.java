package com.utkarsh.deliveroo.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StandardFieldParser implements FieldParser {
    @Override
    public List<Integer> parse(String expression, int min, int max) {
        Set<Integer> results = new TreeSet<>();

        String[] parts = expression.split(",");
        for (String part : parts) {
            if (part.contains("/")) {
                parseStep(part, min, max, results);
            } else if (part.contains("-")) {
                parseRange(part, results);
            } else if (part.equals("*")) {
                parseAll(min, max, results);
            } else {
                results.add(Integer.parseInt(part));
            }
        }

        return new ArrayList<>(results);
    }

    private void parseStep(String expression, int min, int max, Set<Integer> results) {
        String[] stepParts = expression.split("/");
        int step = Integer.parseInt(stepParts[1]);
        String range = stepParts[0].equals("*") ? min + "-" + max : stepParts[0];

        if (range.contains("-")) {
            String[] rangeParts = range.split("-");
            int start = Integer.parseInt(rangeParts[0]);
            int end = Integer.parseInt(rangeParts[1]);

            for (int i = start; i <= end; i += step) {
                results.add(i);
            }
        }
    }

    private void parseRange(String expression, Set<Integer> results) {
        String[] rangeParts = expression.split("-");
        int start = Integer.parseInt(rangeParts[0]);
        int end = Integer.parseInt(rangeParts[1]);

        for (int i = start; i <= end; i++) {
            results.add(i);
        }
    }

    private void parseAll(int min, int max, Set<Integer> results) {
        for (int i = min; i <= max; i++) {
            results.add(i);
        }
    }
}
