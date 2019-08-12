import java.util.*;
public class Main{

    public static int[][]adjMatrix(int n){
        int[][] matrix = new int[n][n];
        for(int i=0;i<matrix.length;i++){
            System.out.println();
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j] =0;
                // matrix[j][i] =0;
                System.out.print(matrix[i][j]);
            }
        }
        System.out.println();
        return matrix;
    }
    public static double distance(int [][] points){
        double dist=0;
        double z = 2;
        ArrayList <Double>distances = new ArrayList<Double>();
        for(int i =0;i<=points.length;i++) {
            for (int j = i + 1; j < points.length; j++){
                dist = Math.sqrt((Math.pow(points[i][0] - points[j][0], 2)) + Math.pow(points[i][1] - points[j][1], 2));
            distances.add(dist);
         }
        }
        return dist;
    }
    public static double[] findk(int [][]points,int k){
        double [] distances  = new double [k];
        int [] closest_nodes = new int[k];
        double dist=Double.POSITIVE_INFINITY;
        for(int i=0;i<k;i++){
            distances[i] = Double.POSITIVE_INFINITY;
            closest_nodes[i] = -1;
        }
        for(int i=0;i<=points.length;i++){
            for(int j =i+1;j<distances.length;j++) {
                dist = distance(points);
                distances[i] = dist;
            }
        }
        for (int i=0;i<distances.length;i++){
            System.out.println(distances[i]);
        }
        return distances;
    }
    public static int[][] mapArrays(ArrayList <Integer> X, ArrayList <Integer> Y) {
        int[][]points=new int[X.size()][2];
        for(int i = 0;i <X.size();i++){
           points[i][0] =X.get(i);
            points[i][1] =Y.get(i);
        }
        return points;
    }
    public static void main(String[] args){
        String s,g;
        String spaces[];
        String co_ord[];
        String co_ord2[];
        int k,p,n,d;
        ArrayList <Integer> y_cords = new ArrayList<Integer>();
        ArrayList <Integer> x_cords = new ArrayList<Integer>();
        ArrayList <Integer> z = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        spaces = s.split(" ");
        int [] q =new int[spaces.length];
        for(int i=0;i<spaces.length;i++){
            q[i]=Integer.parseInt(spaces[i]);
        }
        k = q[0];
        p = q[1];
        n = q[2];
       // adjMatrix(q[3]);
        Scanner e = new Scanner(System.in);
        while(e.hasNextLine()) {
            g = e.nextLine();
            if(!g.equalsIgnoreCase("end")) {
                co_ord = g.split(",");
                for (int i = 0; i < co_ord.length; i++) {
                     z.add(Integer.parseInt(co_ord[i]));
                }
            }
            else{break;}
        }
        for (int i = 0; i < z.size(); i = i + 2) {
            x_cords.add(z.get(i));
        }
        for (int i = 1; i < z.size(); i = i + 2) {
            y_cords.add(z.get(i));
        }
//        System.out.print("X: "+ x_cords);
//        System.out.println();
//        System.out.print("Y "+y_cords);
//        System.out.println();
//        distance(x_cords,y_cords);
        findk(mapArrays(x_cords,y_cords),3);
       // Pair dist[] = new Pair[n];
        }
   }

class Pair implements Comparable<Pair>{
    public final int index;
    public final double distance;

    public Pair(int index, double distance){
        this.index = index;
        this.distance = distance;
    }
   @Override
    public int compareTo(Pair pair) {
        return Double.valueOf(this.distance).compareTo(Double.valueOf(pair.distance));
    }
}import java.util.*;
public class knn{
  public static int[][]adjMatrix(int n){
        int[][] matrix = new int[n][n];
        for(int i=0;i<matrix.length;i++){
            System.out.println();
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j] =0;
                // matrix[j][i] =0;
                System.out.print(matrix[i][j]);
            }
        }
        System.out.println();
        return matrix;
    }
    public static double distance(int [][] points){
        double dist=0;
        double z = 2;
        ArrayList <Double>distances = new ArrayList<Double>();
        for(int i =0;i<=points.length;i++) {
            for (int j = i + 1; j < points.length; j++){
                dist = Math.sqrt((Math.pow(points[i][0] - points[j][0], 2)) + Math.pow(points[i][1] - points[j][1], 2));
            distances.add(dist);
        }
     }
     return dist;
    }
    public static int[][] mapArrays(ArrayList <Integer> X, ArrayList <Integer> Y) {
        int[][]points=new int[X.size()][2];
        for(int i = 0;i <X.size();i++){
           points[i][0] =X.get(i);
            points[i][1] =Y.get(i);
        }
        return points;
    }
    public static void main(String[] args){
        String s,g;
        String spaces[];
        String co_ord[];
        String co_ord2[];
        int k,p,n,d;
        ArrayList <Integer> y_cords = new ArrayList<Integer>();
        ArrayList <Integer> x_cords = new ArrayList<Integer>();
        ArrayList <Integer> z = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        spaces = s.split(" ");
        int [] q =new int[spaces.length];
        for(int i=0;i<spaces.length;i++){
            q[i]=Integer.parseInt(spaces[i]);
        }
        k = q[0];
        p = q[1];
        n = q[2];
       // adjMatrix(q[3]);
        Scanner e = new Scanner(System.in);
        while(e.hasNextLine()) {
            g = e.nextLine();
            if(!g.equalsIgnoreCase("end")) {
                co_ord = g.split(",");
                for (int i = 0; i < co_ord.length; i++) {
                     z.add(Integer.parseInt(co_ord[i]));
                }
            }
            else{break;}
        }
        for (int i = 0; i < z.size(); i = i + 2) {
            x_cords.add(z.get(i));
        }
        for (int i = 1; i < z.size(); i = i + 2) {
            y_cords.add(z.get(i));
        }
         distance(mapArrays(x_cords,y_cords));
        }
   }

