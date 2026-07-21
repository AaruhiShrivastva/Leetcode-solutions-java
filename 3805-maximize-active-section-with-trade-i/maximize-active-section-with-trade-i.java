import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int originalOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                originalOnes++;
            }
        }

        // Augment string with '1' at both ends as described in the problem
        String t = "1" + s + "1";
        List<Integer> lengths = new ArrayList<>();
        List<Character> types = new ArrayList<>();

        // Group consecutive identical characters
        int n = t.length();
        int i = 0;
        while (i < n) {
            char ch = t.charAt(i);
            int j = i;
            while (j < n && t.charAt(j) == ch) {
                j++;
            }
            types.add(ch);
            lengths.add(j - i);
            i = j;
        }

        int maxGain = 0;

        // Look for '0' - '1' - '0' patterns in our grouped segments
        for (int k = 1; k < types.size() - 1; k++) {
            if (types.get(k) == '1' && types.get(k - 1) == '0' && types.get(k + 1) == '0') {
                int zeroBlockLeft = lengths.get(k - 1);
                int zeroBlockRight = lengths.get(k + 1);

                // Gain is simply the sum of the surrounding zero blocks
                int gain = zeroBlockLeft + zeroBlockRight;
                maxGain = Math.max(maxGain, gain);
            }
        }

        return originalOnes + maxGain;
    }
}