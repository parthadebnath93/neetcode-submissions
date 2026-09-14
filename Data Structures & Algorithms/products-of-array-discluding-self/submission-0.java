class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int index=0;
         getProduct(nums,index,n,1);
         return nums;
    }

    private static int getProduct(int[] nums, int index, int n, int leftProduct){
        if (index==n-1){
            int temp=nums[index];
            nums[index]=leftProduct;
            return temp;
        }else{
            int temp=nums[index];
            int rightProduct=getProduct(nums,index+1,n,leftProduct*temp);
            nums[index]=leftProduct*rightProduct;
            return rightProduct*temp;
        }
    }
}  
