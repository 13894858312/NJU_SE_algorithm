import java.util.*;

/**
 * Created by wangxue on 2019/10/13.
 */
// todo
//    双端lis https://blog.csdn.net/yusiguyuan/article/details/39477929
//自己写的，不准
public class 先升后降 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();

        for(int i = 0 ; i < n ; i ++){
            String str = s.nextLine();
            String[] strings = str.split(" ");
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (String t: strings) {
                arrayList.add(Integer.parseInt(t));
            }
            func(arrayList);
        }
    }


    private static void func(ArrayList<Integer> arrayList){
        int n = arrayList.size();
        Integer[] a = new Integer[n];
        arrayList.toArray(a);

//        <当前下标,当前等长列>
//        <当前下标，当前下标，<数列>>
//        <当前下标,<当前下标,<当前下标,当前数字>>>
        Map<Integer, ArrayList<HashMap<Integer, Integer>>> left = new HashMap<>();

        for(int i = 0 ; i < n ; i++) {
            HashMap<Integer, Integer> list = new HashMap<>();
            list.put(i, a[i]);
            ArrayList<HashMap<Integer, Integer>> map = new ArrayList<>();
            map.add(list);
            left.put(i, map);

            for(int j = 0 ; j < i ; j ++) {
                if(a[j] < a[i]){
                    int l1 = left.get(j).get(0).size();
                    int l2 = left.get(i).get(0).size();

                    if(l1 == l2 - 1){

                        ArrayList<HashMap<Integer, Integer>> arrayList1 = new ArrayList<>();
                        arrayList1.addAll(left.get(i));

                        for(HashMap<Integer, Integer> map2: left.get(j)){

                            HashMap<Integer, Integer> map1 = new HashMap<>();
                            map1.putAll(map2);
                            map1.put(i, list.get(i));

                            arrayList1.add(map1);
                        }

                        left.put(i, arrayList1);

                    }
                    if(l1 > l2 - 1){

                        ArrayList<HashMap<Integer, Integer>> arrayList1 = new ArrayList<>();

                        for(HashMap<Integer, Integer> map2: left.get(j)){

                            HashMap<Integer, Integer> map1 = new HashMap<>();
                            map1.putAll(map2);
                            map1.put(i, list.get(i));

                            arrayList1.add(map1);
                        }

                        left.put(i, arrayList1);
                    }
                }
            }
        }



        Map<Integer, ArrayList<HashMap<Integer, Integer>>> right = new HashMap<>();

        for(int i = n-1 ; i >= 0 ; i--) {
            HashMap<Integer, Integer> list = new HashMap<>();
            list.put(i, a[i]);
            ArrayList<HashMap<Integer, Integer>> map = new ArrayList<>();
            map.add(list);
            right.put(i, map);

            for(int j = n-1 ; j > i ; j --) {
                if(a[j] < a[i]){
                    int l1 = right.get(j).get(0).size();
                    int l2 = right.get(i).get(0).size();

                    if(l1 == l2 - 1){

                        ArrayList<HashMap<Integer, Integer>> arrayList1 = new ArrayList<>();
                        arrayList1.addAll(right.get(i));

                        for(HashMap<Integer, Integer> map2: right.get(j)){

                            HashMap<Integer, Integer> map1 = new HashMap<>();
                            map1.putAll(map2);
                            map1.put(i, list.get(i));

                            arrayList1.add(map1);
                        }

                        right.put(i, arrayList1);

                    }
                    if(l1 > l2 - 1){

                        ArrayList<HashMap<Integer, Integer>> arrayList1 = new ArrayList<>();

                        for(HashMap<Integer, Integer> map2: right.get(j)){

                            HashMap<Integer, Integer> map1 = new HashMap<>();
                            map1.putAll(map2);
                            map1.put(i, list.get(i));

                            arrayList1.add(map1);
                        }

                        right.put(i, arrayList1);
                    }
                }
            }
        }

        int max = 0;
        ArrayList<Integer> pos = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){

            int l1 = left.get(i).get(0).size();
            int l2 = right.get(i).get(0).size();

            int now = l1 + l2;

            if(now == max){
                pos.add(i);
            }
            if(now > max){
                max = now;
                pos = new ArrayList<>();
                pos.add(i);
            }
        }

        Set<ArrayList<Integer>> result = new HashSet<>();

        for(int t : pos){

            ArrayList<Integer> arrayList1 = new ArrayList<>();

            for(HashMap<Integer, Integer> temp : left.get(t)){
                for(HashMap<Integer, Integer> temp1 : right.get(t)){

                    arrayList1 = new ArrayList<>();
                    HashMap<Integer, Integer> map = new HashMap<>();
                    map.putAll(temp);
                    map.putAll(temp1);

                    Map<Integer, Integer> map1 = new TreeMap<>(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    });
                    map1.putAll(map);
                    //排序
//                    map.entrySet().stream()
//                            .sorted(Map.Entry.comparingByKey()).forEachOrdered(e -> map1.put(e.getKey(), e.getValue()));

                    arrayList1.addAll(map1.values());
                    result.add(arrayList1);
                }
            }

        }

        ArrayList<String> strings = new ArrayList<>();
        for(ArrayList<Integer> arrayList1: result){
            StringBuffer stringBuffer = new StringBuffer();
            for(int i : arrayList1){
                stringBuffer.append(i + " ");
            }
            strings.add(stringBuffer.toString().trim());
        }
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for(String stringBuffer: strings){
            System.out.println(stringBuffer);
        }

    }
}
