package codingPad.amz;

import java.util.*;

public class debtRecords {

    class Solution {
        public List<String> debtRecords(List<List<String>> debts) {
            Map<String, Integer> countries = new HashMap<>();
            for (int i = 0; i < debts.size(); i++) {
                String brw = debts.get(i).get(0);
                String ldr = debts.get(i).get(1);
                Integer amt = Integer.parseInt(debts.get(i).get(2));

                countries.putIfAbsent(brw, 0);
                countries.putIfAbsent(ldr, 0);

                countries.put(brw, countries.get(brw) - amt);
                countries.put(ldr, countries.get(ldr) + amt);
            }

            List<String> lagDebCtrs = new ArrayList<>();
            Integer lagDebAmt = Integer.MAX_VALUE;

            for (Map.Entry<String, Integer> en : countries.entrySet()) {
                if (en.getValue() < lagDebAmt) {
                    lagDebCtrs = new ArrayList<>();
                    lagDebAmt = en.getValue();
                }
                if (en.getValue() == lagDebAmt) {
                    lagDebCtrs.add(en.getKey());
                }
            }

            if (lagDebAmt >= 0) {
                lagDebCtrs = new ArrayList<>();
                lagDebCtrs.add("No countries have debt.");
            } else {
                Collections.sort(lagDebCtrs);
            }

            return lagDebCtrs;
        }
    }
}
