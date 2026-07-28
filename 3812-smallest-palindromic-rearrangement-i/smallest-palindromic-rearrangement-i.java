class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int half = n/2;
        char[] chars = s.substring(0, half).toCharArray();
        Arrays.sort(chars);
        
        String left = new String(chars);
        String right = new StringBuilder(left).reverse().toString();
        
        if (n % 2 == 1) {
            return left + s.charAt(half) + right;
        } else {
            return left + right;
        }
    }
}