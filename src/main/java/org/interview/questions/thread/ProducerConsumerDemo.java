package org.interview.questions.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(5);
        ExecutorService exec = Executors.newCachedThreadPool();

        // 1 producer, 2 consumers
        exec.submit(new Producer(queue, 20));
        exec.submit(new Consumer(queue));
        exec.submit(new Consumer(queue));

        exec.shutdown();
        exec.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Demo finished");
    }
}

//Pojo
class Message{
    private final int id;

    public Message(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                '}';
    }
}

class Producer implements Runnable {
    private final BlockingQueue<Message> queue;
    private final int maxMessages;
    private final AtomicInteger counter = new AtomicInteger();

    public Producer(BlockingQueue<Message> queue, int maxMessages) {
        this.queue = queue;
        this.maxMessages = maxMessages;
    }

@Override
    public void run(){
        try{
            for(int i=0; i<maxMessages; i++){
                Message message = new Message(counter.incrementAndGet());
                queue.put(message);
                System.out.println(Thread.currentThread().getName() +
                        " published " + message);
                Thread.sleep(100); // simulate delay
            }
            // Poison pill to signal consumers to stop
            queue.put(new Message(-1));
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {

            while(true){
                Message message = queue.take();
                if(message.getId() < 0){
                    break;
                }
                System.out.println(Thread.currentThread().getName() +
                        " consumed " + message);
            }
            Thread.sleep(200); // simulate processing time
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
