public List<Integer> GetSum(List<Integer> A, int k) {
   ArrayList<Integer> result  = new ArrayList<>();
   if (A == null || A.size() == 0 || k <= 0) return result;
   int count = 0;
   for (int i = 0; i < A.size(); i++) {
       count++;
       if (count >= k) {
           int sum = 0;
           for (int j = i; j >= i - k + 1; j--) {
               sum += A.get(j);
           }
           result.add(sum);
       }
   }
   return result;
}
