// 49-> groping Anagrams

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode49 {
    class Solution {
    public  List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        // now we have to sort Each individual String

        String[] copy = new String[strs.length];

        for (int i = 0; i < strs.length; i++) {
            copy[i] = strs[i];
        }

        for (int i = 0; i < strs.length; i++) {
            strs[i] = solve(strs[i]);
        }
        for (int i = 0; i < strs.length; i++) {

            if (map.containsKey(strs[i])) {
                List<String> l = map.get(strs[i]);
                l.add(copy[i]);
                map.put(strs[i], l);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(copy[i]);
                map.put(strs[i], temp);
            }
        }
        List<List<String>> anslist = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (map.containsKey(strs[i])) {
                anslist.add(map.get(strs[i]));
                map.remove(strs[i]);
            }
        }
        return anslist;
    }

    public String solve(String input) {
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

}
}
