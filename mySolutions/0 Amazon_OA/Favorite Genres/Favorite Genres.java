// "static void main" must be defined in a public class.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreSongMap) {
		Map<String, List<String>> userGenreMap = new HashMap<>();
		Map<String, String> songGenreMap = new HashMap<>();
        
        // generate map song : genre
        for (String genre : genreSongMap.keySet()) {
            for (String song : genreSongMap.get(genre)) {
                songGenreMap.put(song, genre);
            }
        }

        Map<String, Map<String, Integer>> userGenreCount = new HashMap<>(); // check genre hit count
        
        for (String user : userMap.keySet()) {
            if (!userGenreCount.containsKey(user)) {
                userGenreCount.put(user, new HashMap<>());
            }
            Map<String, Integer> genreCountMap = userGenreCount.get(user); 
            int maxCount = 0;
            for (String song : userMap.get(user)) {
                String genre = songGenreMap.get(song);
                if (genre == null) {
                    continue;
                } 
                
                int count = genreCountMap.getOrDefault(genre, 0) + 1;
                genreCountMap.put(genre, count);
                
                if (count > maxCount) {
                    maxCount = count;
                    userGenreMap.put(user, new ArrayList<>());
                }
                if (count == maxCount) {
                    userGenreMap.get(user).add(genre);    
                }
            }
        }

        return userGenreMap;
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
        System.out.println(new Solution().favoritegenre(userMap, new HashMap<>()));
    }
}