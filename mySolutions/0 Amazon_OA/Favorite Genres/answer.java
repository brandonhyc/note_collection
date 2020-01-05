// "static void main" must be defined in a public class.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
   public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
   	Map<String, List<String>> res = new HashMap<>();
   	Map<String, String> songstogenre = new HashMap<>();
   	
   	for(String genre : genreMap.keySet()) {
   		List<String> songs = genreMap.get(genre);
   		for(String song : songs) {
   			songstogenre.put(song, genre);
   		}
   	}
       Map<String, Integer> count = new HashMap();
   	int max = 0;
   	for(String user : userMap.keySet()) {
           count = new HashMap();
           max = 0;
           res.put(user, new ArrayList());
   		List<String> songs = userMap.get(user);
   		for(String song : songs) {
   			String genre = songstogenre.get(song);
   			int c = count.getOrDefault(genre, 0) + 1;
   			count.put(genre, c);
               max = Math.max(c, max);
   		}
           for (String key : count.keySet()) {
               if (count.get(key) == max) {
                   res.get(user).add(key);
               }
           }
   	}
   	return res;
   }
}


public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> userMap = new HashMap<>();
		List<String> list1 = Arrays.asList("song1", "song2", "song3", "song4", "song8");
		List<String> list2 = Arrays.asList("song5", "song6", "song7");
		userMap.put("David", list1);
		userMap.put("Emma", list2);
		
		Map<String, List<String>> genreMap = new HashMap<>();
		List<String> list3 = Arrays.asList("song1", "song3");
		List<String> list4 = Arrays.asList("song7");
		List<String> list5 = Arrays.asList("song2", "song4");
		List<String> list6 = Arrays.asList("song5", "song6");
		List<String> list7 = Arrays.asList("song8", "song9");
		genreMap.put("Rock", list3);
		genreMap.put("Dubstep", list4);
		genreMap.put("Techno", list5);
		genreMap.put("Pop", list6);
		genreMap.put("Jazz", list7);
        
        /*Map<String, List<String>> userMap = new HashMap<>();
		List<String> list1 = Arrays.asList("song1", "song2");
		List<String> list2 = Arrays.asList("song3", "song4");
		userMap.put("David", list1);
		userMap.put("Emma", list2);
		
		Map<String, List<String>> genreMap = new HashMap<>();*/
        
        System.out.println(new Solution().favoritegenre(userMap, genreMap));
    }
}
