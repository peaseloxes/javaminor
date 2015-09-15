package e20150914.designpatterns.behavioral.flyweight.domain.logic;

import e20150914.designpatterns.behavioral.flyweight.domain.abs.Shape;
import e20150914.designpatterns.behavioral.flyweight.domain.concrete.Circle;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 9/15/15.
 */
public class ShapeManager {
    @Getter
    private Map<String,Shape> map;

    public ShapeManager(){
        map = new HashMap<>();
    }

    public Shape getCircle(final String color){
        if(!map.containsKey(color)){
            map.put(color,new Circle(color));
        }
        return map.get(color);
    }
}
