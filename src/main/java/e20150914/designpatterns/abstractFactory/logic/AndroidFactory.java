package e20150914.designpatterns.abstractFactory.logic;

import e20150914.designpatterns.abstractFactory.domain.concrete.AndroidScrollbar;
import e20150914.designpatterns.abstractFactory.domain.concrete.AndroidWindow;
import e20150914.designpatterns.abstractFactory.domain.concrete.Platform;

/**
 * Created by alex on 9/14/15.
 */
public class AndroidFactory extends AbstractPlatformFactory {

    public AndroidFactory(){
        setPlatform(new Platform());
    }

    @Override
    public void createScrollbar() {
        getPlatform().setScrollbar(new AndroidScrollbar());
    }

    @Override
    public void createWindow() {
        getPlatform().setWindow(new AndroidWindow());

    }
}
