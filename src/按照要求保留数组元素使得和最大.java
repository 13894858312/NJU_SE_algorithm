import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/21.
 */
//todo 从最后开始删？
//https://practice.geeksforgeeks.org/problems/maximize-the-sum-of-selected-numbers-from-an-array-to-make-it-empty/0
public class 按照要求保留数组元素使得和最大 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-->0){
            int n = scanner.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                arrayList.add(scanner.nextInt());
            }

            func(arrayList);
        }
    }

    private static void func(ArrayList<Integer> arrayList){
        Collections.sort(arrayList);
        int sum=0;

        while(!arrayList.isEmpty()) {
            int x = arrayList.remove(arrayList.size()-1);
            int ind= Collections.binarySearch(arrayList, (x-1));
            sum += x;

            if(ind>=0)
                arrayList.remove(ind);
        }

        System.out.println(sum);

    }
}
