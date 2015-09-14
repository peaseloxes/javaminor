package e20150914.designpatterns.singleton;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by alex on 9/14/15.
 */
public class SingletonTest {

    @Test
    public void testSingleton(){
        final Single single1 = Singleton.SINGLE.getInstance();
        final Single single2 = Singleton.SINGLE.getInstance();

        assertTrue(single1==single2);
    }

}