class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        StringBuffer result = new StringBuffer();
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                continue;
            };
            
            int end = i;
            while(i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            result.append(s.substring(i + 1, end + 1)).append(" ");
        }
        return result.toString().trim();
    }
}

