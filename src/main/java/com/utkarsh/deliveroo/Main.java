package com.utkarsh.deliveroo;

import com.utkarsh.deliveroo.exceptions.InvalidCronExpressionFormatException;
import com.utkarsh.deliveroo.model.CronExpression;
import com.utkarsh.deliveroo.parser.CronParser;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("Insufficient argument length for cron expression.");
        }
        CronParser parser = new CronParser();
        try {
            CronExpression expression = parser.parse(args[0]);
            String formattedCronExpression = expression.format();
            System.out.println(formattedCronExpression);
        }
        catch (InvalidCronExpressionFormatException e){
            System.err.println("InvalidCronExpressionFormatException: " + e.getMessage());
            System.exit(1);
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
