class Solution {
    public static void main(String[] agrs){
        List<String> res = new ArrayList<String>();
        res = generateParenthesis(3);
        System.out.println(res);
    }  
  
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        helper(n, n, new String(), res);   //new String() 记得加上括号
        return res;
    }
    
    public static void helper (int L, int R, String item, ArrayList<String> res){
        if(R<L) return;   //先看 return 条件
        if(L==0 && R==0) res.add(item);   //再 add to res 条件
        if(L > 0) helper(L-1, R, item+"(", res);
        if(R > 0) helper(L, R-1, item+")", res);
    }
}
