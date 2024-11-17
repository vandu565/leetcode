class Solution {

    class Pair {
        String word;
        int level;

        Pair(String word,int level ){
            this.word=word;
            this.level=level;
        }
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> q=new LinkedList<>();
        Set<String> st= new HashSet<>(wordList);

        q.add(new Pair(beginWord,1));
        st.remove(beginWord);


        while(!q.isEmpty()){
            String word=q.peek().word;
            int level=q.peek().level;
            q.remove();

            if(word.equals(endWord)){
                return level;
            }

           

            for(int i=0;i<word.length();i++){
                char charword[]=word.toCharArray();

                for(char j='a';j<='z';j++){
    
                    charword[i]=j;
                    String temp=new String(charword);
                    
                    if(st.contains(temp)){
                        st.remove(temp);
                        q.add(new Pair(temp,level+1));
                    }
                    
                }
            }
        }

        return 0;

       
        
    }
}
