class Solution {
    public int countCharacters(String[] words, String chars) {
        int totalLength = 0;

        int[] charCounts = new int[26];
        for (char c : chars.toCharArray()) {
            charCounts[c - 'a']++;
        }
        
        for (String word : words) {
            int[] wordCounts = new int[26];
            boolean canForm = true;
            
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                wordCounts[index]++;
            
                if (wordCounts[index] > charCounts[index]) {
                    canForm = false;
                    break;
                }
            }
            
            if (canForm) {
                totalLength += word.length();
            }
        }
        
        return totalLength;
    }
}