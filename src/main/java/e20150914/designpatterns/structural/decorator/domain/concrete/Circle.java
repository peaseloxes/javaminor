package e20150914.designpatterns.structural.decorator.domain.concrete;

import e20150914.designpatterns.structural.decorator.domain.abs.Shape;

/**
 * Created by alex on 9/14/15.
 */
public class Circle implements Shape {
    @Override
    public String draw() {
        return " Circle ";
    }
}
