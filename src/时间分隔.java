import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/28.
 */
public class 时间分隔 {
//    火车到站+1 出站-1

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-->0){
            int n = scanner.nextInt();
            int[] arrival = new int[n];
            int[] departure = new int[n];
            for(int i = 0 ; i < n ; i ++){
                arrival[i] = scanner.nextInt();
            }
            for(int i = 0 ; i < n ; i++){
                departure[i] = scanner.nextInt();
            }

            func(n, arrival, departure);
        }
    }

    private static void func(int n, int[] arrival, int[] departure){
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int p = 0 ;
        int q = 0 ;
        int count = 0;
        int max = 0;
        while (p<n && q<n){

            if(arrival[p] < departure[q]){
                count++;
                p++;
                max = Math.max(count, max);
            } else {
                count--;
                q++;
            }
        }
        System.out.println(max);
    }
}
