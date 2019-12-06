import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/28.
 */
public class 硬币最小数量 {
//    todo
//    https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t -- > 0){
            int n = scanner.nextInt();
            int amount = scanner.nextInt();
            int[] values = new int[n];
            for(int i = 0  ; i < n ; i++){
                values[i] = scanner.nextInt();
            }

            func(values, n, amount);
        }
    }

    private static void func(int coins[], int m, int V)
    {
        // table[i] will be storing
        // the minimum number of coins
        // required for i value. So
        // table[V] will have result
        int table[] = new int[V + 1];

        // Base case (If given value V is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i = 1; i <= V; i++)
            table[i] = Integer.MAX_VALUE;

        // Compute minimum coins required for all
        // values from 1 to V
        for (int i = 1; i <= V; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++)
                if (coins[j] <= i)
                {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;

                }

        }

        if (table[V] == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(table[V]);
        }
    }
}
