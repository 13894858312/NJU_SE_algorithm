import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/22.
 */
//自己写的，不准
public class 广度优先遍历 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){

            n = scanner.nextInt();
            String start = scanner.next();
            nodes = new ArrayList<>();

            for(int i = 0 ; i < n ;i++){
                nodes.add(scanner.next());
            }

            mtx = new int[n][n];
            for(int i = 0 ; i < n ; i++){
                String now = scanner.next();
                int ptr = nodes.indexOf(now);

                for(int j = 0 ; j < n ; j ++){
                    mtx[ptr][j] = scanner.nextInt();
                }
            }

            already = new boolean[n];
            result = new ArrayList<>();

            int startPtr = nodes.indexOf(start);
            already[startPtr] = true;
            func(0, startPtr, new ArrayList<>());

            ArrayList<Integer> max = result.stream().max(new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    return o1.size() - o2.size();
                }
            }).get();

            max.add(0, startPtr);
            for(int i = 0 ; i < max.size(); i ++){
                if(i == max.size() - 1){
                    System.out.println(nodes.get(max.get(i)));
                }else {
                    System.out.print(nodes.get(max.get(i)) + " ");
                }
            }
        }
    }

    private static boolean[] already;
    private static int n;
    private static int[][] mtx;
    private static ArrayList<String> nodes;
    private static ArrayList<ArrayList<Integer>> result;

    private static void func(int now , int next, ArrayList<Integer> already_nodes) {
        if(now == n){
            ArrayList<Integer> a = new ArrayList<>();
            a.addAll(already_nodes);
            result.add(a);
            return;
        }

        boolean t = false;
        for(int i = 0 ; i < n ; i++){
            int[] nowLine = mtx[next];
            if(nowLine[i] == 1 && !already[i]){
                already_nodes.add(i);
                already[i] = true;
                t = true;
                func(now+1, i, already_nodes);
            }
        }

        if(!t){
            ArrayList<Integer> a = new ArrayList<>();
            a.addAll(already_nodes);
            result.add(a);
        }

    }
}
