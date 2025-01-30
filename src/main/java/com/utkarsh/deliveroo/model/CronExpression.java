package com.utkarsh.deliveroo.model;

import com.utkarsh.deliveroo.exceptions.InvalidCronFieldFormatException;

public class CronExpression {
    private final MinuteField minuteField;
    private final HourField hourField;
    private final DayOfMonthField dayOfMonthField;
    private final MonthField monthField;
    private final DayOfWeekField dayOfWeekField;
    private final CommandField commandField;

    public CronExpression(MinuteField minuteField,
                          HourField hourField,
                          DayOfMonthField dayOfMonthField,
                          MonthField monthField,
                          DayOfWeekField dayOfWeekField,
                          CommandField commandField) {
        this.minuteField = minuteField;
        this.hourField = hourField;
        this.dayOfMonthField = dayOfMonthField;
        this.monthField = monthField;
        this.dayOfWeekField = dayOfWeekField;
        this.commandField = commandField;
    }

    public String format() {
        return String.join("\n",
                minuteField.format(),
                hourField.format(),
                dayOfMonthField.format(),
                monthField.format(),
                dayOfWeekField.format(),
                commandField.format()
        );
    }

    public void validate() throws InvalidCronFieldFormatException {
        minuteField.validate();
        hourField.validate();
        dayOfMonthField.validate();
        monthField.validate();
        dayOfWeekField.validate();
    }
}
