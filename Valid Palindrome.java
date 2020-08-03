class Solution {
    public boolean checkIfPalindrome(String s, int start, int end) {
        if(start < end) {
            if(s.charAt(start) == s.charAt(end))
                return checkIfPalindrome(s, ++start, --end);
            else
                return false;
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z\\d]+", "").toLowerCase();
        return checkIfPalindrome(s, 0, s.length() - 1);
    }
}