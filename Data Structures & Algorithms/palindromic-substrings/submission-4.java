class Solution {
    int n;
    String s;
    public int countSubstrings(String s) {
        n = s.length();
        this.s= s;

        int count = 0;
        for (int i=0; i<n; i++) {
            count += midCount(i);
            count += aroundCount(i);
        }
        return count;
    }

    int midCount(int idx) {
        int count = 1;

        int l = idx-1; 
        int r = idx+1;

        while (l >= 0 && r <n) {
            if (s.charAt(l) == s.charAt(r)) 
                count++;
            else 
                break;
            l--;
            r++;
        }
        return count;
    }
    int aroundCount(int idx) {
        int l = idx;
        int r = idx+1;
        int count = 0;
        while (l >= 0 && r <n) {
            if (s.charAt(l) == s.charAt(r)) 
                count++;
            else 
                break;
            l--;
            r++;
        }
        return count;
    }
}
