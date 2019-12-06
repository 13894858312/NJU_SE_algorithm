import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/22.
 */
//自己写的，很垃圾
public class 实现shell排序 {

//    https://blog.csdn.net/qq_28081081/article/details/80598960
    public static int[] sort(int[] ins){

        int n = ins.length;
        int gap = n/2;
        while(gap > 0){
            for(int j = gap; j < n; j++){
                int i=j;
                while(i >= gap && ins[i-gap] > ins[i]){
                    int temp = ins[i-gap]+ins[i];
                    ins[i-gap] = temp-ins[i-gap];
                    ins[i] = temp-ins[i-gap];
                    i -= gap;
                }
            }
            gap = gap/2;
        }
        return ins;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-->0){
            String arrayString = scanner.nextLine();
            String gapString = scanner.nextLine();

            String[] strs1 = arrayString.split(" ");
            int n = strs1.length;
            int[] array = new int[n];
            for(int i = 0 ; i<n ; i++){
                array[i] = Integer.parseInt(strs1[i]);
            }

            String[] strs2 = gapString.split(" ");
            int g = strs2.length;
            int[] gaps = new int[g];
            for(int i = 0 ; i< g ; i ++){
                gaps[i] = Integer.parseInt(strs2[i]);
            }

            func(n, g, array, gaps);
        }
    }

    private static void func(int n, int g, int[] array, int[] gaps){
        for(int i = 0 ; i < g ; i++){
            int gap = gaps[i];
            ArrayList<Integer>[] lists = new ArrayList[gap];
            for(int j = 0 ; j < gap ; j ++){
                lists[j] = new ArrayList<>();
            }

            for(int j = 0 ; j < n ; j++){
                lists[j%gap].add(array[j]);
            }

            for(int j = 0 ; j < gap ; j++){
                ArrayList<Integer> list1 = crpx(lists[j]);


                for(int k = 0 ; k < list1.size() ; k++){
                    array[k*gap+j] = list1.get(k);
                }
            }
        }

        for(int i = 0 ; i < n ; i ++){
            if(i== n-1){
                System.out.println(array[i]);
            }else{
                System.out.print(array[i] + " ");
            }
        }

    }

    private static ArrayList<Integer> crpx(ArrayList<Integer> array){
        int n = array.size();

        for(int i = 1 ; i < n ; i++){
            int now = array.get(i);
            int j = i-1;
            while (j>=0 && array.get(j) > now){
                j--;
            }
            for(int k = i-1 ; k > j; k--){
                array.set(k+1, array.get(k));
            }
            array.set(j+1, now);
        }
        return array;
    }

}
