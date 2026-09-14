class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[1] : nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid=(left+right)>>1;
            if (mid>left && mid<right && nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]){
                return nums[mid];
            } else if (nums[left]>nums[right]) {
                if (nums[mid]<nums[nums[right]]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if (nums[mid]<nums[right]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return nums[left];
    }
}
