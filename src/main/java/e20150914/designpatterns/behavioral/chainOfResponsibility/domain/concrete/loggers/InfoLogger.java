package e20150914.designpatterns.behavioral.chainOfResponsibility.domain.concrete.loggers;

import e20150914.designpatterns.behavioral.chainOfResponsibility.domain.abs.AbstractLogger;
import e20150914.designpatterns.behavioral.chainOfResponsibility.domain.concrete.LoggerLevel;

/**
 * Created by alex on 9/15/15.
 */
public class InfoLogger extends AbstractLogger {

    public InfoLogger(){
        setLevel(LoggerLevel.INFO);
    }

    @Override
    protected String writeMessage(String message) {
        return "INFO: " + message;
    }
}
