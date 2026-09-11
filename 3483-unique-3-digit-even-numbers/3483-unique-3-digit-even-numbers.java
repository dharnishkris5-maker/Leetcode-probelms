import java.util.HashSet;
import java.util.Set;

class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> uniqueEvens = new HashSet<>();
        int n = digits.length;

        // Try every unique combination of three distinct indices (i, j, k)
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue; // No leading zero allowed for the hundreds place

            for (int j = 0; j < n; j++) {
                if (i == j) continue; // Must be a different array element

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue; // Must be a different array element

                    // Check if the last digit is even
                    if (digits[k] % 2 == 0) {
                        int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                        uniqueEvens.add(number);
                    }
                }
            }
        }

        return uniqueEvens.size();
    }
}