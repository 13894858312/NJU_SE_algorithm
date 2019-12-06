import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/10/27.
 */
public class 冒泡排序 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int n = s.nextInt();
            int[] array = new int[n];
            for(int j = 0 ; j < n ; j ++){
                array[j] = s.nextInt();
            }
            func(n, array);
        }
    }

    private static void func(int n, int[] array){
        for(int i = 0 ; i < n-1 ; i ++){
            for(int j = 0; j < n - i -1; j++){
                if(array[j] > array[j+1]){
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        }
        Arrays.stream(array).forEach(a -> System.out.print(a+" "));
        System.out.println();
    }
}
