package e20150914.designpatterns.builder.domain.abs;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/14/15.
 */
public abstract class FoodItem {
    @Getter
    @Setter
    private Packing packing;

    public abstract String getName();

    public abstract float getPrice();
}
