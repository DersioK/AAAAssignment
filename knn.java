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
    public static void main(String[] args){
        String s,g;
        String spaces[];
        String co_ord[];
        String co_ord2[];
        int k,p,n,d;
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
        while(e.hasNextLine()){
            g = e.nextLine();
        if(!(g.equals("Exit"))){
        co_ord2= g.split(";");
        co_ord = g.split(",");
       
        int [] z =new int[co_ord.length];
        for(int i=0;i<co_ord.length;i++){
          z[i]=Integer.parseInt(co_ord[i]);
        }

        int [] x_cords =new int[z.length];
        for(int i=0;i<z.length;i=i+2){
           x_cords[i]=z[i];
          // System.out.print("X coordinates: "+x_cords[i]);
        }
        int [] y_cords =new int[z.length];
        for(int i=1;i<z.length;i=i+2){
            y_cords[i]=z[i];
            
        }
        for(int i=0;i<x_cords.length;i++){
            System.out.print("X coordinates: "+x_cords[i]);
        }
        System.out.println();
        for(int i=0;i<y_cords.length;i++){
            System.out.print("Y coordinates: "+y_cords[i]);
        }
    }
  }
 }
}