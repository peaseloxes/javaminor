package e20150914.designpatterns.creational.singleton;

/**
 * Created by alex on 9/14/15.
 */
public enum Singleton {
    SINGLE;

    private Single single;

    Singleton(){
        this.single = new Single();
    }

    public static Singleton getInstance(){
        return SINGLE;
    }

    public Single getSingle(){
        return single;
    }
}
