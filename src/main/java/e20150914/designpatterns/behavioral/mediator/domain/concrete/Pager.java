package e20150914.designpatterns.behavioral.mediator.domain.concrete;

import e20150914.designpatterns.behavioral.mediator.domain.abs.Device;
import e20150914.designpatterns.behavioral.mediator.domain.abs.User;

/**
 * Created by alex on 9/15/15.
 */
public class Pager implements Device {
    @Override
    public String showMessage(User user, String message) {
        return "Pager: " + user.getName() + " " + message;
    }
}
