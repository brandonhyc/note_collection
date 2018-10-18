public class Solution {
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here

        if (n <= 0) {
            return -1;
        }

        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        Long[] primes = new Long[3];

        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);
        
        for (int i  = 0; i < 3; i++) {
            queue.add(primes[i]);
            set.add(primes[i]);
        }

        Long number = Long.valueOf(1);
        for (int i = 1; i < n; i++) {
            number = queue.poll();
            for (Long prime : primes) {
                Long nextNum = prime * number;
                if (!set.contains(nextNum)) {
                    queue.add(nextNum);
                    set.add(nextNum);
                }
            }
        }
        return number.intValue();
    }
}   