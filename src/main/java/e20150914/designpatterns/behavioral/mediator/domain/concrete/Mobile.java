package e20150914.designpatterns.behavioral.mediator.domain.concrete;

import e20150914.designpatterns.behavioral.mediator.domain.abs.Device;
import e20150914.designpatterns.behavioral.mediator.domain.abs.User;

/**
 * Created by alex on 9/15/15.
 */
public class Mobile implements Device {
    @Override
    public String showMessage(User user, String message) {
        return "Mobile: " + user.getName() + " " + message;
    }
}
