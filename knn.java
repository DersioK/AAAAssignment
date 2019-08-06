import java.util.*;
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
        return null;
    }
    //Still wokring on this
    public static double distance(ArrayList <Integer> X, ArrayList <Integer> Y){
        double  dist=0;
        double z = 2;
        for(int i =0;i<X.size();i++){
            dist  = (int)(Math.sqrt((Math.pow(Y.get(i)-X.get(i),2))+Math.pow(Y.get(i+1)-X.get(i+1),2)));
            System.out.println(dist);
        }
        return dist;
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
        adjMatrix(q[3]);
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
        System.out.print("X: "+ x_cords);
        System.out.println();
        System.out.print("Y "+y_cords);
        System.out.println();
        distance(x_cords,y_cords);
        }
    }
