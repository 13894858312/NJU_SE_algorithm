import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/10/11.
 */
public class 数组和窗口 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for(int i = 0 ; i < n ; i ++){
            s.nextLine();

            String str = s.nextLine();
            String[] strs = str.split(" ");

            ArrayList<Integer> arrayList = new ArrayList<>();

            for(String t : strs){
                arrayList.add(Integer.parseInt(t));
            }

            int w = s.nextInt();
            func(arrayList, w);
        }
    }

    private static void func(ArrayList<Integer> list, int w){
        int sum = 0;

        for(int i = 0 ; i < list.size() - w + 1 ; i++){
            int max = 0;
            for(int j = i ; j < i+w ; j++){
                if(list.get(j) > max){
                    max = list.get(j);
                }
            }
            sum += max;
        }
        System.out.println(sum);
    }
}
