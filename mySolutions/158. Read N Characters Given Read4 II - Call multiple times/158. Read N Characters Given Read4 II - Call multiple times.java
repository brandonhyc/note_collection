/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    int HITLIST_SIZE = 4;
    Queue<Character> lastRead = new LinkedList<>();
    
    public int read(char[] buf, int n) {

        int start = 0;
        // read from buff of last unread
        while (lastRead.size() != 0 && n > 0) {
            buf[start] = lastRead.poll();
            start += 1;
            n -= 1;
        }

        while (n > 0) {
            char[] bf4 = new char[HITLIST_SIZE];
            int readLen = read4(bf4); // file "ab" if we want 3 -> 2
            int copyLen = Math.min(readLen, n);
            copy(bf4, 0, buf, start, copyLen);            
            start += copyLen;
            if (n < readLen) {
                for (int i = copyLen; i < readLen; i++) {
                    lastRead.offer(bf4[i]);
                }
            }
            n -= HITLIST_SIZE;
        }
        
        return start;
    }
    
    private void copy(char[] fromBuf, int start1, char[] toBuf, int start2, int len) {
        for (int i = 0; i < len; i++) {
            toBuf[start2 + i] = fromBuf[start1 + i];
        }
    }
}