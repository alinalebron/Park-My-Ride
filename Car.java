/**
 * File : Car.java
 *
 * A class that creates a car with a license plate number
 * and the number of times it has temporarily moved out of the parking garage
 * to allow another car in.
 *
 * I affirm that this program is entirely my own work and none of it is the work of any other person.
 * Created by @AlinaLebron on 2/9/15.
 */
public class Car {

    private String license; // the license number of the car
    private int moved;  // the times the car has been moved temporarily out of the garage

    /**
     * Creates a car object with a license number and how many times
     * it has been moved inside the garage
     */

    public Car(String license)
    {

        this.license = license;

        this.moved = 0;
    }

    /**
     * Retrieves the license number of the car
     * @return a 6-character license number
     */

    public String getLicense()
    {

        return this.license;

    }

    /**
     * Sets the license number of each car
     * @param license a 6-character license number i.e. JAV092
     */
    public void setLicense(String license)
    {

        this.license = license;

    }

    /**
     * Retrieves how many times the car has been moved
     * in the garage
     * @return a number that shows how many times it was moved
     */

    public int getMoved()
    {

        return this.moved;

    }

    /**
     * Sets how many times the car has been moved in the garage
     * @param moved the number of times it moves
     */

    public void setMoved(int moved)
    {

        this.moved = moved;

    }

    public void incrementMoved()
    {

        this.moved += 1;

    }
}
