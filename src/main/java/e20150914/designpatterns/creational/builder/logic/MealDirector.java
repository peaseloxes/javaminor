package e20150914.designpatterns.creational.builder.logic;

import e20150914.designpatterns.creational.builder.domain.abs.Meal;

/**
 * Created by alex on 9/14/15.
 */
public class MealDirector {

    public Meal createVegiMealPepsi(int amount){
        return new MealBuilder()
                .createMeal()
                .addVegiBurger(amount)
                .addPepsi(amount)
                .getMeal();
    }

    public Meal createVegiMealCoke(int amount){
        return new MealBuilder()
                .createMeal()
                .addVegiBurger(amount)
                .addCoke(amount)
                .getMeal();
    }

    public Meal createMealPepsi(int amount){
        return new MealBuilder()
                .createMeal()
                .addChickenBurger(amount)
                .addPepsi(amount)
                .getMeal();
    }

    public Meal createMealCoke(int amount){
        return new MealBuilder()
                .createMeal()
                .addChickenBurger(amount)
                .addCoke(amount)
                .getMeal();
    }
}
