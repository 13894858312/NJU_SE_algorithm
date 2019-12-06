import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/27.
 */
public class 是否能通过考试 {
//    https://blog.csdn.net/qq_33935895/article/details/103213133
//    todo 变种&化简 https://www.jianshu.com/p/0b9018bbacd7

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int n = scanner.nextInt();
            int h = scanner.nextInt();
            int p = scanner.nextInt();

            int hs[] = new int[n];
            int ps[] = new int[n];
            for(int i = 0 ; i< n ; i++){
                hs[i] = scanner.nextInt();
                ps[i] = scanner.nextInt();
            }

            func(n, h, p, hs, ps);
        }
    }
//    若数组中最后一行一列的数大于p,证明可以拿到p分,此时
//    回溯找,即更新完dp数组后再找大于p分的最小时间.在遍历过程中记录,若大于p分时,更新当前的时间值(也就是j)

//    01背包问题-基础公式
//    前 i 件物品恰放入一个容量为v 的背包可以获得的最大价值
//    F[i][v] = max(F[i-1][v], F[i-1][v-C[i]] + W[i]}
    private static void func(int n, int h, int p, int[] hs, int[] ps){
        int[][] f = new int[n][h];
        for(int i = 0 ; i < n ; i ++){
            f[i][0] = 0;
        }
        for(int i = 0 ; i < h ; i ++){
            f[0][i] = hs[0] <= i ? ps[0] : 0;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i < n ; i++){
            for(int v = 0 ; v < h ; v++){
                if(hs[i] <= v){
                    f[i][v] = Math.max(f[i-1][v] , f[i-1][v-hs[i]] + ps[i]);
                }else {
                    f[i][v] = f[i-1][v];
                }

                if(f[i][v] >= p){
                    min = Math.min(v, min);
                }
            }
        }

        if(f[n-1][h-1] >= p){
            System.out.println("YES"+" "+min);
        }else {
            System.out.println("NO");
        }
    }

}
