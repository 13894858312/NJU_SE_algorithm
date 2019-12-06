import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/25.
 */
public class 整除查询 {

    //不用看
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-->0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[] array = new int[n];
            for(int i = 0 ; i < n ; i ++){
                array[i] = scanner.nextInt();
            }

            int[] search = new int[m];
            for(int i = 0 ; i < m ; i++){
                search[i] = scanner.nextInt();
            }

            func(n, m, array, search);
        }
    }

    private static void func(int n, int m, int[] array, int[] search){
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < m ; i++){
            int count = 0;
            for(int j = 0 ; j < n ; j++){
                if(array[j] % search[i] == 0){
                    count++;
                }
            }
            sb.append(count+" ");
        }
        System.out.println(sb.toString().trim());
    }
}
