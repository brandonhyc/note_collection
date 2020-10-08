class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    
    int maxSize;
    BitSet map;
    public PhoneDirectory(int maxNumbers) {
        map = new BitSet(maxNumbers);
        maxSize = maxNumbers;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        int num = map.nextClearBit(0);
        if (num == maxSize) return -1;
        
        map.set(num);
        return num;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !map.get(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        map.clear(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */