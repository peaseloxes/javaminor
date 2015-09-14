package e20150914.designpatterns.abstractFactory.logic;

import e20150914.designpatterns.abstractFactory.domain.concrete.Platform;
import e20150914.designpatterns.abstractFactory.domain.concrete.WindowsScrollbar;
import e20150914.designpatterns.abstractFactory.domain.concrete.WindowsWindow;

/**
 * Created by alex on 9/14/15.
 */
public class WindowsFactory extends AbstractPlatformFactory{

    public WindowsFactory(){
        setPlatform(new Platform());
    }

    @Override
    public void createScrollbar() {
        getPlatform().setScrollbar(new WindowsScrollbar());
    }

    @Override
    public void createWindow() {
        getPlatform().setWindow(new WindowsWindow());

    }
}
