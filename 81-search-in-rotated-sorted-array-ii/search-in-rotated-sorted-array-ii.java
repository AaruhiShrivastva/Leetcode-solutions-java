class Solution {
    public boolean search(int[] nums, int target) {
        int high = nums.length-1;
        int low = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target) return true;
            if(nums[low]==nums[mid]&&nums[high]==nums[mid]){
                high--;
                low++;
            }
            else{
                if(nums[low]<=nums[mid]){
                    if(nums[low]<=target&& target<nums[mid]) high = mid-1;
                    else low = mid+1;
                }
                else{
                    if(nums[mid]<target && target<=nums[high]) low = mid+1;
                    else high = mid-1;
                }
            }
        }
        return false;
    }
}