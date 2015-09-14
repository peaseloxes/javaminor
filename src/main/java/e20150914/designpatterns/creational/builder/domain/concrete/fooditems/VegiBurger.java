package e20150914.designpatterns.creational.builder.domain.concrete.fooditems;

import e20150914.designpatterns.creational.builder.domain.abs.fooditems.Burger;

/**
 * Created by alex on 9/14/15.
 */
public class VegiBurger extends Burger {
    @Override
    public String getName() {
        return "Vegi Burger";
    }

    @Override
    public float getPrice() {
        return 2.50f;
    }
}
