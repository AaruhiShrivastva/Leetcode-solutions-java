class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int l1=arr1.length;
        int l2=arr2.length;
        int count=0;
        for(int i=0; i<l1; i++){
            boolean check=true;
            for(int j=0; j<l2; j++){
                if(Math.abs(arr1[i]-arr2[j])<=d){
                    check=false;
                    break;
                }
            }
            if(check==true)count++;
        }
        return count;
    }
}