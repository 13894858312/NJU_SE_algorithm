import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/21.
 */
//自己写的，不准
public class 分配问题 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            n = scanner.nextInt();
            mtx = new int[n][n];
            already = new boolean[n];
            sums = new ArrayList<>();
            min = Integer.MAX_VALUE;


            scanner.nextLine();
            String str = scanner.nextLine();
            String[] strs = str.split(",");
            for(String s:strs){
                String[] ts = s.split(" ");
                int pers = Integer.parseInt(ts[0]) - 1;//人
                int task = Integer.parseInt(ts[1]) - 1;//任务
                int c = Integer.parseInt(ts[2]);//成本

                mtx[pers][task] = c;
            }

            func(0, 0, new ArrayList<>());
            sort();

            for(int i = 0 ; i< sums.size(); i++){
                ArrayList<Integer> list = sums.get(i);
                for(int j = 0 ; j < list.size() ; j++){
                    if(j == list.size()-1){
                        System.out.print(list.get(j));
                    }else {
                        System.out.print(list.get(j) +" ");
                    }
                }
                if(i==sums.size()-1){
                    System.out.println();
                }else{
                    System.out.print(",");
                }
            }
        }
    }

    //    1 1 6,1 2 4,1 3 5,1 4 4,2 1 8,2 2 9,2 3 7,2 4 7,3 1 3,3 2 3,3 3 3,3 4 3,4 1 8,4 2 8,4 3 7,4 4 8
    private static ArrayList<ArrayList<Integer>> sums;
    private static int min;
    private static int[][] mtx;
    private static boolean[] already;
    private static int n;

    private static void func(int i, int count, ArrayList<Integer> now){

        if(count > min){
            return;
        }

        if(i>=n){
            if(count < min){
                sums = new ArrayList<>();
                min = count;
            }
            ArrayList<Integer> a = new ArrayList<>();
            a.addAll(now);
            sums.add(a);
            return;
        }

        if(count<min){
            for(int j = 0 ; j < n ;j++){
                if(!already[j]){
                    already[j] = true;
                    int task = j + 1;
                    now.add(task);
                    func(i+1, count+mtx[i][j], now);

                    already[j] = false;
                    now.remove((Object)task);
                }
            }
        }
    }

    private static void sort(){
        sums.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int i = 0;
                while (o1.get(i).equals(o2.get(i))){
                    i++;
                }
                return o2.get(i) - o1.get(i);
            }
        });
    }
}