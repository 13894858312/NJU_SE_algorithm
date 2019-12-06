import java.util.*;

/**
 * Created by wangxue on 2019/11/23.
 */
//自己写的，不准
public class Kd树构造和查找 {

    private static boolean isInt;
    private static int k;

    private static double maxDis2;
    private static Node maxNode;
    private static Map<Node, Double> result;

    private static Stack<Node> stack;

    static class Node{
        Node left;
        Node right;
        Node parent;
        int wei;
        double[] d;
        Node(double[] doubles, int wei){
            this.d = doubles;
        }

        @Override
        public String toString() {
            if(isInt){
                int x =(int) this.d[0];
                int y =(int) this.d[1];
                return x+" "+y;
            }else {
                return this.d[0] + " " + this.d[1];
            }
        }

        boolean leftNull(){
            return this.left==null;
        }

        boolean rightNull(){
            return this.right==null;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-->0){
            scanner.nextLine();
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();

            String[] sp1 = s1.split(",");
            isInt = sp1[0].split(" ")[0].matches("^-?[0-9]\\d*$");
            ArrayList<double[]> arrayList = new ArrayList<>();
            for(String s : sp1){
                String[] sp3 = s.split(" ");
                double x = Double.parseDouble(sp3[0]);
                double y = Double.parseDouble(sp3[1]);
                arrayList.add(new double[]{x,y});
            }

            String[] sp2 = s2.split(" ");
            double search_x = Double.parseDouble(sp2[0]);
            double search_y = Double.parseDouble(sp2[1]);
            double[] search = new double[]{search_x, search_y};

            k = scanner.nextInt();

            Node gen = build(arrayList, null);

            maxDis2 = -1;
            maxNode = null;
            result = new HashMap<>();
            newSearch(gen, search);
            final ArrayList<Node> output = new ArrayList<>();
            result.entrySet().stream().sorted((o1, o2) -> Double.compare(o1.getValue(), o2.getValue())).forEach(x-> output.add(x.getKey()));
            for(int i = 0 ; i < output.size() ; i++){
                if(i == output.size()-1){
                    System.out.println(output.get(i));
                }else {
                    System.out.print(output.get(i) + ",");
                }
            }


        }

    }

    private static Node build(List<double[]> arrayList, Node parent){
        int n = arrayList.size();
        if(n == 0){
            return null;
        }
        if(n == 1){
            Node node = new Node(arrayList.get(0), 0);
            node.parent = parent;
            return node;
        }

        double max_fangcha = -1;
        int lie = -1;
        for(int i = 0 ; i < 2 ; i++){
            int sum = 0;
            for(double[] dui: arrayList){
                sum+=dui[i];
            }
            double ave = sum/n;
            double fangcha = 0;
            for(double[] dui: arrayList){
                fangcha+= Math.pow( (dui[i] - ave) , 2);
            }

            if(fangcha > max_fangcha){
                lie = i;
                max_fangcha = fangcha;
            }
        }

        final int wei = lie;
        arrayList.sort((o1, o2) -> Double.compare(o1[wei], o2[wei]));

        int split = n/2-1;
        double[] now = arrayList.get(split);
        Node node = new Node(now, wei);

        node.parent = parent;
        node.left = build(arrayList.subList(0, split), node);
        node.right = build(arrayList.subList(split+1, n), node);

        return node;
    }

    private static double julidepingfang(double[] p1, double[] p2){
        return Math.pow(p1[0]-p2[0], 2) + Math.pow(p1[1]-p2[1], 2);
    }

    private static void newSearch(Node node, double[] search){

        if(node == null){
            return;
        }
        int wei = node.wei;
        if(search[wei] > node.d[wei]){
            newSearch(node.right, search);
        }
        if(search[wei] < node.d[wei]){
            newSearch(node.left, search);
        }
        double dis2 = julidepingfang(node.d, search);
        if(result.size() == 0){
            maxDis2 = dis2;
            maxNode = node;
        }
        if(result.size() < k){
            if(dis2 > maxDis2){
                maxDis2 = dis2;
                maxNode = node;
            }
            result.put(node, dis2);
        }else {
            if (dis2 < maxDis2) {
                result.remove(maxNode);
                result.put(node, dis2);

                maxDis2 = -1;
                maxNode = null;
                for (Map.Entry<Node, Double> entry : result.entrySet()) {
                    if (entry.getValue() > maxDis2) {
                        maxDis2 = entry.getValue();
                        maxNode = entry.getKey();
                    }
                }
            }
        }

        if(!node.rightNull() || !node.leftNull()){
            if(Math.pow(search[wei] - node.d[wei], 2) < maxDis2){
                if(search[wei] < node.d[wei]){
                    newSearch(node.right, search);
                }
                if(search[wei] > node.d[wei]){
                    newSearch(node.left, search);
                }
            }
        }
    }

}
