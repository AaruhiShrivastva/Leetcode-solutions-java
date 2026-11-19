class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int l=nums.length;
        int max=nums[l-1];
        int op1= Math.abs(nums[l-1]-nums[2]);
        int op2=Math.abs(nums[l-3]-nums[0]);
        int op3=nums[l-2]-nums[1];
        return Math.min(op1,Math.min(op2,op3));
    }
}