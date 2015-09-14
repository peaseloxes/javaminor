package e20150914.designpatterns.creational.abstractFactory.domain.concrete;

import e20150914.designpatterns.creational.abstractFactory.domain.abs.Scrollbar;
import e20150914.designpatterns.creational.abstractFactory.domain.abs.Window;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 9/14/15.
 */
@Getter
@Setter
public class Platform {
    private Scrollbar scrollbar;
    private Window window;
}
