class Solution {
    void helper(int index,String digits,List<String>ans,Map<Character,String>values,String temp){
        if(temp.length()==digits.length()){
              ans.add(temp);
              return;
        }

        for(char c:values.get(digits.charAt(index)).toCharArray()){

            helper(index+1,digits,ans,values,temp+c);
        }
    }
    public List<String> letterCombinations(String digits) {
        Map<Character,String> values=getMap();
        List<String> ans=new ArrayList<>();
        if(digits.length()==0) return ans;
        helper(0,digits,ans,values,"");
        return ans;
     
    }

    private Map<Character,String> getMap(){
        Map<Character,String> values=new HashMap<>();
        values.put('2',"abc");
        values.put('3',"def");
        values.put('4',"ghi");
        values.put('5',"jkl");
        values.put('6',"mno");
        values.put('7',"pqrs");
        values.put('8',"tuv");
        values.put('9',"wxyz");
        return values;
    }

}
