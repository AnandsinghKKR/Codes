// medium daily streaK -> Sort Characters By Frequency
// Important learning of HashMap


import java.util.*;
public class Leetcode451 {
class Solution {
     class pair {
        int cnt;
        String s;

        pair(int cnt, String s) {
            this.cnt = cnt;
            this.s = s;
        }
    }

    public   String frequencySort(String s) {
        HashMap<Character, pair> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mp.containsKey(c)) {
                pair p = mp.get(c);
                int count = p.cnt + 1;
                String s1 = p.s + c;
                p.cnt = count;
                p.s = s1;
                mp.put(c, p);
            } else {
                pair p = new pair(1, String.valueOf(c));
                mp.put(c, p);
            }
        }

        // Convert HashMap entries to a List
        List<Map.Entry<Character, pair>> list = new ArrayList<>(mp.entrySet());

        // Sorting the list based on the cnt field of pair objects in decreasing order
        list.sort((entry1, entry2) -> Integer.compare(entry2.getValue().cnt, entry1.getValue().cnt));

        // Constructing the result string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, pair> entry : list) {
            result.append(entry.getValue().s);
        }

        return result.toString();
    }

}

}
