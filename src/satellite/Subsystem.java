/**
 * Simple Class describing "Subsystem" objects
 * 
 * @author Lucas Cavatoni
 */
package satellite;

public class Subsystem {

    /**
     * Name of the Subsystem
     */
    private String name;
    /**
     * State of the Subsystem ON or OFF
     */
    private String state;
    /**
     * List of commands accepted by the subsystem
     */
    private String[] commands = { "ON", "OFF" }; // List of available Commands

    /**
     * Constructor
     * 
     * @param name Name of the subsystem
     */
    Subsystem(String name) {
        this.state = "OFF";
        this.name = name;
    }

    /**
     * Turn the subsystem ON
     */
    void turnOn() {
        this.state = "ON";
        System.out.println("OK");
    }

    /**
     * Turn the subsystem OFF
     */
    void turnOff() {
        this.state = "OFF";
        System.out.println("OK");
    }

    /**
     * @return true if the name of the subsystems are the same
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Subsystem) {
            String toCompare = ((Subsystem) o).name;
            return name.equals(toCompare);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * @return the Name of the subsystem
     */
    @Override
    public String toString() {
        return getName();
    }

    /**
     * 
     * @return the Name of the subsystem
     */
    String getName() {
        return this.name;
    }

    /**
     * 
     * @return the State of the subsystem
     */
    String getState() {
        return this.state;
    }

    /**
     * 
     * @return the list of commands accepted by the subsystem
     */
    String[] getCommands() {
        return this.commands;
    }
}
