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
        Map<String, Integer> competitorsMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String s: reviews) {
            String[] words = s.split(" ");
            for (String word: words) {
                if (competitors.contains(word.toLowerCase())) {
                    competitorsMap.put(word, competitorsMap.getOrDefault(word, 0) + 1);
                }
            }
        }
    
        List<Competitor> competitorList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : competitorsMap.entrySet()) {
            competitorList.add(new Competitor(entry.getKey(), entry.getValue()));
        }
        competitorList.sort((a,b) -> {
            if (a.occurrences.equals(b.occurrences)) {
                return b.name.compareTo(a.name);
            } else {
                return b.occurrences - a.occurrences;
            }
        });
        for (int i=0; i<topNCompetitors; i++) {
            result.add(competitorList.get(i).name);
        }
        return result;
    }

    static class Competitor {
    
        Competitor(String name, Integer occurrences) {
            this.name = name;
            this.occurrences = occurrences;
        }
    
        String name;
        Integer occurrences;
    }
}