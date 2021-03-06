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
    public void update(String state) {
        boolean shouldICare = true;

        for (char c : state.toCharArray()) {
            if(!Character.isLetter(c)){
                shouldICare = false;
                break;
            }
        }

        if(shouldICare){
            setLastState(state);
        }
    }
}
