/**
 * File : BasheminGarageTester.java
 *
 * A tester class that takes an input file of
 * cars with licenses and actions and simulates
 * the movement in the garage.
 * It displays if the car has arrived or left
 * and how many times it had to be temporarily moved along with
 * the way the garage looks at each step.
 *
 * I affirm that this program is entirely my own work and none of it is the work of any other person.
 * Created by @AlinaLebron on 2/9/15.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BasheminGarageTester {

    public static void main(String[] args) throws IOException {
        /*
         * Creates an empty garage named "Bashemin"
         */

        Garage bashemin = new Garage();

        int lines = 0; // initializes a variable to count the lines in the file (for the temp array)

        /*
         * Creates a scanner to read the original file to set up an initial array
         *
         */

        Scanner garageScannerCounter = new Scanner(new File("garage.txt"));

        while (garageScannerCounter.hasNextLine()) // Reads till EOF
        {

            garageScannerCounter.nextLine();

            lines++; // increments how many lines exist in the original file
        }


        Car[] tempCars = new Car[lines]; // temporary array

        /*
         * Creates another scanner object to read the file again
         * and store all cars uniquely to a temporary array
         */

        Scanner garageScanner = new Scanner(new File("garage.txt"));

        int lastIndex = 0; // a variable to keep track of the last index

        while (garageScanner.hasNext()) {
            String license = garageScanner.next(); // stores license

            garageScanner.next(); // skips over action

            for (int i = 0; i < lines; i++) {
                if (tempCars[i] == null) // if that index of the array is empty
                {
                    tempCars[i] = new Car(license); // creates a new car object

                    lastIndex = i;

                    break;  // exit loop
                } else if (tempCars[i].getLicense().equals(license)) // if they match, break the loop
                {

                    break;

                }
            }
        }

        /*
         * Creates the actual array with the correct size
         * and manually copies the temp array and used array at each index
         */

        Car[] cars = new Car[lastIndex + 1];

        for (int i = 0; i <= lastIndex; i++) {

            cars[i] = tempCars[i];

        }

        Scanner garageFile = new Scanner(new File("garage.txt"));

        PrintWriter toFile = new PrintWriter("output.txt");

        while (garageFile.hasNext()) { // read until EOF

            String license = garageFile.next(); // stores license number

            String action = garageFile.next(); // stores action

            int carIndex = getCarIndex(license, cars);

            if (action.equals("ARRIVE")) // if the action equals ARRIVE
            {

                /*System.out.println(bashemin.arrive(cars[carIndex])); // displays in console*/

                toFile.println(bashemin.arrive(cars[carIndex])); // writes to output file

            } else if (action.equals("DEPART")) // if the action equals DEPART
            {

                /*System.out.println(bashemin.depart(cars[carIndex])); // let the car leave*/

                toFile.println(bashemin.depart(cars[carIndex])); // writes to output file

            }

            bashemin.printGarage(); // prints out each step of the garage to the console



        }

        toFile.close(); // saves the output file
    }

    /**
     * Traverses the temp array and finds the index of a car
     *
     * @param license the 6-character license plate number
     * @param cars    the array of cars
     * @return the index if it is found, otherwise return -1 (false)
     */

    public static int getCarIndex(String license, Car[] cars) {
        for (int i = 0; i < 15; i++) {
            if (license.equals(cars[i].getLicense())) {
                return i;
            }
        }

        return -1;
    }
}