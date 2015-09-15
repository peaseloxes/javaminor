package e20150914.designpatterns.behavioral.chainOfResponsibility.domain.abs;

import e20150914.designpatterns.behavioral.chainOfResponsibility.domain.concrete.LoggerLevel;

/**
 * Created by alex on 9/15/15.
 */
public abstract class AbstractLogger {

    private LoggerLevel level;
    private AbstractLogger nextLogger;

    public void setNextLogger(final AbstractLogger logger){
        this.nextLogger = logger;
    }

    protected void setLevel(LoggerLevel level){
        this.level = level;
    }

    public String log(final LoggerLevel level, final String message){
        if(this.level.suited(level)){
            return writeMessage(message);
        }else if(nextLogger!=null){
            return nextLogger.log(level,message);
        }
        return "";
    }

    protected abstract String writeMessage(final String message);

}
