class Solution {

    void dfs(int[][] image, int sr, int sc,int[][]ans, int color,int[]delRow,int[]delCol,int oldColor){

        ans[sr][sc]=color;
        int n=image.length;
        int m=image[0].length;

        for(int i=0;i<4;i++){
          {
                int row=sr+delRow[i];
                int col=sc+delCol[i];

                if(row>=0 && row<n && col>=0 && col<m && image[row][col]==oldColor && ans[row][col]!=color ){
                    dfs(image,row,col,ans,color,delRow,delCol,oldColor);
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldColor=image[sr][sc];
        int ans[][]=image;

        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};

        dfs(image,sr,sc,ans,color,delRow,delCol,oldColor);
        return ans;
        
    }
}
