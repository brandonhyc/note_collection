import java.util.*;

public class HelloWorld{

    public static void main(String []args){
        List<String> competitors = new ArrayList<>();
        competitors.add("newshop");
        competitors.add("shopnow");
        competitors.add("afshion");
        competitors.add("fashionbeats");
        competitors.add("mymarket");
        competitors.add("tcellular");

        List<String> reviews = new ArrayList<>();
        reviews.add("newshop is a providing good services in the city, everyone; everyone should use newshop");
        reviews.add("best services by newshop");
        reviews.add("fashionbeats has great services in the city");
        reviews.add("I am proud to have fashionbeats");
        reviews.add("mymarket has awesome services");
        reviews.add("Thanks Newshop for the quick delivery");

        // numCompetitors=6
        // topNCompetitors=2

        getTopNCompetitors(6,2,competitors, 6, reviews).forEach(System.out::println);
    }
     
     
    static List<String> getTopNCompetitors(int numCompetitors, int topNCompetitors, List<String> competitors, int numReviews, List<String> reviews) {
        Set<String> competitorsSet = new HashSet<>();
        Map<String, Integer> countsMap = new HashMap<>();
        PriorityQueue<String> minHeap = new PriorityQueue<>((n1, n2) -> countsMap.get(n1) - countsMap.get(n2));
        List<String> result = new ArrayList<>();

        for (String comp : competitors) {
            competitorsSet.add(comp.toLowerCase());
        }

        for (String review : reviews) {
            String[] words = review.split("\\W+");
            for (String word : words) {
                word = word.toLowerCase();
                if (competitorsSet.contains(word)) {
                    if (!countsMap.containsKey(word)) {
                        countsMap.put(word, 0);
                    }
                    countsMap.put(word, countsMap.get(word) + 1);
                }
            }
        }

        for (String key : countsMap.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > topNCompetitors) {
                minHeap.poll();
            }
        }

        while (minHeap.size() != 0) {
            result.add(minHeap.poll());
        }

        Collections.reverse(result);
        
        return result;
    }
}