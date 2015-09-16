package e20150914.designpatterns.behavioral.command2.domain.concrete;

import e20150914.designpatterns.behavioral.command2.domain.abs.Command;
import e20150914.designpatterns.behavioral.command2.logic.Calculator;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/16/15.
 */
@Getter
@Setter
public class CalculatorCommand extends Command{

    private final Calculator calculator;
    private final char operator;
    private final double value;

    public CalculatorCommand(final Calculator calculator, final char operator, final double value){
        this.calculator = calculator;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public void execute() {
        calculator.calculate(operator,value);
    }

    @Override
    public void undo() {
        calculator.calculate(undo(operator),value);
    }

    private char undo(final char operator) {
        switch (operator) {
            case '+' : return '-';
            case '-' : return '+';
            case '*' : return '/';
            case '/' : return '*';
        }
        return '?';
    }
}
