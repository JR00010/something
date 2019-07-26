package test.com.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by noly on 2017/5/19.
 */
public class BlockingQueueTest {

    public static void main (String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);

        producer.start();
//        consumer.start();
    }
}

class Consumer extends Thread {
    private ArrayBlockingQueue<Integer> queue;
    public Consumer(ArrayBlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while(true) {
            try {
                Integer i = queue.take();
                System.out.println("消费者从队列取出元素:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {
    private ArrayBlockingQueue<Integer> queue;
    public Producer(ArrayBlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                queue.put(i);
                System.out.println("生产者向队列插入元素:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}