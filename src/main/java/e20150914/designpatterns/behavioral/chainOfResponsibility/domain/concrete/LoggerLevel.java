package e20150914.designpatterns.behavioral.chainOfResponsibility.domain.concrete;

/**
 * Created by alex on 9/15/15.
 */
public enum LoggerLevel {
    INFO(1),DEBUG(2),ERROR(3);

    private final int value;

    LoggerLevel(final int value){
        this.value = value;
    }

    public boolean suited(final LoggerLevel level){
        return (this.value == level.value);
    }

}
