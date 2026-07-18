class Solution {
    public boolean isPalindrome(String s) {
        char[] str = s.toCharArray();

        int n = str.length;

        int left = 0;
        int right = n-1;

        while (left < right) {
            if (!Character.isLetter(str[left]) && !Character.isDigit(str[left])) {
                left++;
                continue;
            }
            if ( !Character.isLetter(str[right]) && !Character.isDigit(str[left])) {
                right--;
                continue;
            }

            if (Character.toLowerCase(str[left]) != Character.toLowerCase(str[right])) return false;
            right--;
            left++;
        }    

        return true;
    }
}
