package e20150914.designpatterns.structural.proxy.domain.concrete;

import e20150914.designpatterns.structural.proxy.domain.abs.Image;

/**
 * Created by alex on 9/14/15.
 */
public class ProxyImage implements Image {

    private RealImage image;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public String show() {
        if(image==null){
            image = new RealImage(fileName);
            return "Loading " + fileName;
        }else{
            return image.show();
        }
    }
}
