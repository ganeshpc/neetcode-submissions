class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str: strs) {
            int len = str.length();

            if (len < 10) {
                encoded.append("00");
            } else if (len < 100) {
                encoded.append("0");
            }
            encoded.append(len);
            
            encoded.append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int len = str.length();

        int ctr = 0;
        while (ctr < len) {
            int strLen = Integer.valueOf(str.substring(ctr, ctr+3));
            ctr += 3;
            decoded.add(str.substring(ctr, ctr+strLen));
            ctr += strLen;
        }
        return decoded;
    }
}
