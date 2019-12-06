import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/10/11.
 */
public class 区间第k最小 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i = 0 ; i < n ; i ++){
            s.nextLine();
            String str = s.nextLine();
            String[] strings = str.split(" ");
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (String t: strings) {
                arrayList.add(Integer.parseInt(t));
            }
            int start = s.nextInt();
            int end = s.nextInt();
            s.nextLine();
            int k = s.nextInt();
            List<Integer> newList = arrayList.subList(start-1, end);
            Collections.sort(newList);
            System.out.println(newList.get(k - 1));
        }
    }
}