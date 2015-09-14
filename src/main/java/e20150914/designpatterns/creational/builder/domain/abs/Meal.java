package e20150914.designpatterns.creational.builder.domain.abs;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/14/15.
 */
@Getter
@Setter
public class Meal {
    private List<FoodItem> food;
    private List<FoodItem> drinks;

    public Meal(){
        food = new ArrayList<>();
        drinks = new ArrayList<>();
    }

    public void addFood(final FoodItem item){
        food.add(item);
    }

    public void addDrink(final FoodItem item){
        drinks.add(item);
    }

    public float getCost(){
        float total = 0;
        for (FoodItem item : food) {
            total+=item.getPrice();
        }

        for (FoodItem item : drinks) {
            total+=item.getPrice();
        }

        return total;
    }

}
