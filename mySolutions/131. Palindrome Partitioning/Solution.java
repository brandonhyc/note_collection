public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<List>();
        if (s.length() == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        helper();
        
        return result;

    }
    
    private void helper(String s, List result, int startIndex, List<String> partition) {
        
        if (startIndex >= s.length) {
            result.add(partition);
            return result;
        }

        for (int i = startIndex; i < s.length(); i++) {
            
            if (!isPalindrome(s.substring(startIndex, s.length()))) {
                continue;
            }
            partition.add(s.substring(startIndex, i + 1));
            helper(s, result, startIndex + 1, partition);
            partition.remove(partition.size() - 1);
        }
        
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return false;
        }
        for (int left = 0, right = s.length(); left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
    
}