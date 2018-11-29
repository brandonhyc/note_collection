public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length <= 1)
            return;
        if (k < 1)
            return;
        quickSort(colors, 0, colors.length - 1, 1, k);
    }

    private void quickSort(int[] colors, int start, int end, int colorFrom, int colorTo) {

        if (colorFrom == colorTo) {
            return;
        }

        if (start >= end) {
            return;
        }

        int colorMid = (colorFrom + colorTo) / 2;
        int left = start, right = end;
        while (left <= right) {
            while (left <= right && colors[left] <= colorMid) {
                left++;
            }
            while (left <= right && colors[right] > colorMid) {
                right--;
            }
            if (left <= right) {
                int temp = colors[left];
                colors[left] = colors[right];
                colors[right] = temp;
                left++;
                right--;
            }

        }
        quickSort(colors, start, right, colorFrom, colorMid);
        quickSort(colors, left, end, colorMid + 1, colorTo);
    }
}