import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int maximumLengthSubstring(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < list.size(); right++) {
            char curr = list.get(right);

            while (Collections.frequency(list.subList(left, right + 1), curr) > 2) {
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}