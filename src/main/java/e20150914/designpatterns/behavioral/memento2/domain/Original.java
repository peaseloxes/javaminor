package e20150914.designpatterns.behavioral.memento2.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by alex on 9/16/15.
 */
public class Original implements Serializable{

    private static final long serialVersionUID = -79784812369667877L;

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String state;

    public Original(final int id){
        this.id = id;
    }


    public Memento getMemento() {
        return new Memento(state);
    }
}
