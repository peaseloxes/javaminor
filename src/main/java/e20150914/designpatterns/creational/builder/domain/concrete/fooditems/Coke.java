package e20150914.designpatterns.creational.builder.domain.concrete.fooditems;

import e20150914.designpatterns.creational.builder.domain.abs.fooditems.Drink;

/**
 * Created by alex on 9/14/15.
 */
public class Coke extends Drink {
    @Override
    public String getName() {
        return "Coke";
    }

    @Override
    public float getPrice() {
        return 1.00f;
    }
}
