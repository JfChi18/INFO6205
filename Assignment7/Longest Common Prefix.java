class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length ==0) {
            return "";
        }
        
        Arrays.sort(strs);
        int prefixIndex = -1;
        int firstLen = strs[0].length();
        int lastLen = strs[strs.length - 1].length();
        
        String first = strs[0];
        String last = strs[strs.length - 1];
        
        int smallerLen = Math.min(firstLen, lastLen);
        for (int i = 0; i < smallerLen; i++) {
            if (first.charAt(i) == last.charAt(i)) {
                prefixIndex++;
            } else {
                break;
            }
        }
        
        if (prefixIndex == -1) {
            return "";
        } else {
            return first.substring(0, prefixIndex + 1);
        }
    }
}
