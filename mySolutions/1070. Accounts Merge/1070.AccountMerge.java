public class Solution {
    Map<Integer, Integer> father;
    /**
     * @param accounts: List[List[str]]
     * @return: return a List[List[str]]
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        father = new HashMap();

        Map<String, List> mapEmailToIds = getEmailToIds(accounts);
        for (String email : mapEmailToIds.keySet()) {
            List<Integer> ids = mapEmailToIds.get(email);
            for (int i = 1; i < ids.size(); i++) {
                union(ids.get(i), ids.get(0));
            }
        }

        Map<Integer, Set<String>> idToEmail = getIdToEmail(accounts);
        List<List<String>> mergeAccounts = new ArrayList<>();
        for (Integer id : idToEmail.keySet()) {
            List<String> sortedEmails = new ArrayList(idToEmail.get(id));
            Collections.sort(sortedEmails);
            sortedEmails.add(0, accounts.get(id).get(0));
            mergeAccounts.add(sortedEmails);
        }
        return mergeAccounts;
    }

    private Map<String, List> getEmailToIds(List<List<String>> accounts) {
        Map<String, List> mapEmailToIds = new HashMap<>();

        for (int indexOfAccount = 0; indexOfAccount < accounts.size(); indexOfAccount++) {
            List<String> account = accounts.get(indexOfAccount);
            for (int indexOfEmail = 1; indexOfEmail < account.size(); indexOfEmail++) {
                String email = account.get(indexOfEmail);

                if (!mapEmailToIds.containsKey(email)) {
                    mapEmailToIds.put(email, new ArrayList<Integer>());
                }
                List<Integer> ids = mapEmailToIds.get(email);
                ids.add(indexOfAccount);
            }
        }
        return mapEmailToIds;
    }

    private Map<Integer, Set<String>> getIdToEmail(List<List<String>> accounts) {
        Map<Integer, Set<String>> mapIdToEmail = new HashMap<>();

        for (int indexOfAccount = 0; indexOfAccount < accounts.size(); indexOfAccount++) {
            int rootId = find(indexOfAccount);
            List<String> account = accounts.get(indexOfAccount);

            if (!mapIdToEmail.containsKey(rootId)) {
                mapIdToEmail.put(rootId, new HashSet<String>());
            }

            Set<String> emails = mapIdToEmail.get(rootId);

            for (int i = 1; i < account.size(); i++) {
                emails.add(account.get(i));
            }
            mapIdToEmail.put(indexOfAccount, emails);
        }
        return mapIdToEmail;
    }

    private int find(int id) {
        if (!father.containsKey(id) || father.get(id) == id) {
            father.put(id, id);
            return id;
        }
        int rootId = find(father.get(id));
        father.put(id, rootId);
        return rootId;
    }

    private void union(int id1, int id2) {
        int root1 = find(id1);
        int root2 = find(id2);
        if (root1 != root2) {
            father.put(root1, root2);
        }
    }

}