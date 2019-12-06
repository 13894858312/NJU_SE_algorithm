import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/25.
 */
public class 牛的繁殖问题 {
//    斐波那契简化公式
// F(2n) = F(n)[2*F(n+1) – F(n)]
// F(2n + 1) = F(n)^2 + F(n+1)^2
//    f(0) = 0 ; f(1) = 1
//    按题意需后移一位
    private static Map<Long, Long> map;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        map = new HashMap<>();
        for(int i = 0 ; i < t ; i++){
            long n = scanner.nextLong();
            System.out.println(fib(n + 1));
        }
    }

    private static long fib(long n) {
        if(n == 0){
            return 0;
        }
        if(n==2 || n==1){
            return 1;
        }
        if(map.containsKey(n))
            return map.get(n);
        if(n%2!=0)
        {
            long k=(n+1)/2;
            map.put(n,(fib(k)*fib(k)+fib(k-1)*fib(k-1))%1000000007);
        }
        else{
            long k=n/2;
            map.put(n,(fib(k)*((fib(k-1)<<1)+fib(k)))%1000000007);

        }
        return map.get(n);
    }
}
