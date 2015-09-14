package e20150914.designpatterns.abstractFactory.logic;

import e20150914.designpatterns.abstractFactory.domain.concrete.Platform;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/14/15.
 */
public abstract class AbstractPlatformFactory {
    @Getter
    @Setter
    private Platform platform;

    public abstract void createScrollbar();
    public abstract void createWindow();
}
