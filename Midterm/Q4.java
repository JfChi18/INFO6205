class Solution{
    // Time Complexity: O(n)  Space: O(1)

    public static void getIndex(int nums[], int x)
   {
        int n = nums.length;
        int first = 1, last = 1;
        for (int i = 0; i < n; i++) {
            if (x != nums[i])
                continue;
            if (first == 1)
                first = i;
            last = i;
        }
        if (first != 1) {
            System.out.println(first);
        }
        else
            System.out.println("Not Found");
    }

    public static void main(String[] args)
    {
        int arr[] = {2,4,4,4,6,7,7,7,8,9,9,9 };
        int x = 7;
        getIndex(arr, x);
    }
}
