package codingPad.amz;

import java.util.ArrayList;
import java.util.List;

public class numberOfItems {
    class Solution {
        public List<Integer> numberOfItems(String s, List<List<Integer>> ranges) {
            final char DELIMITER = '|';

            List<Integer> divs = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == DELIMITER) {
                    divs.add(i);
                }
            }
            List<Integer> resItems = new ArrayList<>();

            for (List<Integer> range : ranges) {
                // 1. find the first left div not before start
                // 2. find the right div after this
                // 3. add the * count between left to right
                // 4. use the right div as the next left div,
                //  repeat 2-4 until the right div get out of end index
                // ...
                int total = 0;
                int rangeStart = range.get(0), rangeEnd = range.get(1);
                int lDiv = search(divs, rangeStart); // find the first div not before rS

                // each round get the next div
                //    if next div is out of range end, end
                //    else total += count within range
                //    update leftDiv

                if (lDiv != -1) {
                    while (lDiv + 1 < divs.size()) {
                        int rDiv = lDiv + 1;
                        if (divs.get(rDiv) > rangeEnd) break;

                        total += divs.get(rDiv) - divs.get(lDiv) - 1;
                        lDiv = rDiv;
                    }
                }

                resItems.add(total);
            }


            return resItems;
        }
        private int search(List<Integer> divs, int start) {
            if (divs.isEmpty() || start > divs.get(divs.size() - 1)) return -1;
            int left = 0, right = divs.size() - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (divs.get(mid) == start) {
                    return mid;
                } else if (divs.get(mid) < start) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }
}
