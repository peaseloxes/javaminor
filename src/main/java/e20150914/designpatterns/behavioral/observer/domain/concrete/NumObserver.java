package e20150914.designpatterns.behavioral.observer.domain.concrete;

import e20150914.designpatterns.behavioral.observer.domain.abs.Observer;

/**
 * Created by alex on 9/15/15.
 */
public class NumObserver  extends Observer {

    public NumObserver(final Subject subject) {
        setSubject(subject);
        getSubject().attach(this);
    }

    @Override
    public void update(String state) {
        boolean shouldICare = true;

        for (char c : state.toCharArray()) {
            if(!Character.isDigit(c)){
                shouldICare = false;
                break;
            }
        }

        if(shouldICare){
            setLastState(state);
        }
    }
}