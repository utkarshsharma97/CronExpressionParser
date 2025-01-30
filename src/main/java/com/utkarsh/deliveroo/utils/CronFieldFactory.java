package com.utkarsh.deliveroo.utils;

import com.utkarsh.deliveroo.enums.FieldType;
import com.utkarsh.deliveroo.model.CronField;
import com.utkarsh.deliveroo.model.DayOfMonthField;
import com.utkarsh.deliveroo.model.DayOfWeekField;
import com.utkarsh.deliveroo.model.HourField;
import com.utkarsh.deliveroo.model.MinuteField;
import com.utkarsh.deliveroo.model.MonthField;
import com.utkarsh.deliveroo.parser.FieldParser;

public class CronFieldFactory {
    private final FieldParser parser;

    public CronFieldFactory(FieldParser parser) {
        this.parser = parser;
    }

    public CronField createField(String expression, FieldType type) {
        return switch (type) {
            case MINUTE -> new MinuteField(expression, parser);
            case HOUR -> new HourField(expression, parser);
            case DAY_OF_MONTH -> new DayOfMonthField(expression, parser);
            case MONTH -> new MonthField(expression, parser);
            case DAY_OF_WEEK -> new DayOfWeekField(expression, parser);
        };
    }
}
