package e20150914.designpatterns.creational.builder.domain.concrete.fooditems;

import e20150914.designpatterns.creational.builder.domain.abs.fooditems.Drink;

/**
 * Created by alex on 9/14/15.
 */
public class Pepsi extends Drink {
    @Override
    public String getName() {
        return "Pepsi";
    }

    @Override
    public float getPrice() {
        return 1.10f;
    }
}
