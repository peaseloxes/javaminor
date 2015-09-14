package e20150914.designpatterns.builder.logic;

import e20150914.designpatterns.builder.domain.abs.FoodItem;
import e20150914.designpatterns.builder.domain.abs.Meal;
import e20150914.designpatterns.builder.domain.abs.fooditems.Burger;
import e20150914.designpatterns.builder.domain.abs.fooditems.Drink;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/14/15.
 */
public class MealBuilderTest extends TestCase {

    @Test
    public void testBuilder(){
        List<Meal> meals = new ArrayList<>();

        Meal vegiMealPepsi = new MealBuilder().createVegiMealPepsi();
        meals.add(vegiMealPepsi);

        Meal vegiMealCoke = new MealBuilder().createVegiMealCoke();
        meals.add(vegiMealCoke);

        Meal mealPepsi = new MealBuilder().createMealPepsi();
        meals.add(mealPepsi);

        Meal mealCoke = new MealBuilder().createMealCoke();
        meals.add(mealCoke);

        for (Meal meal : meals) {
            assertNotNull(meal);
            assertEquals(2, meal.getItems().size());
        }

        float total = 0;
        for (FoodItem item : vegiMealPepsi.getItems()) {
            if(item instanceof Burger){
                assertEquals("Vegi Burger",item.getName());
                total+=item.getPrice();
            }else if(item instanceof Drink){
                assertEquals("Pepsi",item.getName());
                total+=item.getPrice();
            }else{
                fail("No burgers or drinks found!");
            }
        }
        assertEquals(3.60f,total);

        total = 0;
        for (FoodItem item : vegiMealCoke.getItems()) {
            if(item instanceof Burger){
                assertEquals("Vegi Burger",item.getName());
                total+=item.getPrice();
            }else if(item instanceof Drink){
                assertEquals("Coke",item.getName());
                total+=item.getPrice();
            }else{
                fail("No burgers or drinks found!");
            }
        }
        assertEquals(3.50f,total);

        total = 0;
        for (FoodItem item : mealCoke.getItems()) {
            if(item instanceof Burger){
                assertEquals("Chicken Burger",item.getName());
                total+=item.getPrice();
            }else if(item instanceof Drink){
                assertEquals("Coke",item.getName());
                total+=item.getPrice();
            }else{
                fail("No burgers or drinks found!");
            }
        }
        assertEquals(2.50f,total);

        total = 0;
        for (FoodItem item : mealPepsi.getItems()) {
            if(item instanceof Burger){
                assertEquals("Chicken Burger",item.getName());
                total+=item.getPrice();
            }else if(item instanceof Drink){
                assertEquals("Pepsi",item.getName());
                total+=item.getPrice();
            }else{
                fail("No burgers or drinks found!");
            }
        }
        assertEquals(2.60f,total);
    }

}