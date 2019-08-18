import java.util.*;
public class input {

    public static void inputs() {
        String firstFourInputs, samplePointsInputs ,startEndPointsInputs,obstaclePointsInputs;

        String spaces[];
        String samplePointsCoords[];
        String obsPointsCoords[];
        String s[];
        int[] firstFourInputsArray;

        int numNeighbours, numObstacles, numSamplePoints, graphDimensions;

        ArrayList<Integer> y_cords = new ArrayList<Integer>();
        ArrayList<Integer> x_cords = new ArrayList<Integer>();
        ArrayList<Integer> x_obs = new ArrayList<Integer>();
        ArrayList<Integer> y_obs = new ArrayList<Integer>();
        ArrayList<Integer> convertedCoords = new ArrayList<Integer>();
        ArrayList<Integer> convertedObsCoords = new ArrayList<Integer>();

        ArrayList<obstacle_points> obstacles = new ArrayList<obstacle_points>();
        ArrayList<sample_points> samplePoints = new ArrayList<sample_points>();

        Scanner inputs = new Scanner(System.in);

        firstFourInputs = inputs.nextLine(); //input a string using scanner all in one line

        spaces = firstFourInputs.split(" "); // spaces is a string array whose element we're inputting by splitting by a space


        firstFourInputsArray = new int[spaces.length]; //initial size of array is spaces.length

        for (int i = 0; i < spaces.length; i++) {
            firstFourInputsArray[i] = Integer.parseInt(spaces[i]); // converts our inputted strings to numbers
        }

        numNeighbours =firstFourInputsArray[0]; //beginning of the main things we need to store#store
        numObstacles = firstFourInputsArray[1]; //number of obstacles
        numSamplePoints = firstFourInputsArray[2]; //number of sample points
        graphDimensions =firstFourInputsArray[3];

       // Scanner startEndLineScan = new Scanner(System.in); // create a new scanner for our sample points
        int count = 0;

        while(count < 2) {
            startEndPointsInputs = inputs.nextLine();
            samplePointsCoords = startEndPointsInputs.split(",");
            for (int i = 0; i < samplePointsCoords.length; ++i) {
                    convertedCoords.add(Integer.parseInt(samplePointsCoords[i]));

                    //System.out.print("count "+ count+" "+"i: "+i);
                }
                count++;
            }
        //System.out.print(convertedCoords.size());
        for (int i = 0; i < convertedCoords.size(); i = i + 2) {
            x_cords.add(convertedCoords.get(i));
        }
        //similarly for y but we start at 1
        for (int j = 1; j < convertedCoords.size(); j = j + 2) {
            y_cords.add(convertedCoords.get(j));
        }

        for (int i = 0; i < x_cords.size(); i++) {
            sample_points newSamplePoint = new sample_points();
            newSamplePoint.setX(x_cords.get(i));
            newSamplePoint.setY(y_cords.get(i));
            samplePoints.add(newSamplePoint);
        }
        //System.out.print(convertedCoords);
        //System.out.println();
       // Scanner obstaclePointsScan = new Scanner(System.in); // create a new scanner for our sample points
        int obsCount = 0;

        while (obsCount<numObstacles) {

            obstaclePointsInputs = inputs.nextLine();

                obsPointsCoords = obstaclePointsInputs.split(",|\\;");

                for (int i = 0; i < obsPointsCoords.length; i++) {
                    convertedObsCoords.add(Integer.parseInt(obsPointsCoords[i]));
                }
                obsCount++;
        }

        for (int i = 0; i < convertedObsCoords.size(); i = i + 2) {
            x_obs.add(convertedObsCoords.get(i));
        }
        //similarly for y but we start at 1
        for (int j = 1; j < convertedObsCoords.size(); j = j + 2) {
            y_obs.add(convertedObsCoords.get(j));
        }

        for (int i = 0; i < x_obs.size(); i++) {
            obstacle_points newPoint = new obstacle_points();
            newPoint.setX(x_obs.get(i));
            newPoint.setY(y_obs.get(i));
            obstacles.add(newPoint);
        }
      //  System.out.println("Coordinates "+ convertedObsCoords);

       // Scanner fourthLineScan = new Scanner(System.in); // create a new scanner for our sample points
        int counter = 0;
        while (counter < numSamplePoints) {
            samplePointsInputs = inputs.nextLine();
            samplePointsCoords= samplePointsInputs.split(","); // splitting the sample points by a comma and storing it in the string array co_ord
                for (int i = 0; i < samplePointsCoords.length; i++) {
                    convertedCoords.add(Integer.parseInt(samplePointsCoords[i]));// then convert elements in co_ord to integers and then store in arraylist z
                }
                counter++;
            }

        //we want add every other element (i.e x coordinates of sample points) to x_cords Arraylist so we increment by  2 and start at 0
        // sample_points newPoint = new sample_points();
        for (int i = 4; i < convertedCoords.size(); i = i + 2) {
            x_cords.add(convertedCoords.get(i));
        }
        //similarly for y but we start at 1
        for (int j = 5; j < convertedCoords.size(); j = j + 2) {
            y_cords.add(convertedCoords.get(j));
        }

        for (int i = 2; i < x_cords.size(); i++) {
            sample_points newPoint = new sample_points();
            newPoint.setX(x_cords.get(i));
            newPoint.setY(y_cords.get(i));
            samplePoints.add(newPoint);
        }
        //ending of the main things we need to store#store
        methods test = new methods();
        test.distance(test.removeCollisions(samplePoints,obstacles),numNeighbours,numSamplePoints);
        //test.distance(test.removeCollisions(samplePoints,obstacles));
      //  System.out.print("Breakpoint");
    }
}






























