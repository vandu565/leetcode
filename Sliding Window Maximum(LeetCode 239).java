class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> st=new ArrayDeque<>();
        int n=nums.length;
        int ans[]=new int[n-k+1];
        int t=0;
        

        for (int i=0;i<n;i++){

            while(!st.isEmpty() && st.peekFirst()<=i-k){
                st.removeFirst();
            }

            while(!st.isEmpty() && nums[st.peekLast()]<= nums[i]){
                st.removeLast();
            }

            st.addLast(i);

            if(i>=k-1){
                ans[t]=nums[st.peekFirst()];
                t++;
                }

            

        }

        return ans;

        
    }
}
