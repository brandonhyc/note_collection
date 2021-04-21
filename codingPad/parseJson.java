package codingPad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class parseJson {

    public static void main(String[] args) {
        String tempJson = "{\"incomePhone\":\"213121122\",\"clientId\":\"1001\",\"clientAccountManager\":\"Gestor de Conta 1\",\"clientRetailBranch\":\"100\",\"phoneAccountManager\":\"7800100\"}";
        String mapType = "{\"users\":{\"username\":\"Alex\",\"userId\":\"alx\"},\"income\":123}";
        String onlyOneStringPair = "{\"name\":\"Alex\"}";
        String onlyOneStringNumPair = "{\"name\":123}";
        String twoStringNumPair = "{\"name\":123,\"name2\":\"Alex\"}";

        System.out.println(new Solution().parseJson(mapType));
    }

    private static class Solution {
        public Map<String, ?> parseJson(String json) {
            char[] array = json.toCharArray();

            return parseHelper(array, new int[] { 0 });
        }

        // 1. number, 2. string, (3. map 4. list
        private Map<String, ?> parseHelper(char[] array, int[] cursor) { //
            if (cursor[0] > array.length - 1) return null;

            Map map = new HashMap<>();
            // skip {
            cursor[0]++;

            while (cursor[0] < array.length && array[cursor[0]] != '}') {
                // parse each element in current level
                if (array[cursor[0]] == ',') cursor[0]++; // skip,

                // skip left "
                cursor[0]++;
                // parse key
                StringBuilder key = new StringBuilder();
                while (array[cursor[0]] != '\"') {
                    key.append(array[cursor[0]]);
                    cursor[0]++;
                }
                // skip right " and :
                cursor[0] += 2;

                char ch = array[cursor[0]];
                Object value = null;
                // parse value: Number/String "/List [/Map {
                if (Character.isDigit(ch)) { // is number
                    int num = 0;
                    while (Character.isDigit(array[cursor[0]])) {
                        num = 10;
                        num += array[cursor[0]] - '0';
                        cursor[0]++;
                    }
                    value = num;
                } else if ('\"' == ch) { // is String
                    StringBuilder temp = new StringBuilder();
                    cursor[0]++; // skip left "
                    while (array[cursor[0]] != '\"') {
                        temp.append(array[cursor[0]]);
                        cursor[0]++;
                    }
                    value = temp.toString();
                    cursor[0]++; // skip "

                } else if ('{' == ch) { // is map
                    value = parseHelper(array, cursor);
                } else if ('[' == ch) { // is List
                    cursor[0]++;
                    List<Map<String, ?>> list = new ArrayList<>();
                    while (array[cursor[0]] != ']') {
                        list.add(parseHelper(array, cursor));
                    }
                    value = list;
                    cursor[0]++; // skip ,
                }
                map.put(key.toString(), value);
            }
            // skip }
            cursor[0]++;

            return map;
        }
    }
}
