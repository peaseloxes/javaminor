package e20150916.thread.producerConsumer.logic;

import e20150916.thread.producerConsumer.domain.Consumer;
import e20150916.thread.producerConsumer.domain.Producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by alex on 9/16/15.
 */
public class ProducerConsumer {
    public ProducerConsumer(int numProducers, int numConsumers) {

        BlockingQueue<Object> queue = new LinkedBlockingQueue<>();

        for (int i = 0; i < numProducers; i++) {
            new Thread(new Producer(queue)).start();
        }
        for (int i = 0; i < numConsumers; i++) {
            new Thread(new Consumer(queue)).start();
        }
    }
}
