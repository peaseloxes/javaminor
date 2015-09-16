package e20150914.designpatterns.behavioral.command2.logic;

import e20150914.designpatterns.behavioral.command2.domain.abs.Command;
import e20150914.designpatterns.behavioral.command2.domain.concrete.CalculatorCommand;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/16/15.
 */
public class CalculatorUser {
    @Getter
    private Calculator calculator;

    private List<Command> issuedCommands;
    private int commandPosition = 0;

     public CalculatorUser(){
         calculator = new Calculator();
         issuedCommands = new ArrayList<>();
     }

    public void redo(int levels) {
        while(levels > 0){
            if(commandPosition < issuedCommands.size()){
                issuedCommands.get(commandPosition++).execute();
            }
            levels--;
        }
    }

    public void undo(int levels) {
        while(levels > 0){
            if(commandPosition >= 0){
                issuedCommands.get(--commandPosition).undo();
            }
            levels--;
        }
    }

    public void calculate(final char operator, final double value) {
        Command calcCommand = new CalculatorCommand(calculator, operator, value);
        calcCommand.execute();
        issuedCommands.add(calcCommand);
        commandPosition++;
    }
}
