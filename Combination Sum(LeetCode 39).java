class Solution {
     void helper(int index,int candidates[], int target, List<List<Integer>>ans,      List<Integer>temp){

        if(index == candidates.length){
            if(target==0){
           
             
               ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(candidates[index]<=target){
            temp.add(candidates[index]);
            helper(index,candidates,target-candidates[index],ans,temp);
            temp.remove(temp.size()-1);
        }

        helper(index+1,candidates,target,ans,temp);
     }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> temp= new ArrayList<>();

       helper(0,candidates,target,ans,new ArrayList<>());
       return ans;
        
    }
}
