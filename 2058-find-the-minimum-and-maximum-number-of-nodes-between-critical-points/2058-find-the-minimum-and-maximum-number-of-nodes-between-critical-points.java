import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        int idx = 1;
        List<Integer> criticalPoints = new ArrayList<>();
        while (curr.next != null) {
            boolean isLocalMaxima = curr.val > prev.val && curr.val > curr.next.val;
            boolean isLocalMinima = curr.val < prev.val && curr.val < curr.next.val;

            if (isLocalMaxima || isLocalMinima) {
                criticalPoints.add(idx);
            }

            prev = curr;
            curr = curr.next;
            idx++;
        }
        if (criticalPoints.size() < 2) {
            return new int[]{-1, -1};
        }
        int maxDist = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);
        int minDist = Integer.MAX_VALUE;

        for (int i = 1; i < criticalPoints.size(); i++) {
            minDist = Math.min(minDist, criticalPoints.get(i) - criticalPoints.get(i - 1));
        }

        return new int[]{minDist, maxDist};
    }
}