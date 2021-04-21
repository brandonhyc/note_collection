package codingPad;

import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    int id;
    static AtomicInteger counter = new AtomicInteger();

    public Task() {
        this.id = counter.getAndIncrement();
        System.out.println("new Task is created id: " + this.id);
    }
}
