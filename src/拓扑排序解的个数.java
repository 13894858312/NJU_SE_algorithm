import java.util.*;

/**
 * Created by wangxue on 2019/11/25.
 */
//自己写的，不准
public class 拓扑排序解的个数 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        while (t-->0){
            String string = scanner.nextLine();
            String[] dui_s = string.split(",");

            Set<String> set = new HashSet<>();

            for(int i = 0 ; i< dui_s.length ; i++){
                String[] ab = dui_s[i].split(" ");
                String a = ab[0];
                String b = ab[1];

                set.add(a);
                set.add(b);
            }

            int n = set.size();
            String[] nodes = new String[n];
            set.toArray(nodes);

            boolean[][] mtx = new boolean[n][n];

            for(int i = 0 ; i < dui_s.length ; i++){
                String[] ab = dui_s[i].split(" ");
                String a = ab[0];
                String b = ab[1];

                int a_ptr = Arrays.binarySearch(nodes, a);
                int b_ptr = Arrays.binarySearch(nodes, b);
                mtx[a_ptr][b_ptr] = true;
            }

            func(n, mtx);

        }
    }

    private static void func(int n, boolean[][] mtx){
        boolean[] already = new boolean[n];
        int res = 1;
        while (!isAlready(already)){
            ArrayList<Integer> a = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){//列
                if(already[i]){
                    continue;
                }
                boolean isStart = true;
                for(int j = 0 ; j < n ; j ++){//行
                    if(already[j]){
                        continue;
                    }
                    if(mtx[j][i]){
                        isStart = false;
                        break;
                    }
                }

                if(isStart){
                    a.add(i);
                }
            }

            for(Integer integer: a){
                already[integer] = true;
            }

            res*=a.size();
        }

        System.out.println(res);
    }

    private static boolean isAlready(boolean[] already){
        boolean flag = true;
        for (boolean b: already){
            if(!b){
                flag = false;
                break;
            }
        }
        return flag;
    }


}
