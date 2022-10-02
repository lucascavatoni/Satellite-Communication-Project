/**
 * Simple Class describing "Data" objects
 * 
 * @author Lucas Cavatoni
 */
package data;

import java.io.Serializable;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class Data implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Time at which the Data Sample is collected.
     */
    private String timeStamp;
    /**
     * Data Sample, random value between 0 and 1.
     */
    private DataSample dataSample;

    /**
     * Location of the data on the Earth.
     */
    private String location = "N/A";

    private String type;

    /**
     * Creates a Data object with random location, time at which the Data was
     * created and Data Sample & type depending on the SubSystem.
     */
    public Data(String Subsystem) {
        this.timeStamp = Instant.now().toString();

        // Create location
        double latInt = ThreadLocalRandom.current().nextDouble(-90, 90);
        double latDecimal = ThreadLocalRandom.current().nextDouble(0, 1);
        String latString;
        double lonInt = ThreadLocalRandom.current().nextDouble(-180, 180);
        double lonDecimal = ThreadLocalRandom.current().nextDouble(0, 1);
        String lonString;
        if (latInt >= 0.0) {
            latString = Double.toString(latDecimal);
            latString = latString.substring(1, 8) + "N";
            latString = Integer.toString((int) (Math.abs(latInt))) + latString;
        } else {
            latString = Double.toString(latDecimal);
            latString = latString.substring(1, 8) + "S";
            latString = Integer.toString((int) (Math.abs(latInt))) + latString;
        }
        if (lonInt >= 0.0) {
            lonString = Double.toString(lonDecimal);
            lonString = lonString.substring(1, 8) + "E";
            lonString = Integer.toString((int) (Math.abs(lonInt))) + lonString;
        } else {
            lonString = Double.toString(lonDecimal);
            lonString = lonString.substring(1, 8) + "W";
            lonString = Integer.toString((int) (Math.abs(lonInt))) + lonString;
        }
        this.location = latString + lonString;

        Subsystem = Subsystem.replaceAll("[^A-Za-z]+", "");
        switch (Subsystem) {
            case "IMAGER":
                this.dataSample = new Image();
                this.type = "image";
                break;
            case "THERMOMETER":
                this.dataSample = new Temperature();
                this.type = "temperature";
                break;
            case "SENSOR":
                this.dataSample = new Humidity();
                this.type = "humidity";
                break;
            // case...

            default:
                System.out.println("Sub-System category " + Subsystem + " not found.");
                this.dataSample = null;
                this.type = "N/A";
                break;
        }
    }

    /**
     * @return the Time and Data Sample in a string
     */
    @Override
    public String toString() {
        return "Time = " + getTimeStamp() + ", Data Sample = " + getDataSample() + ", Type = " + getType()
                + ", Location = " + getLocation();
    }

    /**
     * 
     * @return Time at which the Data Sample is collected
     */
    public String getTimeStamp() {
        return this.timeStamp;
    }

    /**
     * 
     * @return The Data Sample, a double between 0 and 1
     */
    public DataSample getDataSample() {
        return this.dataSample;
    }

    /**
     * 
     * @return The Data's location
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Displays the data measured (i.e. Image, temperature...).
     */
    public void display() {
        this.dataSample.display();
    }

    /**
     * 
     * @return the type of the data (image, temperature ...)
     */
    public String getType() {
        return this.type;
    }

}
