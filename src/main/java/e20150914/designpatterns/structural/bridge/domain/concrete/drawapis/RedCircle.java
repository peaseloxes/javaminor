package e20150914.designpatterns.structural.bridge.domain.concrete.drawapis;

import e20150914.designpatterns.structural.bridge.domain.abs.DrawAPI;

/**
 * Created by alex on 9/14/15.
 */
public class RedCircle implements DrawAPI {
    @Override
    public String drawCircle(int radius) {
        return "Red circle: " + radius;
    }
}
