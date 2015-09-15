package e20150914.designpatterns.behavioral.chainOfResponsibility.logic;

import e20150914.designpatterns.behavioral.chainOfResponsibility.domain.abs.AbstractLogger;
import e20150914.designpatterns.behavioral.chainOfResponsibility.domain.concrete.loggers.DebugLogger;
import e20150914.designpatterns.behavioral.chainOfResponsibility.domain.concrete.loggers.ErrorLogger;
import e20150914.designpatterns.behavioral.chainOfResponsibility.domain.concrete.loggers.InfoLogger;

/**
 * Created by alex on 9/15/15.
 */
public class LoggerManager {

    public static AbstractLogger getLogger(){
        AbstractLogger info = new InfoLogger();
        AbstractLogger debug = new DebugLogger();
        AbstractLogger error = new ErrorLogger();

        error.setNextLogger(debug);
        debug.setNextLogger(info);

        return error;
    }
}
