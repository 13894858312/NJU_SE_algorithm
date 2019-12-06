import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by wangxue on 2019/10/10.
 */
public class 按照另一个数组排序 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        for(int i = 0 ; i < a ; i++) {
            int n = s.nextInt();
            int m = s.nextInt();
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int t = s.nextInt();
                list1.add(t);
            }
            for (int k = 0; k < m; k++) {
                int t = s.nextInt();
                list2.add(t);
            }
            func(list1, list2);
        }
    }

    private static void func(List<Integer> list1, List<Integer> list2){
        List<Integer> list3 = new ArrayList<>(list1);
        list3.removeAll(list2);
        Collections.sort(list3);

        list1.removeAll(list3);
        Map<Integer, Long> result = list1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Integer t: list2) {
            Long i = result.get(t);
            for(long j = 0 ; j < i ; j++){
                System.out.print(t+" ");
            }
        }
        for (Integer t:list3) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
