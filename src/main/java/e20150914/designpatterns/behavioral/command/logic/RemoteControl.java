package e20150914.designpatterns.behavioral.command.logic;

import e20150914.designpatterns.behavioral.command.domain.abs.Command;
import lombok.Setter;

/**
 * Created by alex on 9/15/15.
 */
public class RemoteControl {
    @Setter
    private Command command;

    public void pressButton(){
        command.execute();
    }
}
