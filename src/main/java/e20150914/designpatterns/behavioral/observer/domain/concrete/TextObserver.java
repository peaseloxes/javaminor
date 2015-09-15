package e20150914.designpatterns.behavioral.observer.domain.concrete;

import e20150914.designpatterns.behavioral.observer.domain.abs.Observer;

/**
 * Created by alex on 9/15/15.
 */
public class TextObserver extends Observer{

    public TextObserver(final Subject subject){
        setSubject(subject);
        getSubject().attach(this);
    }

    @Override
    public void update() {
        String subjectState = getSubject().getState();
        boolean shouldICare = true;


        for (char c : subjectState.toCharArray()) {
            if(!Character.isLetter(c)){
                shouldICare = false;
                break;
            }
        }

        if(shouldICare){
            setLastState(getSubject().getState());
        }
    }
}
