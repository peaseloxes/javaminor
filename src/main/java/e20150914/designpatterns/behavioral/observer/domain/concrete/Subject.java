package e20150914.designpatterns.behavioral.observer.domain.concrete;

import e20150914.designpatterns.behavioral.observer.domain.abs.Observer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by alex on 9/15/15.
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();

    @Getter
    private String state;


    public void setState(final String state) {

        List<Observer> copyOfObservers;

        synchronized (this){
            this.state = state;
            copyOfObservers = new ArrayList<>(observers);
        }
        Iterator i = copyOfObservers.iterator();
        while(i.hasNext()){
            ((Observer)i.next()).update(state);
        }
    }

    public Subject() {

    }

    public synchronized void attach(Observer observer) {
        observers.add(observer);
    }

    public synchronized void detach(Observer observer) {
        observers.remove(observer);
    }
}
