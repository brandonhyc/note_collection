class Solution {
    public int search(ArrayReader r, int target) {
        
    
//     [-1,0,3,5,9,12]
//     500
//     n = 6
//     ar.get(3) -> 5
//     ar.get(8) -> maxsize

//     1 -> [0, 1]
//     2 -> [1, 3]
//     4 -> [4, 8]
//     ...
//     maxsize / 2, maxsize
          
    // step 1 search range
          
    int start = 0;
    int end = 1;
          
    while (r.get(end) < target) { // not within the range
        
        int size = (end - start) * 2;
        start = end + 1;
        end = Math.min(end + 1 + size, 10000);
        // System.out.printf("start: %d, end: %d\n", start, end);
    }
    
    // step 2 search number
    int left = start;
    int right = end;
    
    while (left <= right) {
        
        int mid = left + (right - left) / 2;
        if (r.get(mid) == target) {
            return mid;
        }
        else if (r.get(mid) < target) {
            left = mid + 1;
        }
        else if (r.get(mid) > target) {
            right = mid - 1;
        }
    }
    
    return -1;
        
    }
}