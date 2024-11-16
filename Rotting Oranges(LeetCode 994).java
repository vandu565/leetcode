class Solution {

    class Pair{

        int row;
        int col;
        int time;

        Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;
        int delRow[]={-1,0,1,0};
        int delCol[]={0,-1,0,1};

        int[][]visited=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        int fresh=0;
        

        //adding the initial value (all rotten ordanges)
        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
            if(grid[i][j]==2){
                q.add(new Pair(i,j,0));
                visited[i][j]=1;
            }else{
                 visited[i][j]=0;
            }

            if(grid[i][j]==1){
                fresh++;
            }
           }
        }

       // starting the qeue loop
        int maxTime=0;
        int count=0;
        while(!q.isEmpty()){

            //take element out
           int row=q.peek().row;
           int col=q.peek().col;
           int time=q.peek().time;
           q.remove();
           maxTime=Math.max(maxTime,time);

           //adding adjacent element
           for(int i=0;i<4;i++){
            int newRow=row+delRow[i];
            int newCol=col+delCol[i];

            if(newRow>=0 && newRow<n&& newCol>=0 && newCol<m && visited[newRow][newCol]==0 && grid[newRow][newCol]==1){
                visited[newRow][newCol]=1;
                count++;
                q.add(new Pair(newRow,newCol,time+1));
                
            }

           }
         
        }

         if(count!=fresh) return -1;
         return maxTime;
        
    }
}
