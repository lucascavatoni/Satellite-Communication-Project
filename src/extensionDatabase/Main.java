/**
 * Simple Exexcutable Class to use the Data Finder App
 * 
 * @author Lucas Cavatoni
 */

package extensionDatabase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println();
        System.out.println(Colors.YELLOW+"                        DATA SEARCHER APP"+Colors.RESET);
        System.out.println();
        System.out.println(Colors.WHITE_BOLD+"    To add a satellite criterion :         type 'satellite SAT1 SAT2 ...'"+Colors.RESET);
        System.out.println("    To add a type criterion :              type 'type TYP1 TYP2 ...'");
        System.out.println(Colors.WHITE_BOLD+"    To add a location criterion :          type 'location LAT LON RADIUS' (RADIUS in km)"+Colors.RESET);
        System.out.println("    To add a UTC time interval criterion : type 'D/M/YYYY HH:MM:SS D/M/YYYY HH:MM:SS' First date is beginning");
        System.out.println(Colors.WHITE_BOLD+"    To search :                            type 'search','s' or hit ENTER "+Colors.RESET);
        System.out.println("    To clear the search criteria :         type 'clear' (because the criteria are still active after the search, so you can easily modify only one criterion)");
        System.out.println(Colors.WHITE_BOLD+"    To exit the search engine :            type 'exit'"+Colors.RESET);
        System.out.println();
        System.out.println(Colors.PURPLE+"    Example :"+Colors.RESET);
        System.out.println();
        System.out.println("        satellite ISAESAT1 ISAESAT2");
        System.out.println(Colors.GREEN + "        -> Satellite criterion is now active!" + Colors.RESET);
        System.out.println("        type image");
        System.out.println(Colors.GREEN + "        -> Type criterion is now active!" + Colors.RESET);
        System.out.println("        location 34.93N 172.1E 2000");
        System.out.println(Colors.GREEN + "        -> Location criterion is now active!" + Colors.RESET);
        System.out.println("        time 1/1/2020 01:00:00 31/12/2021 23:59:59");
        System.out.println(Colors.GREEN + "        -> Time criterion is now active!" + Colors.RESET);
        System.out.println("        s");
        System.out.println(Colors.YELLOW+"        -> 2 data files found!"+Colors.RESET);
        System.out.println();
        System.out.println("            Filename : "+Colors.PURPLE+"DATA/ISAESAT2/000000013.bin  "+Colors.RESET+"Satellite : "+Colors.GREEN+"ISAESAT2  "+Colors.RESET+"Type : "+Colors.BLUE_BRIGHT+"image  "+Colors.RESET+"Location : "+Colors.YELLOW+"30.469238N 177.077017E"+Colors.YELLOW_BRIGHT+" (680 km)  "+Colors.RESET+"Time : "+Colors.CYAN+"2020-11-13T11:58:49.903706Z"+Colors.RESET);
        System.out.println();
        System.out.println("            Filename : "+Colors.PURPLE+"DATA/ISAESAT2/000000058.bin  "+Colors.RESET+"Satellite : "+Colors.GREEN+"ISAESAT2  "+Colors.RESET+"Type : "+Colors.BLUE_BRIGHT+"image  "+Colors.RESET+"Location : "+Colors.YELLOW+"30.808416N 162.659826E"+Colors.YELLOW_BRIGHT+" (993 km)  "+Colors.RESET+"Time : "+Colors.CYAN+"2020-11-13T19:56:51.836475Z"+Colors.RESET);
        System.out.println("        clear");
        System.out.println(Colors.GREEN + "        -> Search criteria cleared!" + Colors.RESET);
        System.out.println("        ...");
        System.out.println("        exit");
        System.out.println();
        System.out.println();
        System.out.println("Please enter a criterion:");
        System.out.println();
        
    
        // Text User Interface for command inputs
        boolean loop = true;
        while (loop == true) {
            Scanner in = new Scanner(System.in);
            String searchQuery = in.nextLine();

            // User types 'exit' to exit the loop, stoping the program
            if (searchQuery.equals("exit")) { 
                loop = false;
                in.close();
            } else {
                DataFinder.handleQuery(searchQuery);
            }
        }

    }

}
