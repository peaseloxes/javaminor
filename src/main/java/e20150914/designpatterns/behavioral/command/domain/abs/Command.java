package e20150914.designpatterns.behavioral.command.domain.abs;

import e20150914.designpatterns.behavioral.command.domain.concrete.Video;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/15/15.
 */
public abstract class Command {
    @Setter
    @Getter
    private Video video;

    public abstract void execute();
}
