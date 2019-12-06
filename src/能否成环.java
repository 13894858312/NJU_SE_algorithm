import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/27.
 */
//todo
//    想法是创建所有字符的有向图，然后在图中确定它们是否为欧拉回路。
//    欧拉路径是图形中的一条路径，该路径恰好访问每个边缘一次。欧拉回路是一条始于和终止于同一顶点的欧拉路径。
//    https://www.geeksforgeeks.org/given-array-strings-find-strings-can-chained-form-circle/
//    每个顶点的入度和出度相同且所有非零度顶点形成单个强连通分量的情况下，有向图才具有欧拉回路。

//    检查该图是否可以具有遍历所有顶点的循环
//    https://www.geeksforgeeks.org/find-array-strings-can-chained-form-circle-set-2/
//1）每个顶点的Indegree和Outdegree应该相同。
//2）图应牢固连接。

/**
 *
 * https://practice.geeksforgeeks.org/viewSol.php?subId=30399511599303&pid=995&user=%E6%9D%8E%E5%BF%97%E5%AE%8F
 */
public class 能否成环 {

    static boolean found = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOftest = scanner.nextInt();
        for (int i = 0; i < numOftest; i++) {
            int size = scanner.nextInt();
            scanner.nextLine();
            String[] array = new String[size];
            for (int j = 0; j < size; j++) {
                array[j] = scanner.next();
            }

            checkCircle(array, size);
        }

    }

    private static void checkCircle(String[] array, int size) {
        if (size == 0) {
            System.out.println(0);
        } else if (size == 1) {
            String s = array[0];
            if (s.charAt(0) == s.charAt(s.length() - 1)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else {

            //head <-> tail
            boolean headMask[] = new boolean[size];
            boolean tailMask[] = new boolean[size];

            String s = array[0];
            char tail = s.charAt(s.length() - 1);
            for (int i = 1; i < size; i++) {
                if (tail == array[i].charAt(0)) {

                    tailMask[0] = true;
                    headMask[i] = true;

                    find(headMask, tailMask, array, i, 1);

                    headMask[0] = false;
                    headMask[i] = false;

                }
            }

            if (found) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }

        found = false;
    }

    private static void find(boolean[] headMask, boolean[] tailMask, String[] array, int index, int counter) {

        if (found) return;

        if (counter == array.length - 1) {
            String s = array[index];
            if (s.charAt(s.length() - 1) == array[0].charAt(0)) {
                found = true;
                return;
            }
        }

        String s = array[index];
        char tail = s.charAt(s.length() - 1);
        for (int i = 1; i < array.length; i++) {
            if (tail == array[i].charAt(0) && (!headMask[i])) {

                tailMask[index] = true;
                headMask[i] = true;

                find(headMask, tailMask, array, i, counter + 1);

                tailMask[index] = false;
                headMask[i] = false;

            }
        }
    }
}
