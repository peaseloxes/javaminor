package e20150914.designpatterns.behavioral.visitor.domain.logic;

import e20150914.designpatterns.behavioral.visitor.domain.abs.Visitor;
import e20150914.designpatterns.behavioral.visitor.domain.concrete.Car;
import e20150914.designpatterns.behavioral.visitor.domain.concrete.Garage;
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

    private List<Visitor> carPark;

    public GarageManager(){
        carPark = new ArrayList<>();
        carPark.add(new Car());
        carPark.add(new Car());
        carPark.add(new Motorcycle());
    }

    public void startWalking(){
        Garage garage = new Garage();
        for (Visitor vehicle : carPark) {
            garage.accept(vehicle);
        }
        totalPrice = garage.getTotalPrice();
    }
}
