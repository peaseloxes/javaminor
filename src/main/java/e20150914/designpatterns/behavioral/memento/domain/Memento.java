package e20150914.designpatterns.behavioral.memento.domain;

import lombok.Getter;

/**
 * Created by alex on 9/15/15.
 */
public class Memento {
    @Getter
    private String state;

    public Memento(final String state){
        this.state = state;
    }
}
