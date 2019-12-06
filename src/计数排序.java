import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/10/27.
 */
public class 计数排序{
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
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i ++){
            int count = 0;
            for(int j = 0 ; j < n ; j ++){
                if(i!=j){
                    if(array[j] <= array[i]){
                        count++;
                    }
                }
            }
            map.put(array[i], count);
        }

        int[] result = new int[n];

        for(int i = 0 ; i < n ; i++){
            int count = map.get(array[i]);
            result[count] = array[i];
            map.put(array[i], count-1);
        }

        for(int i = 0 ; i < n-1 ; i ++){
            System.out.print(result[i] + " ");
        }
        System.out.println(result[n-1]);
    }
}
