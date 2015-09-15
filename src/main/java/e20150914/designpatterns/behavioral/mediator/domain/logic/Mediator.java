package e20150914.designpatterns.behavioral.mediator.domain.logic;

import e20150914.designpatterns.behavioral.mediator.domain.abs.Device;
import e20150914.designpatterns.behavioral.mediator.domain.abs.User;

import java.util.List;

/**
 * Created by alex on 9/15/15.
 */
public class Mediator {

    private List<Device> deviceList;

    public Mediator(final List<Device> list) {
        this.deviceList = list;
    }

    public String sendMessage(final User user, final String message) {
        String s = "";

        for (Device device : deviceList) {
            s += device.showMessage(user, message);
        }
        return s;
    }
}
