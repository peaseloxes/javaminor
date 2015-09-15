package e20150914.designpatterns.behavioral.flyweight.domain.concrete;

import e20150914.designpatterns.behavioral.flyweight.domain.abs.Shape;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/15/15.
 */

@Getter
@Setter
public class Circle extends Shape {

    private String color;
    private int radius;

    public Circle(final String color){
        this.color = color;
    }

    @Override
    public void draw() {
        // not drawing
    }
}
