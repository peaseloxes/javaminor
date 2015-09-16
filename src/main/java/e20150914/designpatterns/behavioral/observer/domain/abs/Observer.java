package e20150914.designpatterns.behavioral.observer.domain.abs;

import e20150914.designpatterns.behavioral.observer.domain.concrete.Subject;
import lombok.Getter;
import lombok.Setter;


/**
 * Created by alex on 9/15/15.
 */
public abstract class Observer {

    @Getter
    @Setter
    private String lastState;

    @Getter
    @Setter
    private Subject subject;

    public abstract void update(String state);
}
