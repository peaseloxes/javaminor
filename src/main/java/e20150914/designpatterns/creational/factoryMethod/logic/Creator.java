package e20150914.designpatterns.creational.factoryMethod.logic;

import e20150914.designpatterns.creational.factoryMethod.domain.abs.Shape;
import e20150914.designpatterns.creational.factoryMethod.domain.concrete.ShapeType;

/**
 * Created by alex on 9/14/15.
 */
public abstract class Creator {

    public Shape create(ShapeType type){
        return createShape(type);
    }

    public abstract Shape createShape(ShapeType type);
}
