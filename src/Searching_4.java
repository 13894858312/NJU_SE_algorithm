import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yinywf
 * Created on 2019-10-17
 */
//@todo
//    大概是二分法查找，但是效率？
public class Searching_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 0; i < times; i++) {
            int num = scanner.nextInt();
            int[] nums = new int[num];
            for (int k = 0; k < num; k++) {
                nums[k] = scanner.nextInt();
            }

            List<Double> result = new ArrayList<>();
            for (int j = 0; j < num - 1; j++) {
                double temp = nums[j];
                double tempL = nums[j];
                double tempR = nums[j + 1];
                double t = 0;
                double left, right;
                while (true) {

                    left = 0;
                    right = 0;
                    for (int index = 0; index <= j; index++) {
                        left += 1.0 / (temp - nums[index]);
                    }

                    for (int index = j + 1; index < num; index++) {
                        right += 1.0 / (nums[index] - temp);
                    }
                    if (left - right > 0.00000001) {
                        t = temp;
                        temp = (temp + tempR) / 2.0;
                        tempL = t;
                    } else if (right - left > 0.00000001) {
                        t = temp;
                        temp = (tempL + temp) / 2.0;
                        tempR = t;
                    } else {
                        break;

                    }
                }
                result.add(temp);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Double d : result) {
                stringBuilder.append(df.format(d)).append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            System.out.println(stringBuilder.toString());
        }
    }


}