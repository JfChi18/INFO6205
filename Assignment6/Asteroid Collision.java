class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> s = new Stack();
        List<Integer> res = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            
            if(nums[i] < 0){
                
                if(s.empty()){
                    res.add(nums[i]);
                    continue;
                }
                
                boolean flag = true;
                
                while(!s.empty()){
                    if(s.peek() > Math.abs(nums[i])){
                        flag = false;
                        break;
                    }
                    else if(s.peek() == Math.abs(nums[i])){
                        s.pop();
                        flag = false;
                        break;
                    }
                    else{
                        s.pop();
                    }
                }
                
                if(s.empty() && flag)
                    res.add(nums[i]);
            }
            else
                s.push(nums[i]);
        }
        
        res.addAll(new ArrayList<>(s));
        int[] r = new int[res.size()];
        for(int a =0;a< res.size();a++)
            r[a]=res.get(a);
        return r;
    }
}
