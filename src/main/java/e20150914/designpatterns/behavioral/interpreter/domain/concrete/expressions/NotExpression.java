package e20150914.designpatterns.behavioral.interpreter.domain.concrete.expressions;

import e20150914.designpatterns.behavioral.interpreter.domain.abs.Expression;

/**
 * Created by alex on 9/14/15.
 */
public class NotExpression implements Expression {

    private Expression expression1;

    public NotExpression(Expression expression1){
        this.expression1 = expression1;
    }

    @Override
    public boolean validate(String clause) {
        return (!expression1.validate(clause));
    }

}
