import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/25.
 */
public class 序号乘方 {
//平方和公式 n(n+1)(2n+1)/6
//    二分查找
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-->0){
            long p = s.nextLong();
            System.out.println(func(p));
        }
    }

    private static long func(long p){
        long ans = 0;
        long low = (long) Math.pow(p, 1/3);
        long high = 144224;
        long mid;

        while (low <= high){
            mid = (low + high)/2;
            if(mid*(mid+1)*(2*mid+1)/6 <= p){
                ans = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return ans;

    }

}
