import java.util.*;
import java.util.stream.Collectors;

//@todo
public class 点的凸包{

//    https://www.geeksforgeeks.org/convex-hull-set-1-jarviss-algorithm-or-wrapping/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            int n = sc.nextInt();
            Point[] points = new Point[n];
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                points[j] = new Point(x, y);
            }
            List<Point> res = outerTrees(points);
            if (res.size() < 3) {
                System.out.println(-1);
            } else {
                String str = res.stream()
                        .map(p -> p.x + " " + p.y)
                        .collect(Collectors.joining(", "));
                System.out.println(str);
            }
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int orientation(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }

    private static List<Point> outerTrees(Point[] points) {
        Arrays.sort(points, (p, q) -> q.x - p.x == 0 ? q.y - p.y : q.x - p.x);
        Stack<Point> hull = new Stack<>();
        for (int i = 0; i < points.length; i++) {
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) > 0)
                hull.pop();
            hull.push(points[i]);
        }
        hull.pop();
        for (int i = points.length - 1; i >= 0; i--) {
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), points[i]) > 0)
                hull.pop();
            hull.push(points[i]);
        }
        List<Point> res = new ArrayList<>(new HashSet<>(hull));
        res.sort((p1, p2) -> {
            if (p1.x == p2.x) {
                return p1.y - p2.y;
            }
            return p1.x - p2.x;
        });
        return res;
    }

}