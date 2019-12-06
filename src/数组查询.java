import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/21.
 */
//@todo
public class 数组查询 {
//    https://www.geeksforgeeks.org/maximum-sum-subarray-removing-one-element/
    public static void main(String[] args){
        Scanner scanner = new Scanner((System.in));
        int t = scanner.nextInt();
        for(int i = 0 ; i < t ; i ++){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int j = 0 ; j < n ; j ++){
                nums[j] = scanner.nextInt();
            }
            func(n, nums);
        }
    }

    private static void func(int n, int[] arr){
        int fw[] = new int[n];
        int bw[] = new int[n];
        int cur_max = arr[0], max_so_far = arr[0];

        fw[0] = arr[0];

        for (int i = 1; i < n; i++) {

            cur_max = Math.max(arr[i], cur_max + arr[i]);
            max_so_far = Math.max(max_so_far, cur_max);

            fw[i] = cur_max;
        }

        cur_max = bw[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            cur_max = Math.max(arr[i], cur_max + arr[i]);
//            max_so_far = Math.max(max_so_far, cur_max);

            bw[i] = cur_max;
        }

        int fans = max_so_far;

        for (int i = 1; i < n - 1; i++){
            fans = Math.max(fans, fw[i - 1] + bw[i + 1]);
        }
        System.out.println(fans);
    }
}
