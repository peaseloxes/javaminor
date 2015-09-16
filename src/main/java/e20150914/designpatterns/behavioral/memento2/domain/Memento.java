package e20150914.designpatterns.behavioral.memento2.domain;

import lombok.Getter;

import java.io.Serializable;

/**
 * Created by alex on 9/16/15.
 */
public class Memento implements Serializable{
    private static final long serialVersionUID = -7978489268769667877L;
    @Getter
    private String state;

    public Memento(final String state){
        this.state = state;
    }
}
