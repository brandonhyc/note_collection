class PhoneDirectory {
    
    Set<Integer> directory = new HashSet<>(); 
    
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        directory = new HashSet<>();
        
        for (int i = 0; i < maxNumbers; i++) {
            directory.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        Iterator it = directory.iterator();
        if (!it.hasNext()) {
            return -1;
        }
        Integer next = (Integer) it.next();
        directory.remove(next);
        return next;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return directory.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        directory.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */