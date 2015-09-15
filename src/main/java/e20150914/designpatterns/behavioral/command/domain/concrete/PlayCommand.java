package e20150914.designpatterns.behavioral.command.domain.concrete;

import e20150914.designpatterns.behavioral.command.domain.abs.Command;

/**
 * Created by alex on 9/15/15.
 */
public class PlayCommand extends Command{



    @Override
    public void execute() {
        getVideo().setState("Playing");
    }
}
