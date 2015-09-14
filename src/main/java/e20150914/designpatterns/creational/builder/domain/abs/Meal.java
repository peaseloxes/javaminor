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
    private List<FoodItem> items;

    public Meal(){
        items = new ArrayList<>();
    }

    public void addItem(final FoodItem item){
        items.add(item);
    }

}
