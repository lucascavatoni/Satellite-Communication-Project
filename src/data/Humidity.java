/**
 * Simple Class describing "Humidity" objects
 * 
 * @author Lucas Cavatoni
 */
package data;

import java.util.concurrent.ThreadLocalRandom;

public class Humidity implements DataSample {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Value of the measured humidity.
     */
    private double value;

    /**
     * Creates a Humidity Object. Assigns the value randomly from 0.0% to 100.0%.
     */
    public Humidity() {
        this.value = ThreadLocalRandom.current().nextInt(0, 1000 + 1) / 10.0;
    }

    /**
     * Displays the measured humidity.
     */
    public void display() {
        System.out.println();
        System.out.println("Measured Humidity : " + this.value + "%");
        System.out.println();

    }

}
