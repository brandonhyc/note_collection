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
    public int read(char[] buf, int n) {
        
        char[] bf4 = new char[4];
        int start = 0;
        
        while (n > 0) {
            int readLen = read4(bf4); 
            readLen = Math.min(readLen, n); // if we only need N more chars, update the readLen
            // System.out.printf("readLen: %d, start: %d, start + readLen: %d, n: %d\n", readLen, start, start + readLen, n);
            cpArrContent(bf4, 0, buf, start, readLen);
            start = start + readLen;
            n -= 4;
        }
        
        // if n < 4
//         int readLen = read4(bf4);
//         cpArrContent(bf4, 0, buf, start, readLen);
//         start = start + readLen;
        
        return start;
    }
    
    private void cpArrContent(char[] fromBuf, int start1, char[] toBuf, int start2, int len) {
        for (int i = 0; i < len; i++) {
            // System.out.printf("start1 + i: %d, start2 + i: %d\n", start1 + i, start2 + i);
            toBuf[start2 + i] = fromBuf[start1 + i];
        }
    }
    
    
    
//     int read4(char[] buf);
//     buff = char[4]
//     read4(buff) -> return min(4, len(file))
        

//     "abcdef" n=5 -> output: min(n , len(file))
        
//     "abcdef" 
//     bf4 = "" 
//     read4(bf4) -> "abcd", n = 5 - 4 = 1 , cp to buf[0: 4], 4 
    
//     last round: read4(bf4) -> "ef", n = 1 < 4 [0: n] cp to [4: 4 + n], 4 + n
    
        
    
}