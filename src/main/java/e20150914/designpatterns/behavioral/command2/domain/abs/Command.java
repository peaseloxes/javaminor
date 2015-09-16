package e20150914.designpatterns.behavioral.command2.domain.abs;

/**
 * Created by alex on 9/16/15.
 */
public abstract class Command {
    public abstract void execute();
    public abstract void undo();
}