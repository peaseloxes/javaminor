package e20150914.designpatterns.structural.bridge.domain.concrete.shapes;

import e20150914.designpatterns.structural.bridge.domain.abs.DrawAPI;
import e20150914.designpatterns.structural.bridge.domain.abs.Shape;

/**
 * Created by alex on 9/14/15.
 */
public class Circle extends Shape {

    private int radius;

    public Circle(DrawAPI drawAPI, int radius){
        super(drawAPI);
        this.radius = radius;
    }

    @Override
    public String draw() {
        return getDrawAPI().drawCircle(radius);
    }
}
