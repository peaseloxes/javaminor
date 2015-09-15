package e20150914.designpatterns.behavioral.interpreter.domain.concrete.expressions;

import e20150914.designpatterns.behavioral.interpreter.domain.abs.Expression;

/**
 * Created by alex on 9/14/15.
 */
public class AndExpression implements Expression {

    private Expression expression1;
    private Expression expression2;

    public AndExpression(Expression expression1, Expression expression2){
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean validate(String clause) {
        return (expression1.validate(clause) && expression2.validate(clause));
    }
}
