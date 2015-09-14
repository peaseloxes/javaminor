package e20150914.designpatterns.structural.decorator.domain.concrete;

import e20150914.designpatterns.structural.decorator.domain.abs.Shape;

/**
 * Created by alex on 9/14/15.
 */
public class RedBorderDecorator implements Shape {
    protected Shape decoratedShape;

    public RedBorderDecorator(final Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    @Override
    public String draw() {
        return " Red Bordered " + decoratedShape.draw();
    }
}
