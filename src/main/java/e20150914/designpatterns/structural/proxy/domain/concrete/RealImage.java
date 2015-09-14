package e20150914.designpatterns.structural.proxy.domain.concrete;

import e20150914.designpatterns.structural.proxy.domain.abs.Image;

/**
 * Created by alex on 9/14/15.
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public String show() {
        return "Showing " + fileName;
    }
}
