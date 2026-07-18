class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str: strs) {
            int len = str.length();

            encoded.append(len);
            encoded.append("#");
            
            encoded.append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int len = str.length();
        // System.out.println("dec:  " + str);
        int ctr = 0;
        while (ctr < len) {
            int strLen = 0;
            while (str.charAt(ctr) != '#') {
                strLen = (strLen*10) + (str.charAt(ctr)-'0');
                ctr++;
            }
            ctr++;
            decoded.add(str.substring(ctr, ctr+strLen));
            ctr += strLen;
        }
        return decoded;
    }
}
