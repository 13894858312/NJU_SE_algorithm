import java.util.*;

/**
 * Created by wangxue on 2019/11/25.
 */
public class 子数组的取值范围 {
//    https://blog.csdn.net/u014041033/article/details/52267370
//    不太对 看github

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        StringBuffer stringBuffer = new StringBuffer();
        while (t-->0){

            scanner.nextLine();
            String str = scanner.nextLine();
            String[] str_list = str.split(" ");
            int[] arr = new int[str_list.length];
            for(int i = 0 ; i < str_list.length ; i ++){
                arr[i] = Integer.parseInt(str_list[i]);
            }
            int num = scanner.nextInt();

            stringBuffer.append(func(arr, num) + "\n");
        }
        System.out.print(stringBuffer.toString().trim());
    }

    private static int func(int[] arr,int num){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int res = 0;

        for(int i = 0 ; i < arr.length ; i ++){
            for(int j = i+1 ; j < arr.length ; j ++){
                if(Math.abs(arr[i] - arr[j]) > num){
                    res += arr.length - j;
                    break;
                }
            }
        }

        return res;
    }

}
