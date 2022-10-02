/**
 * Simple Class describing "Control Center" objects
 * 
 * @author Lucas Cavatoni
 */
package controlcenter;

import data.Data;
import extensionDatabase.DataArchiver;
import satellite.OnBoardSystem;
import satellite.Satellite;
import satellite.Controllable;

import java.util.ArrayList;

public class ControlCenter {
    /**
     * List of interface Controllable i.e. Satellites, Rockets etc...
     */
    private ArrayList<Controllable> controllableList = new ArrayList<Controllable>();

    /**
     * Constructor
     */
    public ControlCenter() {

    }

    /**
     * Method used to create a satellite from a nonexisting family, but you can
     * still create a satellite from and existing family, but the subsystems have to
     * match those of the existing family
     * 
     * @param name       Name of the satellite you want to add
     * @param subsystems ArrayString of subsystem names you want in your satellites
     */
    public void addSat(String name, String[] subsystems) {
        OnBoardSystem onBoardSystem = new OnBoardSystem(subsystems);
        boolean addedSat = false;
        for (int i = controllableList.size() - 1; i > -1; i--) { // Loop beginning at the end of the list, to check if
                                                                 // there is already a member of an existing family
            String currentName = controllableList.get(i).getName();
            currentName = currentName.replaceAll("[^A-Za-z]+", "");
            if (currentName.equals(name)) { // Checks if a member of the family is found
                if (controllableList.get(i).getOnBoardSystem().equals(onBoardSystem)) { // Checks if the subsystems are
                                                                                        // the same
                    addSat(name); // Adds the satellite to the list
                    addedSat = true;
                    break;
                } else {
                    System.out.println("");
                    System.out.println("/!\\ FAILED Creating Satellite from existing Family " + name
                            + " With Unmatching Subsystems /!\\");
                    addedSat = true;
                    break;
                }
            }
        }
        if (addedSat == false) { // Checks if a satellite has been added or not
            Controllable newSat = new Satellite(name + "1", onBoardSystem);
            this.controllableList.add(newSat);
            System.out.println("");
            System.out.println(
                    "Family " + name + " Contains following Subsystems : " + newSat.getOnBoardSystem().getSubsystems());
        }
    }

    /**
     * Method used to add a satellite from an existing family
     * 
     * @param name Name of the satellite you want to create, the satellite name must
     *             match at least one from another family
     * 
     */ 
    public void addSat(String name) {
        boolean familyExists = false;
        for (int i = controllableList.size() - 1; i > -1; i--) { // Loop beginning at the end of the list, to check if
                                                                 // there is already a member of an existing family
            String existingSatNameAndNumber = controllableList.get(i).getName();
            String existingSatName = existingSatNameAndNumber.replaceAll("[^A-Za-z]+", "");
            if (existingSatName.equals(name)) { // Checks if a member of the family is found
                OnBoardSystem onBoardSystem = controllableList.get(i).getOnBoardSystem();
                int num = Integer.parseInt(existingSatNameAndNumber.replaceAll("\\D+",""));
                num += 1;
                String numString = String.valueOf(num);
                Controllable newSat = new Satellite(name + numString, onBoardSystem);
                this.controllableList.add(i + 1, newSat);
                familyExists = true;
                break;
            }
        }
        if (familyExists == false) { // Checks if the family of satellites exists
            System.out.println("");
            System.out.println("/!\\ FAILED Creating Satellite : " + name + " Family Not Found /!\\");
        }
    }

    /**
     * Handles the command from the user, checks if the format is correct and if the
     * controllable exists
     * 
     * @param command Input command from Text User Interface
     */
    public void handleCommand(String command) {
        String[] commandArray = command.split(":"); // Divide the command into 3 Strings : 'SAT:SUBS:TC' -> //
                                                    // {'SAT','SUBS','TC'}
        if (commandArray.length != 3) { // Checks if the command has correct format : FOO:BAR:BAZ
            System.out.println("/!\\ Invalid Command Format /!\\");
        } else {
            if (this.controllableList.toString().contains(commandArray[0])) { // Checks if the entered satellite name
                                                                              // exists
                int index = 0;
                for (int i = 0; i < this.controllableList.size(); i++) { // Loop to retrieve the satellite index
                    if (commandArray[0].equals(this.controllableList.get(i).getName())) { // Checks if the satellite
                                                                                          // name is the one entered
                        index = i; // Retrieve the satellite index from the list
                    }
                }
                Controllable satellite = this.controllableList.get(index);
                if (commandArray[2].equals("DATA")) { // Checks if the command contains DATA in which case the program
                                                      // will call the retrieve data function
                    Data newData = satellite.retrieveData(commandArray[1]);
                    if (newData != null) { // Checks if the retrieved data is null, in which case the null data is not
                                           // added to the list
                        DataArchiver.archiveData(commandArray[0], newData);
                    }
                } else {
                    satellite.commandControllable(commandArray[1], commandArray[2]); // call the command function
                }
            } else {
                System.out.println("<Satellite Name Not Found>");
            }
        }
    }

    /**
     * 
     * @return The List of controllable objects
     */
    public ArrayList<Controllable> getControllableList() {
        return this.controllableList;
    }

}
