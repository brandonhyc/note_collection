import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore fooLock;
    private Semaphore booLock;
    
    public FooBar(int n) {
        this.n = n;
        this.fooLock = new Semaphore(1);
        this.booLock = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            
            fooLock.acquire();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            booLock.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            booLock.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            fooLock.release();
        }
    }
}