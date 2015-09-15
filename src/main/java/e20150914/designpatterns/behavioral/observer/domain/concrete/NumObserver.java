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
    public void update() {
        String subjectState = getSubject().getState();
        boolean shouldICare = true;


        for (char c : subjectState.toCharArray()) {
            if(!Character.isDigit(c)){
                shouldICare = false;
                break;
            }
        }

        if(shouldICare){
            setLastState(getSubject().getState());
        }
    }
}