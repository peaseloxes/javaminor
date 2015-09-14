package e20150914.designpatterns.structural.composite2.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/14/15.
 */
public abstract class Component {

    @Getter
    @Setter
    private String name;

    private List<Component> component;

    public Component(){
        component = new ArrayList<>();
    }

    public void addComponent(Component component){
        this.component.add(component);
    }

    public void removeComponent(Component component){
        this.component.remove(component);
    }

    public Component getChild(int index){
        return component.get(index);
    }

}
