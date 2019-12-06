import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/25.
 */
public class 汉诺塔 {
//    汉诺塔问题中限制不能将一层塔直接从最左侧移动到最右侧，也不能直接从最右侧移动到最左侧，而是必须经过中间。求当有N层塔的时候移动步数。
//    汉诺func相同

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int n = scanner.nextInt();
            System.out.println(func(n));
        }
    }
//    def hanoi(num):
//        if num == 1:
//            print(A+'2'+B)
//            print(B+'2'+C)
//        else:
//            hanoi(num-1)
//            print(A+'2'+B)
//            hanoi(num-1)
//            print(B+'2'+C)
//            hanoi(num-1)

    private static long func(int n){
        if(n == 1){
            return 2;
        }
        return func(n-1) * 3 + 2;
    }
}
