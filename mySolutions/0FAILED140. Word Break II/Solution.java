//思路: 记忆化搜索 memorized dfs
// 若用普通的dfs, 会吃先TFE, 所以采用 memo 来优化
// 因为要记录一些 substring 结果, 来减少计算次数, 所以不能用 startIndex, 那样的话过于复杂
// 再从这里继续想, 每次递归后应返回 substring 可以被拆分的所以组合, 所以用 list 来储存
// 并且, 返回后, 应该遍历令 list 里每一组合拼接上被 substring 紧跟的前字段 start. 例如 "head "+ ["sub string", "su bstring"...]
// 拼接的同时, 将他们存在results里面. 这样, 我们将results结果, 用整一条string为key的方式存在map里
// 所以, 在进入递归函数以前, 可以判断map里有没有string的记录, 有的话直接使用.

// 易错点1: substring 越界
// 易错点2: for loop 边界条件多大, 导致出口输出永远为空
// 易错点3: 若将 dict.containsKey(s) 判断设为出口, 则会缺少 s 可以被细分的情况
// 易错点4: 涉及substring, 记住 [l, r). 因此, 循环初始值要注意.
public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || 
            dict == null || dict.size() == 0) {
            return new ArrayList<String>();
        }
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>(); 
        return helper(s, dict, map);
    }

    private List<String> helper(String s, Set<String> dict, Map<String, ArrayList<String>> map) {

        ArrayList<String> results = new ArrayList<String>();
        if (s.length() == 0) {
            return results;
        }
        
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        if (dict.contains(s)) {
            results.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            String word = s.substring(0, i);
            
            if (!dict.contains(word)) {
                continue;
            }
            String suffix = s.substring(i);
            List<String> segmentations = 
                helper(suffix, dict, map);
            
            for (String seg: segmentations) {
                String result = word + " " + seg;
                results.add(result);
            }
        }
        map.put(s, results);
        return results;
    }
}
