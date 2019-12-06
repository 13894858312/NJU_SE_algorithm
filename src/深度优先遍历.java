import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/22.
 */
//自己写的，不准
public class 深度优先遍历 {
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
            func(0, startPtr);

            System.out.println(result.stream().max(Integer::compareTo).get());
        }
    }

    private static boolean[] already;
    private static int n;
    private static int[][] mtx;
    private static ArrayList<String> nodes;
    private static ArrayList<Integer> result;

    private static void func(int now , int next){
        if(now == n){
            result.add(now);
            return;
        }

        int[] nowLine = mtx[next];
        boolean t = false;
        for(int i = 0 ; i < n ; i++){
            if(nowLine[i] == 1 && !already[i]){
                already[i] = true;
                func(now + 1, i);
                t = true;
            }
        }

        if(!t){
            result.add(now);
        }
    }
}
