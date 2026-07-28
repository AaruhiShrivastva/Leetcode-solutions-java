class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                seenDigit = true;
            } else if (ch == '+' || ch == '-') {
                // Sign is only allowed at index 0 or immediately after 'e' / 'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (ch == '.') {
                // Dot is allowed only once and cannot appear after an exponent
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else if (ch == 'e' || ch == 'E') {
                // Exponent is allowed only once and must follow at least one digit
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; // Must see at least one digit after 'e'/'E'
            } else {
                // Invalid character
                return false;
            }
        }

        return seenDigit;
    }
}