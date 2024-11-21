class Solution {

    class Pair{
        int distance;
        int col;
        int row;

        Pair(int distance, int row,int col){
            this.distance=distance;
            this.col=col;
            this.row=row;

        }
    }
    public int minimumEffortPath(int[][] heights) {

        int n=heights.length;
        int m=heights[0].length;

        PriorityQueue<Pair> q=new PriorityQueue<Pair>((x,y)->x.distance-y.distance);

        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)(1e9);
            }
        }

        dist[0][0]=0;
        q.add(new Pair(0,0,0));

        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};

        while(!q.isEmpty()){
            int distance=q.peek().distance;
            int row=q.peek().row;
            int col=q.peek().col;
            q.remove();
          if(row==n-1 && col==m-1){return  distance;}

            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m ){
                    int newDistance= Math.max(Math.abs(heights[row][col]-heights[nrow][ncol]),distance);
                    if(newDistance<dist[nrow][ncol]){
                        dist[nrow][ncol]=newDistance;         
                        q.add( new Pair( dist[nrow][ncol],nrow,ncol));
                    }
                }
            }
        }

        return 0;

        
    }
}
