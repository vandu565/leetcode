class Solution {

    boolean helper(int index,String s,Set<String> dict,int[]dp){
         
        
         if(index==s.length()){
            return true;
         }

          if (dp[index] != -1)
           {return dp[index] == 0 ? false : true;}

       for(int i=index; i<s.length();i++){
             String temp= s.substring(index,i+1);
            if(dict.contains(temp)){
                if (helper(i+1,s,dict,dp)){
                    dp[index] = 1;
                    return true;
                }
            }
       }

       dp[index] =0;
        return false;



    }
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> dict= new HashSet<>(wordDict);
        int dp[]= new int[s.length()];
        Arrays.fill(dp,-1);
        
        return helper(0,s,dict,dp);
        
    }
}
