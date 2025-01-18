class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int maxlen=0;

        Map<Character,Integer> mpp=new HashMap<>();

        while(r<s.length()){
            if(mpp.containsKey(s.charAt(r))== true){
                if(mpp.get(s.charAt(r))>=l){
                    l=mpp.get(s.charAt(r))+1;
                }

            }

            maxlen=Math.max(maxlen,r-l+1);

            mpp.put(s.charAt(r),r);
            r=r+1;
        }
        return maxlen;
        
    }
}
