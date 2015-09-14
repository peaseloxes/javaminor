package e20150914.designpatterns.creational.builder.domain.concrete.fooditems;

import e20150914.designpatterns.creational.builder.domain.abs.fooditems.Burger;

/**
 * Created by alex on 9/14/15.
 */
public class ChickenBurger extends Burger {
    @Override
    public String getName() {
        return "Chicken Burger";
    }

    @Override
    public float getPrice() {
        return 1.50f;
    }
}
