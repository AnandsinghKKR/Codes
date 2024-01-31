import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class Leetcode1298 {
    class Solution {
        public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
            HashSet<Integer> lonelyboxes = new HashSet<>();
            HashSet<Integer> lonelykeys = new HashSet<>();
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < initialBoxes.length; i++) {
                if (status[initialBoxes[i]] == 0)
                    lonelyboxes.add(initialBoxes[i]);
                else {
                    q.add(initialBoxes[i]);

                }
            }
            int ans = 0;
            while (q.size() > 0) {
                int box = q.remove();

                for (int k : keys[box]) {
                    if (lonelyboxes.remove(k)) {
                        q.add(k);

                    } else {
                        lonelykeys.add(k);
                    }
                }

                ans += candies[box];
                for (int boxes : containedBoxes[box]) {
                    if (lonelykeys.remove(boxes) || status[boxes] == 1) {
                        q.add(boxes);
                    } else {
                        lonelyboxes.add(boxes);
                    }

                }

            }

            return ans;

        }
    }
}
