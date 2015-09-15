package e20150914.designpatterns.behavioral.interpreter.domain.concrete.expressions;

import e20150914.designpatterns.behavioral.interpreter.domain.abs.Expression;

/**
 * Created by alex on 9/14/15.
 */
public class Terminal implements Expression {

    private String clause;

    public Terminal(String clause){
        this.clause = clause;
    }

    @Override
    public boolean validate(String clause) {
        return this.clause.equals(clause);
    }
}
