import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/27.
 */
//https://practice.geeksforgeeks.org/editorial.php?pid=2819
//dp[(convert(X) | state] = max( dp[convert(X) | state] , dp[state] + X )
//    todo 还没看
public class 无重复字符子集问题 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            System.out.println(solve(a));
        }
    }

    private static int solve(int[] a) {
        int[] dp = new int[(1<<10)];
        for (int x : a) {
            for (int bits = dp.length-1; bits >= 0; bits--) {
                int mask = getMask(x);
                if ((bits & mask) == mask) {
                    dp[bits] = Math.max(dp[bits], dp[bits^mask] + x);
                }
            }
        }

        int res = 0;
        for (int s : dp) {
            res = Math.max(res, s);
        }
        return res;
    }

    private static int getMask(int x) {
        int res = 0;
        while (x > 0) {
            int d = x % 10;
            res |= (1 << d);
            x /= 10;
        }
        return res;
    }
}