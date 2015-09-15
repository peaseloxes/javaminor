package e20150914.designpatterns.behavioral.memento.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/15/15.
 */
public class Original {
    @Getter
    @Setter
    private String state;


    public Memento getMemento() {
        return new Memento(state);
    }
}
