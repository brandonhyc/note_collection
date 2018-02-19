//18.02.2018 second time
public int sqrt (int x) {

    if (x <= 0) {
        return x;
    }

    int start = 1, end = x;
    while (start + 1 < end) {
        int mid = start + (end - start) /2;
        // 
        if (mid * mid == x) {
            return mid;
        } else if (mid * mid <= x) {
            start = mid;
        } else if (mid * mid > x) {
            end = mid;
        }
    }

    if (start * start <= x) {
        return start;
    }
    return end;

}



//18.02.2018
public int sqrt(int x) {
    if (x == 0) {
        return 0;
    }

    int start = 1, end = x;
    while (start + 1 < end) {
        int mid = start + (end - start) /2;
        if ( x / mid == mid ) {
            return x;
        } else if (x / mid < mid) {
            start = mid;
        } else {
            end = mid;
        }
    }

    return -1;

}