import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/26.
 */
//todo
public class 和最大的连续降序字符 {
//    在给定的字符串中在任意位置选取任意个数的字符,这些字符必须满足它们之间的差相同,比如ABC,ACE, ACEG, BDFH
//    将满足1的字符串中选取最长的某些字符串,比如 ACEG … BDFH等等
//    在满足2的字符串中选取其ASC码最大的字符串比如BDFH
//    将满足3的字符串逆序输出

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-->0){
            String s = scanner.next();
            char[] chars = s.toCharArray();

            func(chars);
        }
    }

    private static void func(char[] chars){
        boolean[] ch = new boolean[26];
        for(int i = 0; i<chars.length; i++){
            ch[chars[i]-'A'] = true;
        }
        String res = "";
        for(int i = 1; i<26; i++) {
            for(int j = 25; j>=0; j--) {
                if(ch[j]) {
                    String temp = "";
                    temp+=(char)('A'+j);
                    for(int k = j-i; k>=0; k-=i) {
                        if(ch[k])
                            temp+=(char)('A'+k);
                        else
                            break;
                    }
                    if(temp.length()>=res.length())
                        res = temp;
                }
            }
        }
        System.out.println(res);
    }
}
