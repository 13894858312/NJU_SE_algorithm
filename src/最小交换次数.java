import java.util.*;

/**
 * Created by wangxue on 2019/11/25.
 */
public class 最小交换次数 {
//    https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
//所有环的大小-1
//    不是下面的方法
public static void main(String[] args){
    second();
}

    public static void second() {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            List<Integer> array = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                array.add(s.nextInt());
            }

            //处理
            int res = minswap(array);
            System.out.println(res);
        }
    }

    private static int minswap(List<Integer> nums){
        List<Integer> snums = new ArrayList<>();
        snums.addAll(nums);
        Collections.sort(snums);

        // 位置数组
        Map<Integer, Integer> inums = new HashMap<>();
        for (int i = 0; i < snums.size(); i++){

            inums.put(snums.get(i), i);
        }

        int count = 0;
        for (int i = 0; i < nums.size(); i++){
            // 最终位置与当前位置比较
            int target_i = inums.get(nums.get(i));
            while (target_i != i){
                //交换至当前位置正确
                int temp = nums.get(i);
                nums.set(i, nums.get(target_i));
                nums.set(target_i, temp);
                count++;
                target_i = inums.get(nums.get(i));
            }

        }
        return count;
    }
}
