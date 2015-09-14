package e20150914.designpatterns.creational.builder.domain.abs.fooditems;

import e20150914.designpatterns.creational.builder.domain.abs.FoodItem;
import e20150914.designpatterns.creational.builder.domain.concrete.packing.Wrapper;

/**
 * Created by alex on 9/14/15.
 */
public abstract class Burger extends FoodItem{

    public Burger(){
        setPacking(new Wrapper());
    }

    @Override
    public abstract String getName();

    @Override
    public abstract float getPrice();

}
