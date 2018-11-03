//lintcode: 600
public class Solution {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // write your code here
        if (image == null || image.length == 0 ||
            image[0].length == 0) {
                return 0;
        }

        int n = image.length;
        int m = image[0].length;

        int left = findLeft(image, 0, y);
        int right = findRight(image, y, m - 1);
        int bottom = findBottom(image, 0, x);
        int top = findTop(image, x, n - 1);

        return (right - left + 1) * (top - bottom + 1);
    }

    private int findLeft(char[][] image, int start, int end) {
        
        while (start + 1 < end) {
        int mid = start + (end - start) / 2;
            if (columnIsEmpty(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (!columnIsEmpty(image, start)) return start;
        if (!columnIsEmpty(image, end)) return end;

        return -1;
    }
    private int findRight(char[][] image, int start, int end) {
        
        while (start + 1 < end) {
        int mid = start + (end - start) / 2;
            if (columnIsEmpty(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (!columnIsEmpty(image, end)) return end;
        if (!columnIsEmpty(image, start)) return start;

        return -1;
    }
    private int findTop(char[][] image, int start, int end) {
        
        while (start + 1 < end) {
        int mid = start + (end - start) / 2;
            if (rowIsEmpty(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (!rowIsEmpty(image, end)) return end;
        if (!rowIsEmpty(image, start)) return start;

        return -1;
    }
    private int findBottom(char[][] image, int start, int end) {
        
        while (start + 1 < end) {
        int mid = start + (end - start) / 2;
            if (rowIsEmpty(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (!rowIsEmpty(image, start)) return start;
        if (!rowIsEmpty(image, end)) return end;

        return -1;
    }

    private boolean columnIsEmpty(char[][] image, int index) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][index] == '1') {
                return false;
            }
        }
        return true;
    }

    private boolean rowIsEmpty(char[][] image, int index) {
        for (int i = 0; i < image[0].length; i++) {
            if (image[index][i] == '1') {
                return false;
            }
        }
        return true;
    }



}