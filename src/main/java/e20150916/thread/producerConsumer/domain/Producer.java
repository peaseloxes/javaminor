package e20150916.thread.producerConsumer.domain;

import e20150907.fiche.util.NumUtil;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingQueue;

/**
 * Created by alex on 9/16/15.
 */
public class Producer implements Runnable {
    private static Logger logger = LogManager.getLogger(Producer.class.getName());

    private BlockingQueue<Object> queue;

    @Setter
    private static boolean done;

    public Producer(BlockingQueue<Object> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try{
                Object justProduced = fetchObject();
                queue.put(justProduced);
                logger.info("Object added to list. Size: " + queue.size());
            }catch(InterruptedException e){
                logger.error("Producer interrupted");
            }
            if(done){
                logger.info("Producer stopped.");
                return;
            }
        }
    }

    private Object fetchObject() throws InterruptedException {
        Thread.sleep(NumUtil.getRandomInt(500));
        return new Object();
    }
}
