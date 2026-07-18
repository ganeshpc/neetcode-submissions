class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for (String str: strs) {
            int n = str.length();
            String count = String.valueOf(n);
            int charCount = count.length(); 
            if (charCount < 3) sb.append('0'); 
            if (charCount < 2) sb.append('0'); 
            
            sb.append(count);
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int n = str.length();
        int ctr = 0;
        while (ctr < n) {
            String count = str.substring(ctr, ctr+3);
            ctr+=3;
            int l = Integer.valueOf(count);  

            String sub = str.substring(ctr, ctr+l);

            ans.add(sub);
            ctr += l;
        }
        return ans;

    }
}
