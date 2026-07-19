class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        // Record the last occurrence index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        StringBuilder stack = new StringBuilder();
        boolean[] seen = new boolean[26];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If we've already included this character in our result, skip it
            if (seen[c - 'a']) {
                continue;
            }
            
            // Maintain the monotonic increasing order if possible
            while (stack.length() > 0 && 
                   stack.charAt(stack.length() - 1) > c && 
                   lastIndex[stack.charAt(stack.length() - 1) - 'a'] > i) {
                
                // Pop the character from stack and mark it as not seen
                char removed = stack.charAt(stack.length() - 1);
                seen[removed - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }
            
            // Add the current character
            stack.append(c);
            seen[c - 'a'] = true;
        }
        
        return stack.toString();
    }
}