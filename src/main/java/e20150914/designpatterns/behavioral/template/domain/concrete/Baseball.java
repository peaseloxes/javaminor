package e20150914.designpatterns.behavioral.template.domain.concrete;

import e20150914.designpatterns.behavioral.template.domain.abs.Game;

/**
 * Created by alex on 9/15/15.
 */
public class Baseball extends Game{

    @Override
    public String set() {
        return "Setting baseball\n";
    }

    @Override
    public String start() {
        return "Starting baseball\n";
    }

    @Override
    public String stop() {
        return "Stopping baseball\n";
    }
}
