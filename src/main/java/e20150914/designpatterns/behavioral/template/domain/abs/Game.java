package e20150914.designpatterns.behavioral.template.domain.abs;

/**
 * Created by alex on 9/15/15.
 */
public abstract class Game {

    public abstract String set();
    public abstract String start();
    public abstract String stop();

    public String play(){

        StringBuilder response = new StringBuilder();

        response.append(set());

        response.append(start());

        response.append(stop());

        return response.toString();
    }

}
