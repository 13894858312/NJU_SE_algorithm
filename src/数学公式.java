import java.util.Scanner;

/**
 * Created by wangxue on 2019/10/17.
 */
public class 数学公式 {
//不用看
    //    1≤T≤70，1≤A≤10^5，1≤B≤10^5，1≤C≤10^5
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i = 0 ; i < t ; i ++){
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            func(a, b, c);
        }
    }

    private static void func(int a, int b, int c){
        int front = 1;
        for(int i = 0 ; i < b ; i ++){
            front = front * a % c;
        }
        System.out.println(front);
    }
}
