package e20150914.designpatterns.behavioral.memento.logic;

import e20150914.designpatterns.behavioral.memento.domain.Memento;
import e20150914.designpatterns.behavioral.memento.domain.Original;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alex on 9/15/15.
 */
public class MementoManager {
    private Map<Original,List<Memento>> mementos;

    public MementoManager(){
        mementos = new HashMap<>();
    }

    public void addOriginal(Original original){
        mementos.put(original,new ArrayList<>());
    }

    public void save(final Original original){
        Memento m = original.getMemento();
        mementos.get(original).add(m);
    }

    public Memento load(Original o, int i){
        return mementos.get(o).get(i);
    }
}
