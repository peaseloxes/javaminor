package e20150914.designpatterns.structural.facade.domain;

import lombok.Getter;

/**
 * Created by alex on 9/14/15.
 */
public class Flight {

    @Getter
    private static final String[] flights = new String[]{"KLM","NorthWest","Air France"};

    // lots of complicated stuff
}
