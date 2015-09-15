package e20150914.designpatterns.behavioral.observer.domain.concrete;

import e20150914.designpatterns.behavioral.observer.domain.abs.Observer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/15/15.
 */
public class Subject {
    private List<Observer> observers;

    @Getter
    private String state;


    public void setState(final String state){
        this.state = state;
        notifyObservers();
    }

    public Subject(){
        observers = new ArrayList<>();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        observers.forEach(Observer::update);
    }
}
