package com.utkarsh.deliveroo.parser;

import com.utkarsh.deliveroo.utils.CronFieldFactory;
import com.utkarsh.deliveroo.enums.FieldType;
import com.utkarsh.deliveroo.exceptions.InvalidCronExpressionFormatException;
import com.utkarsh.deliveroo.exceptions.InvalidCronFieldFormatException;
import com.utkarsh.deliveroo.model.CommandField;
import com.utkarsh.deliveroo.model.CronExpression;
import com.utkarsh.deliveroo.model.DayOfMonthField;
import com.utkarsh.deliveroo.model.DayOfWeekField;
import com.utkarsh.deliveroo.model.HourField;
import com.utkarsh.deliveroo.model.MinuteField;
import com.utkarsh.deliveroo.model.MonthField;

public class CronParser {
    private final CronFieldFactory fieldFactory;

    public CronParser() {
        this.fieldFactory = new CronFieldFactory(new StandardFieldParser());
    }

    public CronExpression parse(String cronString) throws InvalidCronExpressionFormatException, InvalidCronFieldFormatException {
        String[] parts = cronString.trim().split("\\s+");
        if (parts.length != 6) {
            throw new InvalidCronExpressionFormatException("Invalid cron expression string format");
        }

        MinuteField minuteField = (MinuteField) fieldFactory.createField(
                parts[0], FieldType.MINUTE);
        HourField hourField = (HourField) fieldFactory.createField(
                parts[1], FieldType.HOUR);
        DayOfMonthField dayOfMonthField = (DayOfMonthField) fieldFactory.createField(
                parts[2], FieldType.DAY_OF_MONTH);
        MonthField monthField = (MonthField) fieldFactory.createField(
                parts[3], FieldType.MONTH);
        DayOfWeekField dayOfWeekField = (DayOfWeekField) fieldFactory.createField(
                parts[4], FieldType.DAY_OF_WEEK);
        CommandField commandField = new CommandField(parts[5]);

        CronExpression expression = new CronExpression(
                minuteField, hourField, dayOfMonthField,
                monthField, dayOfWeekField, commandField
        );

        expression.validate();
        return expression;
    }
}
