import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Line2D;
public class methods {

//    public static int[][] adjMatrix(int n) {
//        int[][] matrix = new int[n][n];
//        for (int i = 0; i < matrix.length; i++) {
//            System.out.println();
//            for (int j = 0; j < matrix[i].length; j++) {
//                matrix[i][j] = 0;
//                matrix[j][i] =0;
//                System.out.print(matrix[i][j]);
//            }
//        }
//        //System.out.println();
//        return matrix;
//    }

    public static int[][] distance(ArrayList<sample_points> points,int k,int adjMatrixSize) {

        List<List<Element>> distArray = new ArrayList<List<Element>>();
        //List<List<Element>> distArray2 = new ArrayList<List<Element>>();//List<Element>();//List<Element>>(points.size());
        double dist = 0;


        List<Element> elements = new ArrayList<Element>();
        for (int i = 0; i<points.size()-1; i++) {

            //ArrayList<Double> distances = new ArrayList<Double>();
            //ArrayList<Double> distances = new ArrayList<>();  // convenience, you don't need the first loop only to populate the distArray lists
            for(int j=i+1; j<points.size(); j++){
                dist = Math.sqrt(
                        Math.pow(points.get(i).getX() - points.get(j).getX(), 2)
                                + Math.pow(points.get(i).getY() - points.get(j).getY(), 2)
                );   // do your calculations here
                //distances.add(dist);   // add the distance to the current distances list
                elements.add(new Element(j, dist));
            }
            distArray.add(elements);// add the current distances list to the result list
        }
        Collections.sort(elements);
       // List<Element> newList = new ArrayList(elements.subList(0, k));
       // System.out.print(newList);
        int[][] matrix = new int[adjMatrixSize][adjMatrixSize];
        for (int i = 0; i < distArray.size(); i++) {
            List<Element> newList = new ArrayList(elements.subList(0, k));
            System.out.println();
            for (int j = 0; j < distArray.get(i).size(); j++) {
                matrix[i][j]=0;
                matrix[j][i]=0;
                matrix[distArray.indexOf(distArray.get(i))][newList.get(j).index] = 1;
                matrix[newList.get(j).index] [distArray.indexOf(distArray.get(i))]= 1;
                System.out.print(matrix[i][j]);
                System.out.print(matrix[distArray.indexOf(distArray.get(i))][newList.get(j).index]);
            }
        }
        System.out.println();

        return matrix;
    }

    public static ArrayList<sample_points> removeCollisions(ArrayList<sample_points>samplePoints,ArrayList<obstacle_points>obstaclePoints) {
        ArrayList<sample_points> resultingList = new ArrayList<sample_points>();
        for (int i = 0; i < samplePoints.size(); i++) {
            for (int j = 0; j < obstaclePoints.size(); j++) {
                if (samplePoints.get(i).getX() == obstaclePoints.get(j).getX() && samplePoints.get(i).getY() == obstaclePoints.get(j).getY() && onSegment(obstaclePoints,samplePoints)==true) {
                    samplePoints.remove(i);
                }
            }
        }
        for (int j = 0; j < samplePoints.size(); j++) {
            resultingList.add(samplePoints.get(j));
        }
        return resultingList;
    }

    public static boolean onSegment(ArrayList<obstacle_points>obstaclePoints,ArrayList<sample_points>samplePoints){

        for (int i = 0; i < samplePoints.size(); i++) {
            for (int j = 0; j < obstaclePoints.size(); j=j+2) {
                if (samplePoints.get(i).getX() <= Math.max(obstaclePoints.get(j).getX(), obstaclePoints.get(j + 1).getX()) &&
                        samplePoints.get(i).getX() >= Math.min(obstaclePoints.get(j).getX(), obstaclePoints.get(j + 1).getX()) &&
                        samplePoints.get(i).getY() <= Math.max(obstaclePoints.get(j).getY(), obstaclePoints.get(j + 1).getY()) &&
                        samplePoints.get(i).getY() >= Math.min(obstaclePoints.get(j).getY(), obstaclePoints.get(j + 1).getY())) {
                    return true;
                }
            }
        }
                return false;
    }

    public static int orientation(ArrayList<obstacle_points>obstaclePoints,ArrayList<sample_points>samplePoints){
        int val=0;
        for (int i = 0; i < samplePoints.size(); i++) {
            for (int j = 0; j < obstaclePoints.size(); j = j + 2) {
                val = (samplePoints.get(i).getY() - obstaclePoints.get(j).getY()) * (obstaclePoints.get(j + 1).getX() - samplePoints.get(i).getX()) -
                        (samplePoints.get(i).getX() - obstaclePoints.get(j).getX()) * (obstaclePoints.get(j + 1).getY() - samplePoints.get(i).getX());
                if (val == 0) {
                    return 0;
                }
            }
        }
            return (val>0)?1:2;
    }
//    Line2D myLine = getMyLine(); // some imagine method giving your line
//    Point2D[] polyPoints = getPolyPoints(); // some imagine method giving point of your Polygon
//
//    boolean intersect = false;
//    for (int i = 0; i < polyPoints.length - 1; i++) {
//        intersect = myLine.intersectsLine(polyPoints[i].getX(), polyPoints[i].getY(), polyPoints[i+1].getX(), polyPoints[i+1].getY());
//        if (intersect) {
//            break;
//        }
//    }
}
































