package e20150914.designpatterns.behavioral.visitor.domain.logic;

import e20150914.designpatterns.behavioral.visitor.domain.abs.Visitable;
import e20150914.designpatterns.behavioral.visitor.domain.concrete.Car;
import e20150914.designpatterns.behavioral.visitor.domain.concrete.GarageVisitor;
import e20150914.designpatterns.behavioral.visitor.domain.concrete.Motorcycle;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/15/15.
 */
public class GarageManager {

    @Getter
    private float totalPrice = 0;

    private List<Visitable> carPark;

    public GarageManager(){
        carPark = new ArrayList<>();
        carPark.add(new Car());
        carPark.add(new Car());
        carPark.add(new Motorcycle());
    }

    public void startWalking(){
        GarageVisitor visitor = new GarageVisitor();
        for (Visitable vehicle : carPark) {
            vehicle.accept(visitor);
        }
        totalPrice = visitor.getTotalPrice();
    }
}
