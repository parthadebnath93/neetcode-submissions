class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int n= nums.length;
        int high=n-1;
        while (low<high){
            int mid=(low+high)>>1;
            if (mid>low && mid<high && nums[mid-1]>nums[mid] && nums[mid+1]>nums[mid]){
                return nums[mid];
            }
            if (nums[low]>nums[high]){
                if (nums[low]>nums[mid]){
                    high=mid-1;
                }else {
                    low=mid+1;
                }
            }else{
                if (nums[high]>nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
        }
        return nums[low];
    }
}
