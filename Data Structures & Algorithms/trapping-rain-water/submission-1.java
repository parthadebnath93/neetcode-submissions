class Solution {
    public int trap(int[] height) {
        int water = 0;
        int n= height.length;
        if (n <= 2) {
            return 0;
        }
        int[] left=new int[n-1];
        left[0]=Integer.MIN_VALUE;
        for (int i=1;i<n-1;i++){
            left[i]=Integer.max(left[i-1],height[i-1]);
        }
        int right=Integer.MIN_VALUE;
        for (int i=n-2;i>=1;i--){
            right=Integer.max(right,height[i+1]);
            if (Integer.min(left[i],right )>height[i]){
                water+=Integer.min(left[i],right)-height[i];
            }
        }
        return water;
    }
}
