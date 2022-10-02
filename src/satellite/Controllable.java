/**
 * Simple Interface describing "Controllable" objects
 * 
 * @author Lucas Cavatoni
 */
package satellite;

import data.Data;

public interface Controllable {

    /**
     * Command the controllable object with ON or OFF
     * 
     * @param subsystem the desired subsystem you want to command
     * @param command   the command you want the subsystem to execute
     */
    void commandControllable(String subsystem, String command);

    /**
     * Retrieve Data from a subsystem
     * 
     * @param subsystemsString the desired subsystem you want the measure from
     * @return the measured Data
     */
    Data retrieveData(String subsystem);

    /**
     * @return The Name of the controllable
     */
    String getName();

    /**
     * @return The On-board System of the controllable
     */
    OnBoardSystem getOnBoardSystem();

}
