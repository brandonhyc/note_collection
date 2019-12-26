import java.util.PriorityQueue;

class Solution {

    int NAME = 0;
    int TIME = 1;
    int AMOUNT = 2;
    int CITY = 3;

    public List<String> invalidTransactions(String[] transactions) {

        Map<String, List<String>> userTranMap = new HashMap<>();
        // 1. time conflict
        for (String tran : transactions) {
            String[] tranArray = tran.split(",");
            PriorityQueue<String[]> maxheap = userTranMap.getOrDefault(tranArray[NAME],
                    new PriorityQueue<String[]>((t1, t2) -> t1[NAME].compareTo(t2[NAME])));
            maxheap.offer(tranArray);
            userTranMap.put(tranArray[NAME], maxheap);
        }

        // 2. remove all exceeds 1000
        for (String key : userTranMap.keySet()) {
            List<String> allTrans = userTranMap.get(key);
            List<String> inValidTrans = new ArrayList<>();
            for (int i = 0; i < allTrans.size(); i++) {
                if (tranIsValid(trans, i)) {
                    continue;
                }
                inValidTrans.add(trans.get(i));
            }
        }
        return inValidTrans;
    }

    private boolean tranIsValid(List<String> trans, int i) {
        if (Integer.valueOf(trans.get(i)[AMOUNT]) > 1000) {
            return false;
        }
        if (i - 1 > 0 && Integer.valueOf(trans.get(i)[TIME]) - Integer.valueOf(trans.get(i - 1)[TIME]) <= 60
                && trans.get(i)[CITY] != trans.get(i - 1)[CITY]) {
            return false;
        }
        if (i + 1 <= trans.size() - 1
                && Integer.valueOf(trans.get(i + 1)[TIME]) - Integer.valueOf(trans.get(i)[TIME]) <= 60
                && trans.get(i + 1)[CITY] != trans.get(i)[CITY]) {
            return false;
        }

        return true;
    }
}