import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/25.
 */
public class 素数和问题 {
//    按有九个因数的数那种筛子方式筛选素数后计算
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] arr = new int[t];
        int max = -1;

        for(int i = 0 ; i < t ; i++){
            int n = scanner.nextInt();
            arr[i] = n;
            max = n>max ? n : max;
        }

        prime = primeList(max);

        for (int n : arr){
            func(n);
        }
    }

    private static boolean[] prime;

    private static void func(int n){
        for(int i = 2 ; i <= n/2 ; i++){
            int t = n - i;
            if(prime[t] && prime[i]){
                System.out.println( i + " " + t);
                return;
            }
        }
        System.out.println("error");
    }

    private static boolean[]primeList(int max){
        boolean[] prime = new boolean[max + 1];
        prime[0] = false;
        prime[1] = false;
        for(int i = 2 ; i <= max ; i++){
            prime[i] = true;
        }

        for(int i = 2 ; i*i <= max ; i++){
            if(!prime[i]){
                continue;
            }
            for(int t = i * i ; t <= max ; t += i) {
                prime[t] = false;
            }
        }
        return prime;
    }
}
