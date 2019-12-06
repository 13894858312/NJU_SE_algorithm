import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/26.
 */
//自己写的，不准
public class 子矩阵问题 {
//    https://blog.csdn.net/jiyanfeng1/article/details/8068676 子矩阵
// 直方图最大矩形 https://blog.csdn.net/u012534831/article/details/74356851
//    入栈直到
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        for(int i = 0 ; i < a ; i ++){
            int n;//行
            int m;//列
            n = s.nextInt();
            m = s.nextInt();
            int[][] mtx = new int[n][m];
            for(int j = 0 ; j < n ; j ++){
                for(int k = 0 ; k < m ; k ++){
                    mtx[j][k] = s.nextInt();
                }
            }
            func(mtx, n , m);
        }
    }

    private static void func(int[][] mtx, int n , int m){
        for(int i = 1 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if(mtx[i][j]!=0){
                    mtx[i][j] = mtx[i-1][j] + 1;
                }
            }
        }
        int max = 0;
        for(int i = 0 ; i < n ; i ++){
// todo           没改，应为堆栈那个算法
            for(int j = 0 ; j < m ; j ++){
                for(int k = j ; k < m ; k ++){
                    int[] t = new int[k - j + 1];
                    int y = 0 ;
                    for(int x = j ; x <= k ; x ++,y++){
                        t[y] = mtx[i][x];
                    }
                    Arrays.sort(t);
                    int min = t[0];
                    int temp = (k - j + 1) * min;
                    if(temp>max){
                        max = temp;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
