package e20150914.designpatterns.behavioral.template.domain.concrete;

import e20150914.designpatterns.behavioral.template.domain.abs.Game;

/**
 * Created by alex on 9/15/15.
 */
public class Football extends Game{

    @Override
    public String set() {
        return "Setting football\n";
    }

    @Override
    public String start() {
        return "Starting football\n";
    }

    @Override
    public String stop() {
        return "Stopping football\n";
    }
}
