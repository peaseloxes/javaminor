package e20150914.designpatterns.structural.bridge.domain.abs;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/14/15.
 */
@Getter
@Setter
public abstract class Shape {
    private DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }

    public abstract String draw();
}
