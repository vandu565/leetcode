class Solution {
    public int jump(int[] nums) {

        int l=0;
        int r=0;
        int maxIndex=0;
        int count=0;


        while(r<nums.length-1){
            maxIndex=0;
            
            for(int j=l;j<=r;j++){
                maxIndex=Math.max(maxIndex,nums[j]+j);
            }

            l=r+1;
            r=maxIndex;
            count++;


        }

        return count ;
        
    }
}
