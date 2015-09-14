package e20150914.designpatterns.creational.builder.domain.abs.fooditems;

import e20150914.designpatterns.creational.builder.domain.abs.FoodItem;
import e20150914.designpatterns.creational.builder.domain.concrete.packing.Bottle;

/**
 * Created by alex on 9/14/15.
 */
public abstract class Drink extends FoodItem{

    public Drink(){
        setPacking(new Bottle());
    }

    @Override
    public abstract String getName();

    @Override
    public abstract float getPrice();

}
