package e20150914.designpatterns.creational.prototype.domain.abs;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/14/15.
 */
public abstract class Shape implements Cloneable{
    @Getter
    @Setter
    private String type;

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
