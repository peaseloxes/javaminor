package e20150914.designpatterns.creational.factoryMethod.logic;

import e20150914.designpatterns.creational.factoryMethod.domain.abs.Shape;
import e20150914.designpatterns.creational.factoryMethod.domain.concrete.Circle;
import e20150914.designpatterns.creational.factoryMethod.domain.concrete.Rectangle;
import e20150914.designpatterns.creational.factoryMethod.domain.concrete.ShapeType;
import e20150914.designpatterns.creational.factoryMethod.domain.concrete.Square;

/**
 * Created by alex on 9/14/15.
 */
public class ConcreteCreator extends Creator {

    @Override
    public Shape createShape(ShapeType type) {
        if(type == ShapeType.CIRCLE){
            return new Circle();
        }

        if(type == ShapeType.RECTANGLE){
            return new Rectangle();
        }

        if(type == ShapeType.SQUARE){
            return new Square();
        }

        return null;
    }
}
