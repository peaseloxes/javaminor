package e20150914.designpatterns.behavioral.strategy.logic;

import e20150914.designpatterns.behavioral.strategy.domain.abs.Strategy;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/15/15.
 */
public class Calculator {
    @Getter
    @Setter
    private Strategy strategy;

    public int calculate(final int x, final int y){
        return strategy.doOperation(x,y);
    }
}
