class Solution {

    void solve(int open,int closed,String current,int n,List<String> ans){
        if(current.length()==2*n){
           ans.add(current);
           return;
        }

        if(open<n){
            solve(open+1,closed,current+'(',n,ans);
        }

        if(closed<open){
            solve(open,closed+1,current+')',n,ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();

        solve(0,0,"",n,ans);
        return ans;
        
    }
}
