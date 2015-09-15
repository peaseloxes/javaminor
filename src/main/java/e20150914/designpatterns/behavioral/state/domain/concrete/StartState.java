package e20150914.designpatterns.behavioral.state.domain.concrete;

import e20150914.designpatterns.behavioral.state.domain.abs.State;

/**
 * Created by alex on 9/15/15.
 */
public class StartState implements State {
    @Override
    public void doAction(Context context) {
        context.setState(this);
    }

    @Override
    public String toString(){
        return "Start state";
    }
}
