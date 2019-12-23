class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        PriorityQueue<String> pq = new PriorityQueue<>();

        for (String prod : products) {
            pq.offer(prod);
        }

        List<List<String>> results = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for (char ch : searchWord.toCharArray()) {
            sb.append(ch);
            String word = sb.toString();
            List<String> result = new ArrayList<>();
            
            while (pq.size() != 0) {
                String prod = pq.poll();
                if (prod.startsWith(word)) {
                    result.add(prod);
                }
                if (result.size() == 3) {
                    break;
                }
            }
            
            for (String prod : result) {
                pq.offer(prod);
            }

            results.add(result);
        }
        
        return results;
    }
}