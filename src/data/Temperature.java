/**
 * Simple Class describing "Temperature" objects
 * 
 * @author Lucas Cavatoni
 */

package data;

import java.util.concurrent.ThreadLocalRandom;

public class Temperature implements DataSample {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Value of the temperature measured.
     */
    private double value;

    /**
     * Creates a Temperature object. Assigns the temperature value to a random
     * double between -25.0°C and +45.0°C
     */
    public Temperature() {
        this.value = ThreadLocalRandom.current().nextInt(-250, 450 + 1) / 10.0;

    }

    /**
     * Displays the temperature value.
     */
    public void display() {
        System.out.println();
        System.out.println("Measured Temperature : " + this.value + " °C");
        System.out.println();
    }

}
