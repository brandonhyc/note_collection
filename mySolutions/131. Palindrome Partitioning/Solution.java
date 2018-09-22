public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        helper(s, result, 0, new ArrayList<String>());
        
        return result;

    }
    
    private void helper(String s, List result, int startIndex, List<String> partition) {
        System.out.println(partition);
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String subString = s.substring(startIndex, i + 1);
            if (!isPalindrome(subString)) {
                continue;
            }
            partition.add(subString);
            helper(s, result, i + 1, partition);
            partition.remove(partition.size() - 1);
        }
        
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
    
}