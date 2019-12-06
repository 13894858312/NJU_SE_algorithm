import java.util.*;

/**
 * Created by wangxue on 2019/10/11.
 */
//todo
//    https://www.jianshu.com/p/ff4b4bee9f79
public class 调整数组使差最小 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();

        for(int i = 0 ; i < n ; i ++){
            res = new HashSet<>();

            String str1 = s.nextLine();
            String[] strings1 = str1.split(" ");
            ArrayList<Integer> arrayList1 = new ArrayList<>();
            for (String t: strings1) {
                arrayList1.add(Integer.parseInt(t));
            }

            String str2 = s.nextLine();
            String[] strings2 = str2.split(" ");
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (String t: strings2) {
                arrayList2.add(Integer.parseInt(t));
            }

            func(arrayList1, arrayList2);
        }
    }

    private static void func(List<Integer> list1, List<Integer> list2){

        List<Integer> list = new ArrayList<>();
        list.addAll(list1);
        list.addAll(list2);

        int sum = list.stream().mapToInt(i->i).sum();

        int n = list1.size();
        part(list, new ArrayList<>(), n, 0);

        int min = 999999999;
        for(Integer i : res){
            int now = Math.abs( (sum-i) - i );
            if(now < min){
                min = now;
            }
        }
        System.out.println(min);
    }

    private static Set<Integer> res;

    private static void part(List<Integer> list, List<Integer> now, int n, int i){

        if(now.size() == n){
            int sum = now.stream().mapToInt(j->j).sum();
            if(!res.contains(sum)){
                res.add(sum);
            }
            return;
        }

        if(list.size() == 0 || i >= list.size()){
            return;
        }

        now.add(list.get(i));
        part(list, now, n, i+1);

        now.remove(now.size() - 1);
        part(list, now, n, i+1);
    }
}

