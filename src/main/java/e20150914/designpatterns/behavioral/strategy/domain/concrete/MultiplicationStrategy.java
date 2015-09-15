package e20150914.designpatterns.behavioral.strategy.domain.concrete;

import e20150914.designpatterns.behavioral.strategy.domain.abs.Strategy;

/**
 * Created by alex on 9/15/15.
 */
public class MultiplicationStrategy extends Strategy {
    @Override
    public int doOperation(final int x, final int y) {
        return x * y;
    }
}
