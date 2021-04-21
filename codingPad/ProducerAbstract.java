package codingPad;

import java.util.Random;

abstract public class ProducerAbstract implements Runnable {
    int id;

    public ProducerAbstract() {
        this.id = new Random().nextInt(100);
    }

    public Task produce() {
        try {
            Task t = new Task();
            System.out.println("Producer: " + id + " starting " + t.id);
            Thread.sleep((long) (1000 * Math.random()));
            System.out.println("Producer: " + id + " finished " + t.id);
            return t;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
