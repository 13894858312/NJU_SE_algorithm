import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/25.
 */
public class 无限递归字符串查询 {
//    Constraints:1<=Q<=10^5, 1<=POS<=10^12
//    12345$12345$54321

    private static char[] res = {'1','2','3','4','5','$','5','4','3','2','1'};
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-->0){
            long search = scanner.nextLong();
            System.out.println(func(search));

        }
    }
//    如果A的初始长度是N，那么在每次操作之后，A的大小会重复增加N=N*2+i。我们发现需要使i最小，这样K>N。
    private static char func(long search){
        long n = 11;

        if(search == 0){
            return ' ';
        }
        int i = 1;
        while (n < search){
            n = 2 * n + (++i);
        }
        while (search > 11){
            long prevlen = (n - i)/2;
            if(search > prevlen){
                search -= prevlen;
                if(search <= i){
                    return '$';
                }
                search -= i;
            }
            i--;
            n = prevlen;
        }
        return res[(int)search-1];
    }
}
