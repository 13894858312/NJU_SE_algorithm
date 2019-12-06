import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/28.
 */
//todo
public class 格子里的整数 {
//    https://www.geeksforgeeks.org/minimum-cost-path-left-right-bottom-moves-allowed/
//    https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/

    static int MAX=1000000;
    static int row[]={0,0,-1,1};
    static int col[]={1,-1,0,0};

    static class Cell{

        int x;
        int y;

        Cell(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int min(int a[][],int n,int dp[][]){

        Queue<Cell> q=new LinkedList<>();
        q.add(new Cell(0,0));
        dp[0][0]=a[0][0];

        while(!q.isEmpty()){

            Cell c=q.poll();

            for(int i=0;i<4;i++){

                int x=row[i]+c.x;
                int y=col[i]+c.y;

                if(x>=0&& y>=0 && x<n && y<n){

                    int dis=dp[c.x][c.y]+a[x][y];

                    if(dp[x][y]>dis){
                        dp[x][y]=dis;
                        q.add(new Cell(x,y));
                    }

                }

            }

        }
        return dp[n-1][n-1];

    }

    public static void main (String[] args) throws IOException {

        Scanner s=new Scanner(System.in);
        int t=s.nextInt();

        while (t-- > 0) {

            int n=s.nextInt();
            int a[][]=new int[n][n];
            int dp[][]=new int[n][n];
            for(int i=0;i<n;i++){

                for(int j=0;j<n;j++){
                    a[i][j]=s.nextInt();
                    dp[i][j]=MAX;
                }
            }

            System.out.println(min(a,n,dp));

        }


    }
}
