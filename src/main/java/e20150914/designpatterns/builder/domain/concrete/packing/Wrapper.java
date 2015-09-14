package e20150914.designpatterns.builder.domain.concrete.packing;

import e20150914.designpatterns.builder.domain.abs.Packing;

/**
 * Created by alex on 9/14/15.
 */
public class Wrapper extends Packing {

    @Override
    public String getName() {
        return "Wrapper";
    }
}
