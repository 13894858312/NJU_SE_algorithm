import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/28.
 */
//todo 合并排序？
//https://practice.geeksforgeeks.org/problems/geek-collects-the-balls/0
public class 路上的球 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-->0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];

            for(int i = 0 ; i < n ; i++){
                a[i] = scanner.nextInt();
            }
            for(int i = 0 ; i < m ; i++){
                b[i] = scanner.nextInt();
            }

            func(a, b, n, m);
        }

    }
    public static void func(int a[],int b[],int n,int m) {
        long first=0;
        long second=0;
        long res=0;
        int i=0;
        int j=0;

        while(i<n&& j<m) {

            if(a[i]<b[j]){
                first+=a[i++];
            } else if(a[i]>b[j]) {
                second+=b[j++];
            } else {
                res += Math.max(first, second)+a[i];

                first=0;
                second=0;

                int temp = b[j];

                i++;
                j++;
                while(i<n && a[i]==temp){
                    res += a[i++];
                }
                while(j<m && b[j]==temp) {
                    res += b[j++];
                }
            }
        }
        while(i<n) {
            first += a[i++];
        }
        while(j<m) {
            second += b[j++];
        }
        res+=Math.max(first,second);
        System.out.println(res);
    }
}
