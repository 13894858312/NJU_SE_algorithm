import java.util.Scanner;

//https://www.geeksforgeeks.org/allocate-minimum-number-pages/
//类似漆狗屋
public class 书本分发 {
//    二分法查找
//    ？？似乎是不太对劲
//    我们将页数的值固定为当前最小和最大的中间值。我们将最小值和最大值分别初始化为0和所有页
// 面的总和。如果当前的中点可以解决，那么我们在下半部分搜索，否则在上半部分搜索。
//    我们需要检查是否可以以最大人数不超过当前人数的方式将页面分配给所有学生。为此，我们
// 按顺序为每个学生分配页面，而当前分配的页面数不超过该值。在此过程中，如果学生人数超过m，则该解决方案不可行。其他可行。


    // Utility method to check if current minimum value
    // is feasible or not.
    private static boolean isPossible(int arr[], int n, int m, int curr_min)
    {
        int studentsRequired = 1;
        int curr_sum = 0;

        // iterate over all books
        for (int i = 0; i < n; i++)
        {
            // check if current number of pages are greater
            // than curr_min that means we will get the result
            // after mid no. of pages
            if (arr[i] > curr_min)
                return false;

            // count how many students are required
            // to distribute curr_min pages
            if (curr_sum + arr[i] > curr_min)
            {
                // increment student count
                studentsRequired++;

                // update curr_sum
                curr_sum = arr[i];

                // if students required becomes greater
                // than given no. of students,return false
                if (studentsRequired > m)
                    return false;
            }

            // else update curr_sum
            else
                curr_sum += arr[i];
        }
        return true;
    }

    // method to find minimum pages
    private static int findPages(int arr[], int n, int m)
    {
        long sum = 0;

        // return -1 if no. of books is less than
        // no. of students
        if (n < m)
            return -1;

        // Count total number of pages
        for (int i = 0; i < n; i++)
            sum += arr[i];

        // initialize start as 0 pages and end as
        // total pages
        int start = 0, end = (int) sum;
        int result = Integer.MAX_VALUE;

        // traverse until start <= end
        while (start <= end)
        {
            // check if it is possible to distribute
            // books by using mid is current minimum
            int mid = (start + end) / 2;
            if (isPossible(arr, n, m, mid))
            {
                // if yes then find the minimum distribution
                result = Math.min(result, mid);

                // as we are finding minimum and books
                // are sorted so reduce end = mid -1
                // that means
                end = mid - 1;
            }

            else
                // if not possible means pages should be
                // increased so update start = mid + 1
                start = mid + 1;
        }

        // at-last return minimum no. of pages
        return result;
    }

    // Driver Method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-->0){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = scanner.nextInt();
            }
            int m = scanner.nextInt();

            System.out.println(findPages(arr, n, m));
        }
    }
}
