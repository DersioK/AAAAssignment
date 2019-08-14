import java.util.*;
public class Main{

    public static int[][]adjMatrix(int n){
        int[][] matrix = new int[n][n];
        for(int i=0;i<matrix.length;i++){
           // System.out.println();
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j] =0;
                // matrix[j][i] =0;
              // System.out.print(matrix[i][j]);
            }
        }
        //System.out.println();
        return matrix;
    }
    public static List<Element>distance(ArrayList<sample_points>points) {
        int k=0,n;
        double dist = 0;
        double z = 2;
        points.get(2);
       // Map<sample_points,Double>distances = new HashMap();
        ArrayList<Double> distances = new ArrayList<Double>();
        List<Element> elements = new ArrayList<Element>();
        for (int i = 0; i <= points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                dist = Math.sqrt((Math.pow(points.get(i).getX() - points.get(j).getX(),2)) + Math.pow(points.get(i).getY() - points.get(j).getY(),2));
                sample_points neighbour = new sample_points();
                neighbour.setX(points.get(i+1).getX());
                neighbour.setY(points.get(i+1).getY());
                distances.add(dist);
            }
        }
        for (int i = 0; i < distances.size(); i++) {
            elements.add(new Element(i, distances.get(i)));
        }
        Collections.sort(elements);
        List<Element> newList = new ArrayList(elements.subList(0,k));
        return elements;
    }

    public static int[][] mapArrays(ArrayList <Integer> X, ArrayList <Integer> Y) { //this method takes in x_cords and y_cordd
        int[][]points=new int[X.size()][2]; //initialising 2d array where x.size is the number of sample points and "2" is how many elements a single point has
        for(int i = 0;i <X.size();i++){
           points[i][0] =X.get(i); //the first element in index i is your x coordinate
            points[i][1] =Y.get(i); // the second element in index i is your y coordinate
        }
        return points;
    }
    public static void main(String[] args){

        String s,g,r;
        String spaces[];
        String co_ord[];
        String co_ord2[];

        int k,p,n,d;

        ArrayList <Integer> y_cords = new ArrayList<Integer>();
        ArrayList <Integer> x_cords = new ArrayList<Integer>();
        ArrayList <Integer> x_start = new ArrayList<Integer>();
        ArrayList <Integer> y_start = new ArrayList<Integer>();
        ArrayList <Integer> x_obs = new ArrayList<Integer>();
        ArrayList <Integer> y_obs = new ArrayList<Integer>();
        ArrayList <Integer> z = new ArrayList<Integer>();
        ArrayList <Integer> x = new ArrayList<Integer>();
        ArrayList <start_end_points> samplePoints2 = new ArrayList<start_end_points>();
        ArrayList <obstacle_points> obstacles = new ArrayList<obstacle_points>();
        ArrayList <sample_points> samplePoints= new ArrayList<sample_points>();

       // sample_points newPoint =  new sample_points();

        Scanner in = new Scanner(System.in);

        s = in.nextLine(); //input a string using scanner all in one line

        spaces = s.split(" "); // spaces is a string array whose element we're inputting by splitting by a space


        int [] q = new int[spaces.length]; //initial size of array is spaces.length

        for(int i=0;i<spaces.length;i++){
            q[i]=Integer.parseInt(spaces[i]); // converts our inputed strings to numbers
        }

        k = q[0]; //beginning of the main things we need to store#store
        p = q[1]; //number of obstacles
        n = q[2]; //number of sample points

        Scanner start = new Scanner(System.in); // create a new scanner for our sample points
        int count =1;
        while(start.hasNextLine()) {
            r = start.nextLine();
            if (count < 2) {
                co_ord2 = r.split(",");
                for (int i = 0; i < co_ord2.length; i++) {
                    x.add(Integer.parseInt(co_ord2[i]));
                }
                count++;
            } else {
                break;
            }
        }

        for (int i = 0; i < z.size(); i = i + 2) {
            x_start.add(x.get(i));
        }
        //similarly for y but we start at 1
        for (int j = 1; j < z.size(); j = j + 2) {
            y_start.add(x.get(j));
        }

        for(int i=0;i<x_start.size();i++) {
            start_end_points newPoint = new start_end_points();
            newPoint.setX(x_start.get(i));
            newPoint.setY(y_start.get(i));
            samplePoints2.add(newPoint);
        }

        Scanner e = new Scanner(System.in); // create a new scanner for our sample points
        int counter =1;
        while(e.hasNextLine()) {
            g = e.nextLine();
            if(counter < n) {
                co_ord = g.split(","); // splitting the sample points by a comma and storing it in the string array co_ord
                for (int i = 0; i < co_ord.length; i++) {
                     z.add(Integer.parseInt(co_ord[i]));// then convert elements in co_ord to integers and then store in arraylist z
                }
                counter++;
            }
            else{
                break;
            }
        }
        //we want add every other element (i.e x coordinates of sample points) to x_cords Arraylist so we increment by  2 and start at 0
       // sample_points newPoint = new sample_points();
        for (int i = 0; i < z.size(); i = i + 2) {
            x_cords.add(z.get(i));
        }
            //similarly for y but we start at 1
            for (int j = 1; j < z.size(); j = j + 2) {
                y_cords.add(z.get(j));
            }

        for(int i=0;i<x_cords.size();i++) {
                sample_points newPoint = new sample_points();
                newPoint.setX(x_cords.get(i));
                newPoint.setY(y_cords.get(i));
                samplePoints.add(newPoint);
        }
        //ending of the main things we need to store#store
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

