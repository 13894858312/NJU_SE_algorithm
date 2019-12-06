import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/22.
 */
//自己写的，不准
public class 棋盘覆盖问题 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int search_x = scanner.nextInt();
            int search_y = scanner.nextInt();

            int size =(int) Math.pow(2, n);
            mtx = new int[size][size];
            count = 0;
            mtx[x][y] = t;

            func(0, 0, x, y, size);
            search(size, search_x, search_y);
        }
    }

    private static int count;
    private static int[][] mtx;

    private static void search(int size, int x, int y){
        ArrayList<String> strings = new ArrayList<>();
        int num = mtx[x][y];
        for(int i = x-1 ; i <= x+1 && i < size ; i++){
            if(i<0){
                continue;
            }
            for(int j = y-1 ; j <= y+1 && j < size ; j++){
                if(j<0){
                    continue;
                }
                if( i == x && j == y){
                    continue;
                }
                if(mtx[i][j] == num){
                    strings.add(i+" "+j);
                }
            }
        }

        System.out.println(strings.get(0) + "," + strings.get(1));

    }

    private static void func(int start_x, int start_y, int x, int y, int size){
        if(size == 1){
            return;
        }
        int no = ++count;
        int half = size/2;
        //左上
        if(x < start_x+half && y < start_y+half){
            func(start_x, start_y, x, y, half);
        }else{
            mtx[start_x+half-1][start_y+half-1] = no;
            func(start_x, start_y, start_x+half-1, start_y+half-1, half);
        }
        //右上
        if(x >= start_x+half && y<start_y+half){
            func(start_x+half, start_y, x,y,half);
        }else{
            mtx[start_x+half][start_y+half-1] = no;
            func(start_x+half, start_y, start_x+half, start_y+half-1, half);
        }
        //左下
        if(x < start_x+half && y>=start_y+half){
            func(start_x, start_y+half, x, y, half);
        }else {
            mtx[start_x+half-1][start_y+half] = no;
            func(start_x, start_y+half, start_x+half-1, start_y+half, half);
        }
        //右下
        if(x >= start_x+half && y>= start_y+half){
            func(start_x+half, start_y+half, x, y ,half);
        }else {
            mtx[start_x+half][start_y+half] = no;
            func(start_x+half, start_y+half, start_x+half, start_y+half, half);
        }

    }
}
