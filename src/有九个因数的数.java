import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/25.
 */
public class 有九个因数的数 {

//    筛号找小于n的质数 https://www.geeksforgeeks.org/sieve-of-eratosthenes/
//    只需要检查可以用p * q表示的range [1-sqrt（n）]中的所有数字，因为（p ^ 2 * q ^ 2）有9个因数，因此（p * q）^ 2也将有9个因子。
//    从1迭代到sqrt（n）并检查i是否可以表示为p * q，其中p和q是质数。
//    还要检查i是否为质数，然后pow（i，8）<= n，在这种情况下也应计算该数字。
//    可以以p * q和p ^ 8形式表示的数量计数之和是我们的答案。
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int n = scanner.nextInt();
            System.out.println(func(n));
        }
    }

    private static int func(long n){
        int count = 0;
        int limit = (int)Math.sqrt(n);
        int prime[] = new int[limit+1];

        for(int i = 1; i <= limit ; i++){
            prime[i] = i;
        }

        for(int i = 2 ; i*i <= limit ; i++){
            if(prime[i] == i){
                for (int j = i*i ; j <= limit ; j+= i){
                    if(prime[j] == j){
                        prime[j] = i;
                    }
                }
            }
        }

        for(int i = 2; i<= limit ; i++){
            int p = prime[i];//当前（i）的最小质数
            int q = prime[i / prime[i]];//i/质数的商的最小质数
            if(p*q == i && q!= 1 && p!= q){//i恰巧是两个质数的乘积
                count++;
            }else if(prime[i] == i){
                //i是质数，i^8属于结果
                if(Math.pow(i, 8) <= n){
                    count++;
                }
            }
        }
        return count;
    }
}
