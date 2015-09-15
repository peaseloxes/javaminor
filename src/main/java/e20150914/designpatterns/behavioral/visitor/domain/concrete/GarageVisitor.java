package e20150914.designpatterns.behavioral.visitor.domain.concrete;

import e20150914.designpatterns.behavioral.visitor.domain.abs.Visitor;
import lombok.Getter;

/**
 * Created by alex on 9/15/15.
 */
public class GarageVisitor implements Visitor {

    @Getter
    private float totalPrice = 0;

    @Override
    public void visit(Car car) {
        totalPrice+=car.getBasePrice();
    }

    @Override
    public void visit(Motorcycle motorcycle) {
        totalPrice+=motorcycle.getBasePrice();
    }
}
