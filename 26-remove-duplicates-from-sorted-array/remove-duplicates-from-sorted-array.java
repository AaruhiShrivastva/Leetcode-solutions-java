class Solution {
    public int removeDuplicates(int[] arr) {
        int slow = 0;
        if(arr.length==0){
            return 0;
        }
        for(int fast=1;fast<arr.length;fast++){
            if(arr[slow]!=arr[fast]){
                slow++;
                arr[slow]=arr[fast];           
            }   
        }
        return slow+1;
       
    }
}