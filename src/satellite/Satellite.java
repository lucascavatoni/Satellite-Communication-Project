/**
 * Simple Class describing "Satellite" objects
 * 
 * @author Lucas Cavatoni
 */
package satellite;

import data.Data;

public class Satellite implements Controllable {

    /**
     * the Name of the satellite
     */
    private String name;
    /**
     * the onboard system of the satellite
     */
    private OnBoardSystem onBoardSystem;

    /**
     * Constructor
     * 
     * @param name          Name of the Satellite
     * @param onBoardSystem OnBoard System of the satellite
     */
    public Satellite(String name, OnBoardSystem onBoardSystem) {
        this.name = name;
        this.onBoardSystem = new OnBoardSystem(onBoardSystem.toStringArray());
    }

    public void commandControllable(String subsystem, String command) {
        onBoardSystem.commandSatellite(subsystem, command);
    }

    public Data retrieveData(String subsystem) {
        return onBoardSystem.retrieveData(subsystem);
    }

    public String getName() {
        return this.name;
    }

    public OnBoardSystem getOnBoardSystem() {
        return this.onBoardSystem;
    }

    /**
     * 
     * @return true if the satellites have the same name
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Satellite) {
            String toCompare = ((Satellite) o).name;
            return name.equals(toCompare);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * @return Name of the satellite
     */
    @Override
    public String toString() {
        return getName();
    }
}
