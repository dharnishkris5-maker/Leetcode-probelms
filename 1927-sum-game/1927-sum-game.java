class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0, rightSum = 0;
        int leftQ = 0, rightQ = 0;

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }

        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }

        // If total '?' count is odd, Alice can always force a win
        if ((leftQ + rightQ) % 2 != 0) {
            return true;
        }

        // For Bob to win, the difference in sums must be balanced 
        // by half the net difference of '?' (each pair of '?' accounts for 9 points)
        return (leftSum - rightSum) != (rightQ - leftQ) * 9 / 2;
    }
}