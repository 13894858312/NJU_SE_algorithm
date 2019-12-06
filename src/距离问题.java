
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/26.
 */
public class 距离问题 {
//    曼哈顿距离 | x2-x1 | + | y2-y1 |
//    欧几里得距离 sqrt（（x2-x1）^ 2 +（y2-y1）^ 2）
//    | x2-x1 | + | y2-y1 | = sqrt（（x2-x1）^ 2 +（y2-y1）^ 2）
//    化简 x1=x2 or y1=y2
//注意：结果为x+y-xy 时限为o（n）
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-->0){
            int n = scanner.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for(int i = 0 ; i < n ; i ++){
                x[i] = scanner.nextInt();
                y[i] = scanner.nextInt();
            }

            func(n, x, y);
        }
    }

    static class Position{
        int x;
        int y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static void func(int n, int[] x, int[] y){
        Map<Integer, Integer> xmap = new HashMap<>();
        Map<Integer, Integer> ymap = new HashMap<>();
        Map<Position, Integer> xymap = new HashMap<>();

        for(int i = 0 ; i < n ; i ++){
            int countx = xmap.containsKey(x[i]) ? xmap.get(x[i]) : 0;
            countx++;
            xmap.put(x[i], countx);

            int county = ymap.containsKey(y[i]) ? ymap.get(y[i]) : 0;
            county++;
            ymap.put(y[i], county);

            Position position = new Position(x[i], y[i]);
            int countxy = xymap.containsKey(position) ? xymap.get(position) : 0;
            countxy ++;
            xymap.put(position, countxy);
        }

        int res = 0;
        for (Integer i: xmap.values()){
            res += i*(i-1)/2;
        }
        for(Integer i : ymap.values()){
            res += i*(i-1)/2;
        }
        for(Integer i : xymap.values()){
            res -= i*(i-1)/2;
        }
        System.out.println(res);
    }
}
