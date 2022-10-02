/**
 * Simple Class describing "On Board System" objects
 * 
 * @author Lucas Cavatoni
 */
package satellite;

import java.util.ArrayList;
import java.util.Arrays;

import data.Data;

public class OnBoardSystem {

    /**
     * List of subsystems
     */
    private ArrayList<Subsystem> subsystems = new ArrayList<Subsystem>();

    /**
     * Constructor
     * 
     * @param subsystems the subsystems you want in your satellite
     */
    public OnBoardSystem(String[] subsystems) {
        for (String subsystemName : subsystems) {
            this.subsystems.add(new Subsystem(subsystemName));
        }
    }

    /**
     * Command the desired subsystem with the desired command
     * 
     * @param subsystemString the desired subsystem, String format
     * @param command         the desired command
     */
    void commandSatellite(String subsystemString, String command) {
        Subsystem subsystem = new Subsystem(subsystemString);
        if (this.subsystems.contains(subsystem)) { // Checks if the desired subsystem is in the list of subsystems
            int index = this.subsystems.indexOf(subsystem);
            if (Arrays.asList(this.subsystems.get(index).getCommands()).contains(command)) { // Checks if the desired
                                                                                             // command is in the list
                                                                                             // of commands
                if (command.equals("ON")) { // ON -> Subsystem is turned ON
                    this.subsystems.get(index).turnOn();
                } else { // OFF -> Subsystem is turned OFF
                    this.subsystems.get(index).turnOff();
                }
            } else {
                System.out.println("KO");
            }
        } else {
            System.out.println("KO");
        }
    }

    /**
     * Retrieve Data from a subsystem
     * 
     * @param subsystemString the desired subsystem, String format
     * @return the measured Data
     */
    Data retrieveData(String subsystemString) {
        Subsystem subsystem = new Subsystem(subsystemString);
        if (this.subsystems.contains(subsystem)) {
            int index = this.subsystems.indexOf(subsystem);
            if (this.subsystems.get(index).getState().equals("ON")) { // Checks if the desired subsystem is on to
                                                                      // measure data
                System.out.println("OK");
                return new Data(subsystemString);
            } else {
                System.out.println("KO");
                return null;
            }
        } else {
            System.out.println("KO");
            return null;
        }
    }

    /**
     * Checks if two onboard systems have the same subsystems
     * 
     * @param otherOBS the other onboard system you want to test
     * @return true if the two onboard systems have the same subsystems
     */
    public boolean equals(OnBoardSystem otherOBS) {
        if (subsystems.size() != otherOBS.subsystems.size()) { // Checks if the list of subsystems have the same size
            return false;
        } else {
            for (Subsystem subsystem : this.subsystems) {
                if (!(otherOBS.subsystems.contains(subsystem))) { // Checks if the list of subsystems contains each
                                                                  // subsystem
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 
     * @return the List of subsystems
     */
    public ArrayList<Subsystem> getSubsystems() {
        return this.subsystems;
    }

    /**
     * Returns the list of subsystems of the onboardsystem in a String[] format
     * 
     * @return The list of subsystems in a String[] format, like the input format in the main
     */
    public String[] toStringArray() {
        String[] subSystemsString = new String[this.subsystems.size()];
        for (int i = 0; i < subSystemsString.length; i++){
                subSystemsString[i] = this.subsystems.get(i).toString();
        }
        return subSystemsString;
    }

}
