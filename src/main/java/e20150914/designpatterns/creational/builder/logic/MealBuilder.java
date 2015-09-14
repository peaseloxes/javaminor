package e20150914.designpatterns.creational.builder.logic;

import e20150914.designpatterns.creational.builder.domain.abs.FoodItem;
import e20150914.designpatterns.creational.builder.domain.abs.Meal;
import e20150914.designpatterns.creational.builder.domain.concrete.fooditems.ChickenBurger;
import e20150914.designpatterns.creational.builder.domain.concrete.fooditems.Coke;
import e20150914.designpatterns.creational.builder.domain.concrete.fooditems.Pepsi;
import e20150914.designpatterns.creational.builder.domain.concrete.fooditems.VegiBurger;
import lombok.Getter;

/**
 * Created by alex on 9/14/15.
 */
public class MealBuilder {

    @Getter
    private Meal meal;

    public MealBuilder(){
        // safety
        createMeal();
    }

    public MealBuilder createMeal(){
        meal = new Meal();
        return this;
    }

    public MealBuilder addCoke(int amount){
        for (int i = 0; i < amount; i++) {
            addDrink(new Coke());
        }
        return this;
    }

    public MealBuilder addPepsi(int amount){
        for (int i = 0; i < amount; i++) {
            addDrink(new Pepsi());
        }
        return this;
    }

    public MealBuilder addVegiBurger(int amount){
        for (int i = 0; i < amount; i++) {
            addFood(new VegiBurger());
        }
        return this;
    }

    public MealBuilder addChickenBurger(int amount){
        for (int i = 0; i < amount; i++) {
            addFood(new ChickenBurger());
        }
        return this;
    }

    // helpers

    private void addFood(FoodItem item) {
        meal.addFood(item);
    }

    private void addDrink(FoodItem item){
        meal.addDrink(item);
    }

}
