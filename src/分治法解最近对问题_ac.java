import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 分治法解最近对问题_ac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < T; i++) {
            String[] split = scanner.nextLine().split(",");
            float[][] points = new float[split.length][2];
            for (int j = 0; j < split.length; j++) {
                String[] s = split[j].split(" ");
                points[j][0] = Float.parseFloat(s[0]);
                points[j][1] = Float.parseFloat(s[1]);
            }
            List<List<Float>> dis = new ArrayList<>();
            for (int j = 0; j < split.length; j++) {
                for (int k = j + 1; k < split.length; k++) {
                    List<Float> tmp = new ArrayList<>();
                    double distance = Math.sqrt(Math.pow(points[k][0] - points[j][0], 2) + Math.pow(points[k][1] - points[j][1], 2));
                    tmp.add((float) distance);
                    List<List<Float>> two = new ArrayList<>();
                    List<Float> a = new ArrayList<>();
                    a.add(points[j][0]);
                    a.add(points[j][1]);
                    two.add(a);
                    List<Float> p = new ArrayList<>();
                    p.add(points[k][0]);
                    p.add(points[k][1]);
                    two.add(p);
                    two.sort((o1, o2) -> {
                        if (o1.get(0).equals(o2.get(0))) {
                            return compare(o1.get(1), o2.get(1));
                        } else {
                            return compare(o1.get(0), o2.get(0));
                        }
                    });

                    for (List<Float> floats : two) {
                        tmp.addAll(floats);
                    }
                    dis.add(tmp);
                }
            }
            dis.sort((o1, o2) -> compare(o1.get(0), o2.get(0)));
            List<List<Float>> re = new ArrayList<>();
            Float aFloat = dis.get(0).get(0);
            for (int j = 0; j < dis.size(); j++) {
                if (dis.get(j).get(0).equals(aFloat)) {
                    List<Float> po = dis.get(j);
                    po.remove(aFloat);
                    re.add(po);
                }
            }
            for (int j = 0; j < re.size() - 1; j++) {
                String s = re.get(j).get(0) + " " + re.get(j).get(1) + "," + re.get(j).get(2) + " " + re.get(j).get(3) + ",";
                System.out.print(s.replaceAll(".0",""));
            }
            String s = re.get(re.size() - 1).get(0) + " " + re.get(re.size() - 1).get(1) + "," + re.get(re.size() - 1).get(2) + " " + re.get(re.size() - 1).get(3);
            System.out.println(s.replaceAll(".0",""));
        }
    }

    private static int compare(Float a, Float b) {
        if (a < b) {
            return -1;
        } else {
            return 1;
        }
    }
}