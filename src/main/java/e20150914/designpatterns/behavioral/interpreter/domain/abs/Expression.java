package e20150914.designpatterns.behavioral.interpreter.domain.abs;

/**
 * Created by alex on 9/14/15.
 */
public interface Expression {
    boolean validate(String clause);
}
