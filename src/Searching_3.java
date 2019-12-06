import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/25.
 */
public class Searching_3 {

    //根据排名查找成绩

    //    先求出每组最后一位的排名newrank
//    二分查找出成绩范围
//    根据newrank计算排名
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t--> 0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            long[] left = new long[n];
            long[] right = new long[n];
            for(int i = 0 ; i < n ; i++){
                left[i] = scanner.nextLong();
                right[i] = scanner.nextLong();
            }

            long[] query = new long[m];
            for(int i = 0 ; i < m ; i++){
                query[i] = scanner.nextLong();
            }

            func(n, m, left, right, query);
        }
    }

    private static void func(int n, int m, long[] left, long[] right, long[] query){
        long[] newrank = new long[n+1];
        for(int i = 0 ; i < n ; i ++){
            if(i == 0){
                newrank[i] = right[i] - left[i] + 1;
            }else {
                newrank[i] = newrank[i-1] + right[i]-left[i] + 1;
            }
        }

        for(int i = 0 ; i < m  ; i ++){
            long q = query[i];

            int ans = -1;
            int low = 0 ;
            int high = n;
            while (low <= high){
                int mid = (low+high)/2;
                if(newrank[mid] >= q){
                    ans = mid;
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }

            long res = right[ans] - (newrank[ans]-q);

            if(i == m-1){
                System.out.println(res);
            }else {
                System.out.print(res+" ");
            }
        }

    }
}
