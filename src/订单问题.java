import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/21.
 */
//@todo
public class 订单问题 {
//    dp *
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0 ; i < t ; i++){
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for(int j = 0 ; j < n ; j ++){
                a[j] = scanner.nextInt();
            }

            for(int j = 0 ; j < n ; j++){
                b[j] = scanner.nextInt();
            }

            func(n,x, y, a, b);
        }
    }

    private static void func(int n, int x, int y, int a[], int b[]){
        int[][] max = new int[x+1][y+1];


        for(int i=1;i<=x;i++) {
            max[i][0]= a[i-1] + max[i-1][0];
        }
        for(int i=1;i<=y;i++) {
            max[0][i] = b[i - 1] + max[0][i - 1];
        }

        for(int i=1;i<=x;i++) {
            for(int j=1;j<=y;j++) {
                if(i+j <= n) {
                    int op1= a[i+j-1] + max[i-1][j];
                    int op2= b[i+j-1] + max[i][j-1];

                    max[i][j] = Math.max( op1 , op2 );
                } else {
                    max[i][j] = Math.max( max[i-1][j] , max[i][j-1] );
                }
            }
        }

        System.out.println(max[x][y]);

    }
}
