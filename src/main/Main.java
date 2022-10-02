/**
 * Simple Executable Class to interact with the Control Center
 * 
 * @author Lucas Cavatoni
 */
package main;

import java.util.Scanner;

import controlcenter.ControlCenter;

public class Main {
    public static void main(String[] args) {

        // Creation of ControlCenter Class
        ControlCenter controlCenter = new ControlCenter();

        // Creation of SUBSYSTEMS
        String[] subSystems1 = { "IMAGER1", "IMAGER2" };
        String[] subSystems2 = { "IMAGER3" };

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

        // Pay Attention to the Satellite Order in the List, are members of the same
        // family scattered around...
        // ...the list? Is ISAESAT4 at the end of the list?

        // User Interface Information
        System.out.println("");
        System.out.print("List of Satellites : ");
        System.out.println(controlCenter.getControllableList());
        System.out.println("");
        System.err.println("Please Enter Commands As Such : 'SATELLITE:SUBSYSTEM:COMMAND'");
        System.out.println(
                "To Retrieve Data, Type        : 'SATELLITE:SUBSYSTEM:DATA'    But Make Sure That The SUBSYSTEM Is ON");
        System.err.println("To Exit, Type 'exit'");
        System.out.println("");

        // Text User Interface for command inputs
        boolean loop = true;
        while (loop == true) {
            Scanner in = new Scanner(System.in);
            String command = in.next();

            if (command.equals("exit")) { // User types 'exit' to exit the loop, stoping the program
                loop = false;
                in.close();
            } else {
                controlCenter.handleCommand(command);
            }
        }
    }
}
