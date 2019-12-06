import java.util.Scanner;

/**
 * Created by wangxue on 2019/10/17.
 */
public class 漆狗屋 {
//    同分书页
//    https://www.geeksforgeeks.org/painters-partition-problem/、
//    dp[k][n]

//    数组求和 闭区间
    static int sum(int arr[], int from, int to)
    {
        int total = 0;
        for (int i = from; i <= to; i++)
            total += arr[i];
        return total;
    }
//  主程序
    static int findMax(int arr[], int n, int k)
    {
        int dp[][] = new int[k+1][n+1];

        // base cases
        // k=1
        for (int i = 1; i <= n; i++)
            dp[1][i] = sum(arr, 0, i - 1);

        // n=1
        for (int i = 1; i <= k; i++)
            dp[i][1] = arr[0];

        // 2 to k partitions
        for (int i = 2; i <= k; i++) {
            // 2 to n boards
            for (int j = 2; j <= n; j++) {

                // track minimum
                int best = Integer.MAX_VALUE;

                // i-1 th separator before position arr[p=1..j]在p前放置分隔符
                for (int p = 1; p <= j; p++)
                    best = Math.min(best, Math.max(dp[i - 1][p],
                            sum(arr, p, j - 1)));

                dp[i][j] = best;
            }
        }

        // required
        return dp[k][n];
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i = 0 ; i < t ; i ++){
            int k = s.nextInt();
            int n  = s.nextInt();

            int[] array = new int[n];
            for(int j = 0 ; j < n ; j ++){
                array[j] = s.nextInt();
            }

            int best = findMax(array, n, k);
            System.out.println(best);
        }
    }
}
