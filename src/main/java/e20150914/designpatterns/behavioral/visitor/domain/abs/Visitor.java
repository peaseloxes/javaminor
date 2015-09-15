package e20150914.designpatterns.behavioral.visitor.domain.abs;

import e20150914.designpatterns.behavioral.visitor.domain.concrete.Garage;

/**
 * Created by alex on 9/15/15.
 */
public interface Visitor {

    void visit(Garage garage);
}
