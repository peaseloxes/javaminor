package e20150914.designpatterns.behavioral.state.domain.concrete;

import e20150914.designpatterns.behavioral.state.domain.abs.State;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/15/15.
 */
public class Context {
    @Getter
    @Setter
    private State state;
}
