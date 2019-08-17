import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class methods {

    public static int[][] adjMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
                matrix[j][i] =0;
                System.out.print(matrix[i][j]);
            }
        }
        //System.out.println();
        return matrix;
    }

    public static int[][] distance(ArrayList<sample_points> points,int k,int adjMatrixSize) {

        ArrayList<ArrayList<Double>> distArray = new ArrayList<ArrayList<Double>>(points.size());
        double dist = 0;

        List<Element> elements = new ArrayList<Element>();

        for (int i = 0; i<points.size()-1; i++) {
            ArrayList<Double> distances = new ArrayList<Double>();
            //ArrayList<Double> distances = new ArrayList<>();  // convenience, you don't need the first loop only to populate the distArray lists
            for(int j=i+1; j<points.size(); j++){
                dist = Math.sqrt(
                        Math.pow(points.get(i).getX() - points.get(j).getX(), 2)
                                + Math.pow(points.get(i).getY() - points.get(j).getY(), 2)
                );   // do your calculations here
                distances.add(dist);   // add the distance to the current distances list
            }
            distArray.add(distances);// add the current distances list to the result list
        }

        for (int i = 0; i < distArray.size(); i++) {
            for (int j = 0; j < distArray.get(i).size(); j++) {
                elements.add(new Element(j, distArray.get(i).get(j)));
            }
        }
        Collections.sort(elements);
        List<Element> newList = new ArrayList(elements.subList(0, k));

        int[][] matrix = new int[adjMatrixSize][adjMatrixSize];
        for (int i = 0; i < distArray.size(); i++) {
             System.out.println();
            for (int j = 0; j < distArray.get(i).size(); j++) {
                matrix[i][j] = 1;
                matrix[j][i] =1;
                System.out.print(matrix[i][j]);
            }
        }

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
}
































