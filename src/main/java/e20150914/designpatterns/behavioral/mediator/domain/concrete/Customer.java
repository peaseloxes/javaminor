package e20150914.designpatterns.behavioral.mediator.domain.concrete;

import e20150914.designpatterns.behavioral.mediator.domain.abs.User;

/**
 * Created by alex on 9/15/15.
 */
public class Customer implements User {

    private String name;

    public Customer(final String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
