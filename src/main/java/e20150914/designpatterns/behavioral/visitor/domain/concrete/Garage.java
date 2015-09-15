package e20150914.designpatterns.behavioral.visitor.domain.concrete;

import e20150914.designpatterns.behavioral.visitor.domain.abs.Visitable;
import e20150914.designpatterns.behavioral.visitor.domain.abs.Visitor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/15/15.
 */
public class Garage implements Visitable {

    @Getter
    @Setter
    private float totalPrice = 0;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
