import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/28.
 */
public class 管道网络 {
//    https://www.geeksforgeeks.org/water-connection-problem/
//    输出线路数和起点
//    dfs
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int n = scanner.nextInt();
            int p = scanner.nextInt();
            int[] connectedToHouse = new int[n+1];
            int[] connectedFrHouse = new int[n+1];
            int[] connectedPipeDia = new int[n+1];
            for(int i=1;i<=p;i++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int v = scanner.nextInt();
                connectedToHouse[x] = y;
                connectedFrHouse[y] = x;
                connectedPipeDia[x] = v;
            }

            func(n, connectedToHouse, connectedFrHouse, connectedPipeDia);
        }
    }

    private static void func(int n, int[] connectedToHouse, int[] connectedFrHouse, int[] connectedPipeDia){
        int num=0;
        for(int i=1;i<=n;i++){
            if(connectedFrHouse[i] == 0 && connectedToHouse[i] != 0) num++;
        }
        System.out.println(num);

        for(int i=1;i<=n;i++){
            if(connectedFrHouse[i] != 0 || connectedToHouse[i] == 0) continue;
            int j = i;
            int val = Integer.MAX_VALUE;
            while(connectedToHouse[j]!=0){
                val = Math.min(val, connectedPipeDia[j]);
                j = connectedToHouse[j];
            }
            System.out.println(i+" "+j+" "+val);
        }

    }

}
