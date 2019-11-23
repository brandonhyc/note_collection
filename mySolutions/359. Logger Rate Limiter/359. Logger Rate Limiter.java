class Logger {

    class Log {
        int timestamp;
        String message;
        Log(int timestamp, String message){
            this.timestamp = timestamp;
            this.message = message;
        }
    }
    
    Set<String> set;
    PriorityQueue<Log> queue;

    /** Initialize your data structure here. */
    public Logger() {
        this.set = new HashSet<>();
        this.queue = new PriorityQueue<>(10, new Comparator<Log>() {
            public int compare(Log log1, Log log2) {
                return log1.timestamp - log2.timestamp;
            }
        });
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (queue.size() > 0 && timestamp - queue.peek().timestamp >= 10) {
            Log log = queue.poll();
            set.remove(log.message);
        }
        // System.out.printf("time: %d, set: %s\n", timestamp, set.toString());
        if (!set.contains(message)) {
            set.add(message);
            queue.offer(new Log(timestamp, message));
            return true;
        }

        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */