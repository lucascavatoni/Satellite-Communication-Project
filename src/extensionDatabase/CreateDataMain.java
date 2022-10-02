/**
 * Simple Executable Class to simulate multiple telecommands and telemeasures to archive data objects.
 * 
 * @author Lucas Cavatoni
 */

package extensionDatabase;

import controlcenter.ControlCenter;

public class CreateDataMain {
    public static void main(String[] args) {

        // Creation of ControlCenter Class
        ControlCenter controlCenter = new ControlCenter();

        // Creation of SUBSYSTEMS
        String[] subSystems1 = { "IMAGER1", "IMAGER2" };
        String[] subSystems2 = { "THERMOMETER3" };

        // Addition of Satellites
        controlCenter.addSat("ISAESAT", subSystems1); // Creates ISAESAT1 with IMAGER1 and IMAGER2 Subsystems
        controlCenter.addSat("XSAT", subSystems2); // Creates XSAT1 with IMAGER1 Subsystem
        controlCenter.addSat("ISAESAT"); // Creates ISAESAT2 with IMAGER1 and IMAGER2 Subsystems
        controlCenter.addSat("XSAT"); // Creates XSAT1 with IMAGER1 Subsystem
        controlCenter.addSat("ISAESAT"); // Creates ISAESAT3 with IMAGER1 and IMAGER2 Subsystems
        controlCenter.addSat("FOOSAT"); // Attempts to Create new family FOOSAT but no SUBSYSTEMS so FAIL
        controlCenter.addSat("ISAESAT", subSystems1); // Creates ISAESAT4 with IMAGER1 and IMAGER2 Subsystems
        controlCenter.addSat("ISAESAT", subSystems2); // Attempts to create ISAESAT but Subsystems don't match so FAIL
        controlCenter.addSat("ISAESAT");
        controlCenter.addSat("ISAESAT");
        controlCenter.addSat("ISAESAT");
        controlCenter.addSat("ISAESAT");
        controlCenter.addSat("ISAESAT");
        controlCenter.addSat("ISAESAT");
        controlCenter.addSat("ISAESAT");
        controlCenter.addSat("ISAESAT");

        controlCenter.handleCommand("ISAESAT1:IMAGER1:ON");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:ON");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:ON");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:ON");

        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT1:IMAGER1:DATA");

        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT2:IMAGER1:DATA");

        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");
        controlCenter.handleCommand("ISAESAT11:IMAGER1:DATA");

        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");
        controlCenter.handleCommand("XSAT1:THERMOMETER3:DATA");

    }

}
