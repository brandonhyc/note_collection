class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {

        int total = a.length + b.length;
        if (total % 2 == 0) {
            int x = search(total / 2, a, b);
            int y = search(total / 2 + 1, a, b);
            return (x + y) / 2.0;
        } else {
            return 0.0 + search((total + 1) / 2, a, b);
        }
    }

    public int search(int k, int[] a, int[] b) {
        int sa = 0, sb = 0;
        while (k != 1) {
            int half = k / 2;
            int va = sa + half - 1 < a.length ? a[sa + half - 1] : Integer.MAX_VALUE;
            int vb = sb + half - 1 < b.length ? b[sb + half - 1] : Integer.MAX_VALUE;

            if (va <= vb) {
                sa += half;
                k -= half;
            } else {
                sb += half;
                k -= half;
            }
        }

        return (sa >= a.length || sb < b.length && a[sa] > b[sb]) ? b[sb] : a[sa];
    }
}