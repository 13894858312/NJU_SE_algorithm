import java.util.Scanner;

public class 字符串匹配问题 {
//模式匹配
//    将模式在文本上一次滑动，然后检查是否匹配。如果找到匹配项，则再次滑动1以检查后续匹配项。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-->0){
            String[] strs = scanner.nextLine().split(",");
            func(strs[0], strs[1]);
        }
    }


    private static void func(String str, String pat) {
        StringBuilder stringBuilder = new StringBuilder();
        int m = pat.length();
        int n = str.length();

        for (int i = 0; i <= n - m; i++) {

            int j;

            for (j = 0; j < m; j++)
                if (str.charAt(i + j) != pat.charAt(j))
                    break;

            if (j == m) {
                stringBuilder.append(i + " ");
            }
        }

        System.out.println(stringBuilder.toString().trim());
    }
}
