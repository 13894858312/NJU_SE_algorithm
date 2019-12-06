import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/10/27.
 */
public class 插入排序 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int[] array = new int[n];
            for(int j = 0 ; j < n ; j ++){
                array[j] = s.nextInt();
            }
            func(n, array);
        }
    }

    private static void func(int n, int[] array){
        for(int i = 1 ; i < n ; i ++){
            int t = array[i];
            int j = i -1;
            while(j >= 0 && array[j] > t ){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = t;
        }
        Arrays.stream(array).forEach(a -> System.out.print(a+" "));
        System.out.println();
    }
}
