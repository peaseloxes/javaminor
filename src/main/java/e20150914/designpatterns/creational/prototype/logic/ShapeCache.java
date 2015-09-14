package e20150914.designpatterns.creational.prototype.logic;

import e20150914.designpatterns.creational.prototype.domain.abs.Shape;
import e20150914.designpatterns.creational.prototype.domain.concrete.Circle;
import e20150914.designpatterns.creational.prototype.domain.concrete.Rectangle;
import e20150914.designpatterns.creational.prototype.domain.concrete.ShapeType;
import e20150914.designpatterns.creational.prototype.domain.concrete.Square;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by alex on 9/14/15.
 */
public class ShapeCache {

    private static Map<ShapeType, Shape> shapeMap;

    static {
        shapeMap = new Hashtable<>();
        populate();
    }

    public Shape getShape(final ShapeType type){
        Shape cachedShape = shapeMap.get(type);
        return (Shape)cachedShape.clone();
    }

    private static void populate(){
        // normally from database etc.
        shapeMap.put(ShapeType.CIRCLE,new Circle());
        shapeMap.put(ShapeType.SQUARE,new Square());
        shapeMap.put(ShapeType.RECTANGLE,new Rectangle());
    }

}
