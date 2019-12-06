import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/25.
 */
public class 对称子字符串 {
//    i：123123 o:6 最长和对称字符串的长度

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        while (t-->0){
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();

            int[] ints = new int[s.length()];
            for (int i = 0 ;  i< s.length(); i++){
                ints[i] = chars[i]-'0';
            }

            func(ints);
        }
    }

//    考虑所有可能的中点并向两侧扩展
    private static void func(int[] ints){
        int n = ints.length;

        int res = 0;

        for(int i = 0 ; i <= n-2 ;i++){
            int l = i;
            int r = i+1;

            int lsum = 0;
            int rsum = 0;

            while (r < n && l >= 0){
                lsum += ints[l];
                rsum += ints[r];
                if(lsum == rsum){
                    res = Math.max(res, r-l+1) ;
                }
                l--;
                r++;
            }

        }

        System.out.println(res);
    }
}
