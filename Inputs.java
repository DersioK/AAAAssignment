package com.company;

import java.util.*;

public class Inputs
{
    public static void inputs()
    {
        //Variables:

        String firstFourInputs, samplePointsInputs, startEndPointsInputs, obstaclePointsInputs;
        String[] spaces;
        String[] samplePointsCoords;
        String[] obsPointsCoords;

        int numNeighbours, numObstacles, numSamplePoints, graphDimensions;

        int[] firstFourInputsArray;

        ArrayList<Integer> y_cords = new ArrayList<Integer>();
        ArrayList<Integer> x_cords = new ArrayList<Integer>();
        ArrayList<Integer> x_obs = new ArrayList<Integer>();
        ArrayList<Integer> y_obs = new ArrayList<Integer>();
        ArrayList<Integer> convertedCoords = new ArrayList<Integer>();
        ArrayList<Integer> convertedObsCoords = new ArrayList<Integer>();

        ArrayList<obstacle_points> obstacles = new ArrayList<obstacle_points>();
        ArrayList<sample_points> samplePoints = new ArrayList<sample_points>();

        // User Inputs and Handling:

        // 1) first line i.e our four parameters' scanning & handling:

        Scanner inputs = new Scanner(System.in);
        firstFourInputs = inputs.nextLine();
        spaces = firstFourInputs.split(" ");
        firstFourInputsArray = new int[spaces.length];
        for(int i=0;i<spaces.length;i++){
            firstFourInputsArray[i]=Integer.parseInt(spaces[i]); // converts our inputted strings to numbers
        }
        numNeighbours = firstFourInputsArray[0];
        numObstacles = firstFourInputsArray[1];
        numSamplePoints = firstFourInputsArray[2];
        graphDimensions = firstFourInputsArray[3];

        // 2) our start and end points' scanning & handling:

        int count = 0;

        while (count < 2)
        {
            startEndPointsInputs = inputs.nextLine(); //tells scanner to go to next line
            samplePointsCoords = startEndPointsInputs.split(",");
            for (int i = 0; i < samplePointsCoords.length; i++)
            {
                convertedCoords.add(Integer.parseInt(samplePointsCoords[i]));
            }
            count++;
        }


        for (int i = 0; i < convertedCoords.size(); i = i + 2) { //add every other element i.e x coords of sample points
            x_cords.add(convertedCoords.get(i));
        }
        for (int j = 1; j < convertedCoords.size(); j = j + 2) { //similarly for y coords but we start at 1
            y_cords.add(convertedCoords.get(j));
        }
        for (int i = 0; i < x_cords.size(); i++) {
            sample_points newSamplePoint = new sample_points();
            newSamplePoint.setX(x_cords.get(i));
            newSamplePoint.setY(y_cords.get(i));
            samplePoints.add(newSamplePoint);
        }

        System.out.println("start point x coord: " + samplePoints.get(0).getX() + " & start point y coord: " + samplePoints.get(0).getY());
        System.out.println("end point  x coord: " + samplePoints.get(1).getX() + " & end point y coord: " + samplePoints.get(1).getY());

//      System.out.println("Good breakpoint for start and end points input and check");


        // 3) our obstacles' scanning & handling:

        int obsCount = 0;

        while (obsCount < numObstacles)
        {
                obstaclePointsInputs = inputs.nextLine();
                obsPointsCoords = obstaclePointsInputs.split(",|;");
                for (int i = 0; i < obsPointsCoords.length; i++)
                {
                    convertedObsCoords.add(Integer.parseInt(obsPointsCoords[i]));
                }
                obsCount++;
        }

        for (int i = 0; i < convertedObsCoords.size(); i = i + 2) {
            x_obs.add(convertedObsCoords.get(i));
        }
        for (int j = 1; j < convertedObsCoords.size(); j = j + 2) { //similarly for y but we start at 1
            y_obs.add(convertedObsCoords.get(j));
        }
        for (int i = 0; i < x_obs.size(); i++) {
            obstacle_points newPoint = new obstacle_points();
            newPoint.setX(x_obs.get(i));
            newPoint.setY(y_obs.get(i));
            obstacles.add(newPoint);
        }

        System.out.println("first obstacle top left x coord: " + obstacles.get(0).getX() + " & first obstacle top left y coord: " + obstacles.get(0).getY());
        System.out.println("first obstacle bottom right x coord: " + obstacles.get(1).getX() + " & first obstacle bottom right y coord: " + obstacles.get(1).getY());
        System.out.println();
        System.out.println("second obstacle top left x coord: " + obstacles.get(2).getX() + " & second obstacle top left y coord: " + obstacles.get(2).getY());
        System.out.println("second obstacle bottom right x coord: " + obstacles.get(3).getX() + " & second obstacle bottom right y coord: " + obstacles.get(3).getY());

//      System.out.println("Good breakpoint for obstacles input and check");

        // 4) sample points scanning & handling:





    }
}
