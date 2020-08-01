class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) return true;
        int countUpper = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) countUpper++;
        }
        return countUpper == word.length() ||
            countUpper == 0 ||
            countUpper == 1 && Character.isUpperCase(word.charAt(0));
    }
    

}