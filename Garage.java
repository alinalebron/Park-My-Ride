/**
 * File : Garage.java
 *
 * A class that creates a parking garage with a number of cars in it (10).
 * The garage lets cars park as long (with the arrive method) as there is space to do so and
 * depart (with the depart method) as long as the car is actually parked.
 *
 * I affirm that this program is entirely my own work and none of it is the work of any other person.
 * Created by @AlinaLebron on 2/9/15.
 */

public class Garage
{

    private Car[] parking; // array of cars aka the garage
    private int carsParked; // the number of cars parked

    /**
     * Creates a new garage with 10 parking spaces
     * and no cars parked
     */

    public Garage()
    {
        this.carsParked = 0;

        this.parking = new Car[10];
    }

    /**
     * Retrieve the number of cars parked in the garage
     * @return the number of cars parked
     */

    public int getCarsParked()
    {

        return carsParked;

    }

    /**
     * Parks a car in the garage in the first available spot,
     * as long as there is space in the garage
     * @param car the actual car getting parked
     * @return a message indicating if the car is parked
     */

    public String arrive(Car car)
    {
        /*
         * Checks if the garage is full and rejects a car if the garage is full.
         * Otherwise, park the car
         */

        if (getCarsParked() == 10)
        {

            return "Sorry " + car.getLicense() + ", but you can't park here. GARAGE IS FULL!";

        }

        else if (getCarsParked() < 10)
        {

            parkCar(car); // otherwise, park the car

        }

        return "The car " + car.getLicense() + " is now parked.";
    }

    /**
     * Parks the car in the garage (adds the car to the garage)
     * @param car the car getting parked
     */

    public void parkCar(Car car)
    {

        this.parking[getCarsParked()] = car; // adds the car

        this.carsParked += 1; // increased the number of cars parked by 1
    }

    /**
     * Lets the car park in the garage by finding the car in the array
     * and "removes" the car
     * @param car the car that's departing
     * @return a message that says the car parked and how many times it has
     * been moved temporarily
     */

    public String depart(Car car)
    {

        for (int i = 0; i < 10; i++) // goes to each spot
        {

            if(this.parking[i] == car) // Find if the car is in the spot
            {

                this.parking[i] = null; // Clears the spot

                  /*
                 * Moves cars that were after the spot to their next spot
                 */

                for (int j = i + 1; j < 10; j++)
                {

                     /*
                     * If the spot is not null then it moves it up and sets the previous spot to null
                     */

                    if (this.parking[j] != null)
                    {
                        this.parking[j - 1] = this.parking[j]; // move the car to a spot up

                        this.parking[j - 1].incrementMoved(); // increment the times the car had to be moved

                        this.parking[j] = null; // clears the previous spot
                    }
                }

                this.carsParked -= 1; // decreases the amount of cars parked by 1

                return car.getLicense() + " just left. It has been moved " + car.getMoved() + " times.";
            }
        }

        return "";
    }

    /**
     * A method that prints out all of the cars and vacant spaces for debugging
     */

    public void printGarage()
    {
        System.out.println("-----------------------");
        System.out.println("| # | License | Moved |");
        System.out.println("-----------------------");

        for (int i = 0; i < 10; i++)
        {
            if(this.parking[i] == null)
            {
                System.out.println("| " + i + " | VACANT | N/A |");

            }

            else
            {
                System.out.println("| " + i + " | " + this.parking[i].getLicense() + " |  " +
                        this.parking[i].getMoved() + "  |");
            }
        }

        System.out.println("-----------------------");
    }
}

