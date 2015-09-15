package e20150914.designpatterns.behavioral.visitor.domain.abs;

/**
 * Created by alex on 9/15/15.
 */
public interface Visitable {

    void accept(Visitor visitor);
}
