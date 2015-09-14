package e20150914.designpatterns.singleton;

/**
 * Created by alex on 9/14/15.
 */
public enum Singleton {
    SINGLE;

    private Single instance;

    public Single getInstance(){
        if(instance==null){
            instance = new Single();
        }
        return instance;
    }
}
