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
    public static List<Element>distance(int [][] points) {
        double dist = 0;
        double z = 2;
        ArrayList<Double> distances = new ArrayList<Double>();
        for (int i = 0; i <= points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                dist = Math.sqrt((Math.pow(points[i][0] - points[j][0], 2)) + Math.pow(points[i][1] - points[j][1], 2));
                distances.add(dist);
            }
        }
        List<Element> elements = new ArrayList<Element>();
        for (int i = 0; i < distances.size(); i++) {
            elements.add(new Element(i, distances.get(i)));
        }
        Collections.sort(elements);
        return elements;
    }
        //System.out.print(distances);
        //System.out.println();

//       for(Element element:elements){
//           System.out.println(element.distance + " "+ element.index);
//       }


//    public static List<Element> findK(List<Element>distances,int k){
//        // = new List<Element>();
//
//        for(int i=0;i<k;i++){
//
//        }
//
//    }

    public static int[][] mapArrays(ArrayList <Integer> X, ArrayList <Integer> Y) { //this method takes in x_cords and y_cordd
        int[][]points=new int[X.size()][2]; //initialising 2d array where x.size is the number of sample points and "2" is how many elements a single point has
        for(int i = 0;i <X.size();i++){
           points[i][0] =X.get(i); //the first element in index i is your x coordinate
            points[i][1] =Y.get(i); // the second element in index i is your y coordinate
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

        s = in.nextLine(); //input a string using scanner all in one line

        spaces = s.split(" "); // spaces is a string array whose element we're inputting by splitting by a space


        int [] q = new int[spaces.length]; //initial size of array is spaces.length

        for(int i=0;i<spaces.length;i++){
            q[i]=Integer.parseInt(spaces[i]); // converts our inputed strings to numbers
        }

        k = q[0]; //beginning of the main things we need to store#store
        p = q[1];
        n = q[2]; //to remember where they are in q


        Scanner e = new Scanner(System.in); // create a new scanner for our sample points

        while(e.hasNextLine()) {
            g = e.nextLine();
            if(!g.equalsIgnoreCase("end")) {
                co_ord = g.split(","); // splitting the sample points by a comma and storing it in the string array co_ord
                for (int i = 0; i < co_ord.length; i++) {
                     z.add(Integer.parseInt(co_ord[i]));// then convert elements in co_ord to integers and then store in arraylist z
                }
            }
            else{break;}
        }
        for (int i = 0; i < z.size(); i = i + 2) { //we want add every other element (i.e x coordinates of sample points) to x_cords Arraylist so we increment by  2 and start at 0
            x_cords.add(z.get(i));
        }
        for (int i = 1; i < z.size(); i = i + 2) { //similarly for y but we start at 1
            y_cords.add(z.get(i));
        }                                           //ending of the main things we need to store#store
//        System.out.print("X: "+ x_cords);
//        System.out.println();
//        System.out.print("Y "+y_cords);
//        System.out.println();
//        distance(x_cords,y_cords);
        distance(mapArrays(x_cords,y_cords));
       // Pair dist[] = new Pair[n];
        }
   }

class Element implements  Comparable<Element> {
    public final int index;
    public final double distance;

    public Element(int index, double distance){
        this.index = index;
        this.distance = distance;
    }
    @Override
    public int compareTo(Element e){
        return Double.valueOf(this.distance).compareTo(Double.valueOf(e.distance));
    }
}



//        double [] distances  = new double [k];
//        int [] closest_nodes = new int[k];
//        double dist=Double.POSITIVE_INFINITY;
//        for(int i=0;i<k;i++){
//            distances[i] = Double.POSITIVE_INFINITY;
//            closest_nodes[i] = -1;
//        }
////        for(int i=0;i<=points.length;i++){
////            for(int j =i+1;j<distances.length;j++) {
////                if (distance(points) < dist) {
////                    dist = distance(points);
////                    distances[i] = dist;
////                }
////            }
////        }
//        for (int i=0;i<distances.length;i++){
//            System.out.println(distances[i]);
//        }
//        return distances;
