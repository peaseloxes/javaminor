package e20150914.designpatterns.behavioral.command2.logic;

import lombok.Getter;

/**
 * Created by alex on 9/16/15.
 */
public class Calculator {

    @Getter
    private double calculatorState = 0;

    public void calculate(final char operator, final double value) {
        switch (operator) {
            case '-':
                calculatorState -= value;
                break;
            case '+':
                calculatorState += value;
                break;
            case '*':
                calculatorState *= value;
                break;
            case '/':
                calculatorState /= value;
                break;
        }
    }

    public void clear(){
        calculatorState = 0;
    }
}
