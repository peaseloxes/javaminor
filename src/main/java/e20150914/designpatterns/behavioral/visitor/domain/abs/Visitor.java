package e20150914.designpatterns.behavioral.visitor.domain.abs;

import e20150914.designpatterns.behavioral.visitor.domain.concrete.Car;
import e20150914.designpatterns.behavioral.visitor.domain.concrete.Motorcycle;

/**
 * Created by alex on 9/15/15.
 */
public interface Visitor {

    void visit(Car car);
    void visit(Motorcycle motorcycle);
}
