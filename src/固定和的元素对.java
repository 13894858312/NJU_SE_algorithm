import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wangxue on 2019/10/11.
 */
public class 固定和的元素对 {
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
            int sum = s.nextInt();
            func(arrayList, sum);
        }
    }
    
    private static void func(ArrayList<Integer> arrayList, int n){
        List<Integer> list = arrayList.stream().filter(now -> now <= n).sorted().collect(Collectors.toList());
        int count = 0;

        for(int i = list.size() - 1 ; i >= 0 ; i --){
            int sub = n - list.get(i);
            if(list.contains(sub)){
                count++;
            }
        }
        System.out.println(count/2);

    }
}
