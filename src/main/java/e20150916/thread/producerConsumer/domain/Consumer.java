package e20150916.thread.producerConsumer.domain;

import e20150907.fiche.util.NumUtil;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingQueue;

/**
 * Created by alex on 9/16/15.
 */
public class Consumer implements Runnable {
    private static Logger logger = LogManager.getLogger(Consumer.class.getName());

    @Setter
    private static boolean done;

    private BlockingQueue<Object> queue;

    public Consumer(BlockingQueue<Object> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object obj = queue.take();
                processObject(obj);
                logger.info("Object processed from list. Size: " + queue.size());
                if (done) {
                    logger.info("Consumer stopped.");
                    return;
                }
            }
        } catch (InterruptedException ex) {
            logger.error("Consumer interrupted");
        }
    }

    private void processObject(Object o) throws InterruptedException {
        Thread.sleep(NumUtil.getRandomInt(500));
    }
}
