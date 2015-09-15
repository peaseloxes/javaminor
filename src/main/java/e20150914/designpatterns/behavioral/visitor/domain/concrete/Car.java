package e20150914.designpatterns.behavioral.visitor.domain.concrete;

import e20150914.designpatterns.behavioral.visitor.domain.abs.Visitable;
import e20150914.designpatterns.behavioral.visitor.domain.abs.Visitor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/15/15.
 */
public class Car implements Visitable {
    @Getter
    @Setter
    private float basePrice = 2.50f;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
