class PhoneDirectory {

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */

    BitSet map;
    int maxSize;
    public PhoneDirectory(int maxNumbers) {
        map = new BitSet(2 * maxNumbers - 1);
        maxSize = maxNumbers;
    }

    public int get() {
        return get(0, 0, maxSize - 1);
    }

    private int get (int curr, int start, int end) {

        if (map.get(curr)) return -1;
        if (start == end) {
            map.set(curr);
            return start;
        }

        int left = 2 * curr + 1, right = left + 1; // child
        int mid = start + (end - start) / 2; // range
        int res = -1;
        if (map.get(left)) { // left children all used
            res = get(right, mid + 1, end);
        } else {
            res = get(left, start, mid);
        }

        if (map.get(left) && map.get(right)) map.set(curr);

        return res;
    }

    public boolean check(int number) {
        int start = 0, end = maxSize - 1;
        int curr = 0; // node ptr
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (number <= mid) {
                end = mid;
                curr = 2 * curr + 1;
            } else {
                start = mid + 1;
                curr = 2 * curr + 2;
            }
        }
        return !map.get(curr);
    }

    public void release(int number) {
        release(0, 0, maxSize - 1, number);
    }

    private void release(int curr, int start, int end, int number) {
        if (start == end) {
            map.clear(curr);
            return;
        }

        int left = 2 * curr + 1, right = left + 1;
        int mid = start + (end - start) / 2;
        if (number <= mid) {
            release(left, start, mid, number);
        } else {
            release(right, mid + 1, end, number);
        }

        if (!map.get(left) || !map.get(right)) map.clear(curr);
    }

}