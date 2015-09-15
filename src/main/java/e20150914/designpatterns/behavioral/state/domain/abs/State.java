package e20150914.designpatterns.behavioral.state.domain.abs;

import e20150914.designpatterns.behavioral.state.domain.concrete.Context;

/**
 * Created by alex on 9/15/15.
 */
public interface State {
    void doAction(Context context);
}
