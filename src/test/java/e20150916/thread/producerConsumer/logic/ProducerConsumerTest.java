package e20150916.thread.producerConsumer.logic;

import e20150916.thread.producerConsumer.domain.Consumer;
import e20150916.thread.producerConsumer.domain.Producer;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by alex on 9/16/15.
 */
public class ProducerConsumerTest extends TestCase {

    @Test
    public void testProducerConsumer() throws InterruptedException {
        // Start producers and consumers
        int numProducers = 4;
        int numConsumers = 3;
        ProducerConsumer pc = new ProducerConsumer(numProducers, numConsumers);

        // Let the simulation run for, say, 5 seconds
        Thread.sleep(5 * 1000);

        // End of simulation - shut down gracefully
        Producer.setDone(true);
        Consumer.setDone(true);
    }

}