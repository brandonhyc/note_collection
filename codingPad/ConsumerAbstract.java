package codingPad;

import java.util.Random;

abstract public class ConsumerAbstract implements Runnable {
    int id;

    public ConsumerAbstract() {
        this.id = new Random().nextInt(100);
    }

    public void consume(Task t) {
        try {
            System.out.println("Consumer: " + id + " starting " + t.id);
            Thread.sleep((long) (10 * Math.random()));
            System.out.println("Consumer: " + id + " finished " + t.id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
