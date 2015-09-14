package e20150914.designpatterns.builder.logic;

import e20150914.designpatterns.builder.domain.abs.Meal;
import e20150914.designpatterns.builder.domain.concrete.fooditems.ChickenBurger;
import e20150914.designpatterns.builder.domain.concrete.fooditems.Coke;
import e20150914.designpatterns.builder.domain.concrete.fooditems.Pepsi;
import e20150914.designpatterns.builder.domain.concrete.fooditems.VegiBurger;

/**
 * Created by alex on 9/14/15.
 */
public class MealBuilder {

    public Meal createVegiMealPepsi(){
        Meal vegiMeal = new Meal();
        vegiMeal.addItem(new VegiBurger());
        vegiMeal.addItem(new Pepsi());
        return vegiMeal;
    }

    public Meal createVegiMealCoke(){
        Meal vegiMeal = new Meal();
        vegiMeal.addItem(new VegiBurger());
        vegiMeal.addItem(new Coke());
        return vegiMeal;
    }

    public Meal createMealPepsi(){
        Meal vegiMeal = new Meal();
        vegiMeal.addItem(new ChickenBurger());
        vegiMeal.addItem(new Pepsi());
        return vegiMeal;
    }

    public Meal createMealCoke(){
        Meal vegiMeal = new Meal();
        vegiMeal.addItem(new ChickenBurger());
        vegiMeal.addItem(new Coke());
        return vegiMeal;
    }

}
