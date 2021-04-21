package codingPad.amz;

import java.util.*;

public class fetchResultsToDisplay {

    public List<String> fetchResultsToDisplay(int sortColumn, int sortOrder,
                                                     int resultsPerPage, int pageIndex,
                                                     Map<String, int[]> results) {
        // 1. sort the result based on a comparator
        //        which is based on given column in given sorted order
        // 2. calculate the starting item index based on the page size
        // 3. print all the items from that starting idx

        List<String> sortedUrls = new ArrayList<>(); // not sorted yet
        for (String key : results.keySet()) {
            sortedUrls.add(key);
        }
        Collections.sort(sortedUrls, new Comparator<String>() {
            @Override
            public int compare(String urlsA, String urlsB) {
                int[] colsA = results.get(urlsA), colsB = results.get(urlsB);
                int cp = Integer.compare(colsA[sortColumn - 1], colsB[sortColumn - 1]);
                return sortOrder == 0 ? cp : -cp;
            }
        });

        int start = resultsPerPage * pageIndex, end = resultsPerPage * (pageIndex + 1);
        List<String> resultList = new ArrayList<>();
        while (start < end && start < sortedUrls.size()) {
            resultList.add(sortedUrls.get(start));
            start++;
        }
        return resultList;
    }
}
