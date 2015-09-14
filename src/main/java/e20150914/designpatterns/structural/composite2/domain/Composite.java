package e20150914.designpatterns.structural.composite2.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/14/15.
 */
public class Composite extends Component{

    private List<Component> component;

    public Composite(){
        setName("Composite");
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
