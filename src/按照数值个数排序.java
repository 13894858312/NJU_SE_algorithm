import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wangxue on 2019/11/22.
 */
//自己写的，不准
public class 按照数值个数排序 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int n = scanner.nextInt();
            ArrayList<Integer> array = new ArrayList<>();

            for (int i = 0 ; i < n ;  i++){
                array.add(scanner.nextInt());
            }
            func(array);
        }
    }

    private static void func(ArrayList<Integer> array){
        Map<Integer, Long> map = array.stream().collect(Collectors.groupingBy(x->x, Collectors.counting()));
        List<Map.Entry<Integer, Long>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Long>>() {
            @Override
            public int compare(Map.Entry<Integer, Long> o1, Map.Entry<Integer, Long> o2) {
                if(o1.getValue().equals(o2.getValue())){
                    return o1.getKey() - o2.getKey();
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        StringBuffer sb = new StringBuffer();

        for(Map.Entry<Integer, Long> entry: list){
            int key = entry.getKey();
            long value = entry.getValue();
            while (value-->0){
                sb.append(key+" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
