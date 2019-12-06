import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//todo 还没看
public class 最长公共子序列 {
//https://blog.csdn.net/qq_36770641/article/details/81463895

    private static int T;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        T = in.nextInt();
        in.nextLine();
        while (T-- != 0) {
            String a = in.nextLine();
            String b = in.nextLine();

            Set<String> lcsSet = LCS(a, b);

            ArrayList<String> list = new ArrayList<>(lcsSet);
            if (list.size() == 1 && list.get(0).equals("")){
                continue;
            }
            list.sort(String::compareTo);
            for (int i = 0; i < list.size(); i++) {
                print(list.get(i), list.size()-1-i);
            }
        }
    }

    private static void print(String s, int n){
        if (T == 0 && n == 0){
            System.out.println(s);
        }else{
            System.out.println(s);
        }
    }

    public static Set<String> LCS(String a, String b) {
        int n = a.length(), m = b.length();
        //c[i][j]表示a长度为i和b长度为j时的最长公共子序列长度
        int[][] c = new int[n+1][m+1];
        //d[i][j]表示方向
        char[][] d = new char[n+1][m+1];
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                    //左上
                    d[i][j] = '↖';
                } else if(c[i-1][j] > c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    //上
                    d[i][j] = '↑';
                } else if(c[i-1][j] < c[i][j-1]){
                    c[i][j] = c[i][j-1];
                    //左
                    d[i][j] = '←';
                } else {
                    c[i][j] = c[i][j-1];
                    //可向左可向右
                    d[i][j] = '┘';
                }
            }
        }
        String lcs = "";
        Set<String> lcsSet = new HashSet<>();
        backTrace(d,a,lcs,n,m,c[n][m],lcsSet);

        return lcsSet;
    }

    private static void backTrace(char[][] d, String a, String lcs, int i , int j, int maxSublen, Set<String> lcsSet){
        if(i == 0 || j == 0) {
            StringBuilder sb = new StringBuilder(lcs);
            lcs = sb.reverse().toString();
            //可能有些提早出来了，一定要判断长度是最长的，但是这样还是会有重复的字符串，所以还要做去重处理
            if (lcs.length() == maxSublen) {
                lcsSet.add(lcs);
            }
            return;
        }

        switch (d[i][j]){
            case '↖':
                lcs += a.charAt(i-1);
                backTrace(d,a,lcs,i-1,j-1,maxSublen,lcsSet);
                break;
            case '↑':
                backTrace(d,a,lcs,i-1,j,maxSublen,lcsSet);
                break;
            case '←':
                backTrace(d,a,lcs,i,j-1,maxSublen,lcsSet);
                break;
            case '┘':
                backTrace(d,a,lcs,i-1,j,maxSublen,lcsSet);
                backTrace(d,a,lcs,i,j-1,maxSublen,lcsSet);
                break;
        }
    }

}