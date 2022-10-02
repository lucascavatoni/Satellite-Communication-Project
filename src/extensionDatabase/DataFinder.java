/**
 * Simple Class describing "Data Finder" objects
 * 
 * @author Lucas Cavatoni
 */

package extensionDatabase;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class DataFinder {

    /**
     * True if satellite criterion is active
     */
    private static boolean satIsActive = false;

    /**
     * True if type criterion is active
     */
    private static boolean typeIsActive = false;

    /**
     * True if location criterion is active
     */
    private static boolean locIsActive = false;

    /**
     * True if time criterion is active
     */
    private static boolean timeIsActive = false;

    /**
     * List of entered satellites
     */
    private static String[] satellites;

    /**
     * List of entered types
     */
    private static String[] types;

    /**
     * Entered time at which the time interval begins
     */
    private static Instant timeBeg;

    /**
     * Entered time at which the time interval ends
     */
    private static Instant timeEnd;

    /**
     * Entered latitude
     */
    private static double lat;

    /**
     * Entered longitude
     */
    private static double lon;

    /**
     * Entered radius which must be greater than the distance between the entered
     * location and the data's location
     */
    private static double radius;

    /**
     * Number of active criteria
     */
    private static int criteria = 0;

    /**
     * Temporary Data List which adds a data filename everytime that data fits any
     * of the entered criteria. So it's like a list containing the data filenames
     * which fit the union of all criteria, and appear as many times as the number
     * of criteria they fit.
     */
    private static ArrayList<String> tempDataList = new ArrayList<String>();

    /**
     * Final Data List which contains only the data filenames which fit all the
     * criteria. (So they fit the intersection of the criteria)
     */
    private static ArrayList<String> finalDataList = new ArrayList<String>();

    /**
     * Map linking the data filename (key) and the data's distance to the entered
     * location (value)
     */
    private static LinkedHashMap<String, Double> radiusMap = new LinkedHashMap<String, Double>();

    /**
     * Handles the entered search query
     * 
     * @param searchQuery the Search Query String
     */
    public static void handleQuery(String searchQuery) {

        // Spliting the search query into seperate strings
        String[] searchQueryArray = searchQuery.split(" ");

        // Ignoring upper cases
        searchQueryArray[0] = searchQueryArray[0].toLowerCase();

        switch (searchQueryArray[0]) {
            case "satellite":

                // Creating the array of entered satellites
                satellites = Arrays.copyOfRange(searchQueryArray, 1, searchQueryArray.length);

                // If the satellite criterion was inactive then :
                if (!satIsActive) {
                    System.out.println(Colors.GREEN + "-> Satellite criterion is now active!" + Colors.RESET);
                } else { // If the satellite criterion was already active then :
                    System.out.println(Colors.GREEN
                            + "-> New satellite criterion is now active! Old satellite criterion is overridden."
                            + Colors.RESET);
                }
                satIsActive = true;
                break;
            case "type":

                // Creating the array of entered types
                types = Arrays.copyOfRange(searchQueryArray, 1, searchQueryArray.length);

                // If the type criterion was inactive then :
                if (!typeIsActive) {
                    System.out.println(Colors.GREEN + "-> Type criterion is now active!" + Colors.RESET);
                } else { // If the type criterion was already active then :
                    System.out.println(Colors.GREEN
                            + "-> New type criterion is now active! Old type criterion is overridden." + Colors.RESET);
                }
                typeIsActive = true;
                break;
            case "location":
                try {

                    // Converting entered latitude and longitude to double
                    String latString = searchQueryArray[1];
                    String lonString = searchQueryArray[2];
                    String NorS = latString.replaceAll("[^A-Za-z]+", "");
                    String EorW = lonString.replaceAll("[^A-Za-z]+", "");
                    boolean locSuccess = false;
                    switch (NorS) {
                        case "N":
                            lat = Double.parseDouble(latString.substring(0, latString.length() - 1));
                            locSuccess = true;
                            break;
                        case "S":
                            lat = -Double.parseDouble(latString.substring(0, latString.length() - 1));
                            locSuccess = true;
                            break;
                        default:
                            locSuccess = false;
                            break;
                    }

                    // If latitude was successfully converted, longitude can be converted :
                    if (locSuccess) {
                        switch (EorW) {
                            case "E":
                                lon = Double.parseDouble(lonString.substring(0, lonString.length() - 1));
                                locSuccess = true;
                                break;
                            case "W":
                                lon = -Double.parseDouble(lonString.substring(0, lonString.length() - 1));
                                locSuccess = true;
                                break;
                            default:
                                locSuccess = false;
                                break;
                        }
                    }

                    // Converting radius to double
                    if (locSuccess && Math.abs(lat) <= 90 && Math.abs(lon) <= 180) { // If the location was successfully
                                                                                     // converted to double and
                                                                                     // -90<latitude<90 and
                                                                                     // -180<longitude<180 then:
                        try {
                            radius = Double.parseDouble(searchQueryArray[3]);

                            // If the entered radius is greater than zero then :
                            if (radius >= 0) {

                                // If the location criterion was inactive then :
                                if (!locIsActive) {
                                    System.out.println(
                                            Colors.GREEN + "-> Location criterion is now active!" + Colors.RESET);
                                } else { // If the location criterion was already active then :
                                    System.out.println(Colors.GREEN
                                            + "-> New location criterion is now active! Old location criterion is overridden."
                                            + Colors.RESET);
                                }

                                locIsActive = true;
                            } else { // If the entered radius is less than zero, then :
                                System.out.println(Colors.RED + "-> Please input valid radius." + Colors.RESET);
                                locIsActive = false;
                            }

                        } catch (Exception er) {
                            System.out.println(Colors.RED + "-> Please input valid radius." + Colors.RESET);
                            locIsActive = false;
                        }

                    } else { // If the location was unsuccessfully converted to double or |latitude| > 90 or
                             // |longitude| > 180 then :
                        System.out.println(Colors.RED + "-> Please input valid location." + Colors.RESET);
                        locIsActive = false;
                    }

                } catch (Exception le) {
                    System.out.println(Colors.RED + "-> Please input valid location." + Colors.RESET);
                    locIsActive = false;
                }

                break;
            case "time":
                try { // Try with a first time format like 1/1/2020 (so with no zeros)

                    // Converting first time to instant
                    timeBeg = LocalDateTime
                            .parse(searchQueryArray[1] + " " + searchQueryArray[2],
                                    DateTimeFormatter.ofPattern("d/M/uuuu HH:mm:ss", Locale.FRANCE))
                            .atZone(ZoneId.of("Europe/Paris")).toInstant();

                    // Converting second time to instant
                    timeEnd = LocalDateTime
                            .parse(searchQueryArray[3] + " " + searchQueryArray[4],
                                    DateTimeFormatter.ofPattern("d/M/uuuu HH:mm:ss", Locale.FRANCE))
                            .atZone(ZoneId.of("Europe/Paris")).toInstant();

                    // If time criterion was inactive then :
                    if (!timeIsActive) {
                        System.out.println(Colors.GREEN + "-> Time criterion is now active!" + Colors.RESET);
                    } else { // If time criterion was already active then :
                        System.out.println(
                                Colors.GREEN + "-> New time criterion is now active! Old time criterion is overridden."
                                        + Colors.RESET);
                    }
                    timeIsActive = true;

                } catch (Exception te) {
                    try { // Try with another dat format like 01/01/2020

                        // Converting first time to instant
                        timeBeg = LocalDateTime
                                .parse(searchQueryArray[1] + " " + searchQueryArray[2],
                                        DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss", Locale.FRANCE))
                                .atZone(ZoneId.of("Europe/Paris")).toInstant();

                        // Converting second time to instant
                        timeEnd = LocalDateTime
                                .parse(searchQueryArray[3] + " " + searchQueryArray[4],
                                        DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss", Locale.FRANCE))
                                .atZone(ZoneId.of("Europe/Paris")).toInstant();

                        // If time criterion was inactive then :
                        if (!timeIsActive) {
                            System.out.println(Colors.GREEN + "-> Time criterion is now active!" + Colors.RESET);
                        } else { // If time criterion was already active then :
                            System.out.println(Colors.GREEN
                                    + "-> New time criterion is now active! Old time criterion is overridden."
                                    + Colors.RESET);
                        }
                        timeIsActive = true;

                    } catch (Exception te2) {
                        System.out.println(Colors.RED + "-> Please input valid time." + Colors.RESET);
                        timeIsActive = false;
                    }
                }

                break;
            case "search":

                // If the number of criteria is greater than zero then :
                if (timeIsActive || locIsActive || typeIsActive || satIsActive) {
                    findData();
                    display();
                } else { // If the number of criteria is equal to zero then :
                    System.out.println(Colors.PURPLE + "-> Please input at least one search criteria." + Colors.RESET);
                }

                break;
            case "s":
                // If the number of criteria is greater than zero then :
                if (timeIsActive || locIsActive || typeIsActive || satIsActive) {
                    findData();
                    display();
                } else { // If the number of criteria is equal to zero then :
                    System.out.println(Colors.PURPLE + "-> Please input at least one search criteria." + Colors.RESET);
                }
                break;
                case "":
                // If the number of criteria is greater than zero then :
                if (timeIsActive || locIsActive || typeIsActive || satIsActive) {
                    findData();
                    display();
                } else { // If the number of criteria is equal to zero then :
                    System.out.println(Colors.PURPLE + "-> Please input at least one search criteria." + Colors.RESET);
                }
                break;
            case "clear":
                locIsActive = false;
                satIsActive = false;
                typeIsActive = false;
                timeIsActive = false;
                tempDataList.clear();
                System.out.println(Colors.GREEN + "-> Search criteria cleared!" + Colors.RESET);
                break;
            default:
                System.out.println(Colors.RED + "-> Please input valid command." + Colors.RESET);
                break;

        }

    }

    /**
     * Finds all the data files which fit (the intersection of) all active criteria
     * and adds their filenames into a list
     */
    private static void findData() {

        // If the satellite criteria is active then :
        if (satIsActive) {
            findSatellites();
            criteria += 1;
        }

        // If the type criteria is active then :
        if (typeIsActive) {
            findTypes();
            criteria += 1;
        }

        // If the location criteria is active then :
        if (locIsActive) {
            findLocation();
            criteria += 1;
        }

        // If the time criteria is active then :
        if (timeIsActive) {
            findTime();
            criteria += 1;
        }
        // For each data filename in the temporary data list
        for (String dataName : tempDataList) {

            // Computing the number of times the data filename appears in the temporary data
            // list
            int occurences = Collections.frequency(tempDataList, dataName);

            // If the number of times the filename appears in the temporary list is equal to
            // the number of criteria, that means the data fits all the criteria (the
            // intersection)
            if (occurences == criteria && !finalDataList.contains(dataName)) {

                // So that filename is added to the final list.
                finalDataList.add(dataName);
            }
        }

        // Clearing the temporary data list
        tempDataList.clear();

    }

    /**
     * Finds the datas whose satellite fits the entered satellite criterion and adds
     * them to the temporary data list
     */
    private static void findSatellites() {

        try {
            // Reading the Index Map
            LinkedHashMap<ArrayList<String>, String> indexMap = IndexMapReader.readMap();

            // Creating a set to go through each element of the HashMap
            Set<Map.Entry<ArrayList<String>, String>> set = indexMap.entrySet();

            // For each element in the set created
            for (Map.Entry<ArrayList<String>, String> elt : set) {

                // If the data's satellite is one of the satellites entered then
                if (Arrays.asList(satellites).contains(elt.getKey().get(0))) {

                    // The data's filename is added to the temporary data list
                    tempDataList.add(elt.getValue());
                }
            }
        } catch (Exception e) {
            System.out.println(Colors.RED + "-> Index Map not found." + Colors.RESET);
        }
    }

    /**
     * Finds the datas whose type fits the entered satellite criterion and adds them
     * to the temporary data list
     */
    private static void findTypes() {

        try {
            // Reading the Index Map
            LinkedHashMap<ArrayList<String>, String> indexMap = IndexMapReader.readMap();

            // Creating a set to go through each element of the HashMap
            Set<Map.Entry<ArrayList<String>, String>> set = indexMap.entrySet();

            // For each element in the set created
            for (Map.Entry<ArrayList<String>, String> elt : set) {

                // If the data's type is one of the satellites entered then
                if (Arrays.asList(types).contains(elt.getKey().get(1))) {

                    // The data's filename is added to the temporary data list
                    tempDataList.add(elt.getValue());
                }
            }

        } catch (Exception e) {
            System.out.println(Colors.RED + "-> Index Map not found." + Colors.RESET);
        }

    }

    /**
     * Finds the datas whose location is within a circle of entered radius around
     * entered location and adds them to the temporary data list
     */
    private static void findLocation() {

        try {
            // Reading the Index Map
            LinkedHashMap<ArrayList<String>, String> indexMap = IndexMapReader.readMap();

            // Creating a set to go through each element of the HashMap
            Set<Map.Entry<ArrayList<String>, String>> set = indexMap.entrySet();

            // For each element in the set created
            for (Map.Entry<ArrayList<String>, String> elt : set) {

                // Converting data's location to latitude and longitude doubles
                String[] dataLoc = elt.getKey().get(2).split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                double dataLat = 0.0;
                double dataLon = 0.0;
                switch (dataLoc[3]) {
                    case "N":
                        dataLat = Double.parseDouble(dataLoc[0] + dataLoc[1] + dataLoc[2]);
                        break;
                    case "S":
                        dataLat = -Double.parseDouble(dataLoc[0] + dataLoc[1] + dataLoc[2]);
                        break;
                    default:
                        System.out.println(
                                Colors.RED + "-> Could not translate key location value into latitude." + Colors.RESET);
                }
                switch (dataLoc[7]) {
                    case "E":
                        dataLon = Double.parseDouble(dataLoc[4] + dataLoc[5] + dataLoc[6]);
                        break;
                    case "W":
                        dataLon = -Double.parseDouble(dataLoc[4] + dataLoc[5] + dataLoc[6]);
                        break;
                    default:
                        System.out.println(Colors.RED + "-> Could not translate key location value into longitude."
                                + Colors.RESET);
                }

                // Computing the distance between the entered location and the data's location
                double dataRadius = GetDistance(lat, lon, dataLat, dataLon);

                // If the computed distance is less than the entered distance then :
                if (dataRadius <= radius) {

                    // The data's filename is added to the temporary data list
                    tempDataList.add(elt.getValue());

                    // The data's filename (key) and computed distance (value) is added in a
                    // LinkedHashMap to later display the data's distance to the entered location
                    radiusMap.put(elt.getValue(), dataRadius);
                }
            }

        } catch (Exception e) {
            System.out.println(Colors.RED + "-> Index Map not found." + Colors.RESET);
        }

    }

    /**
     * Finds the data's whose time is within the entered time interval and adds them
     * to the temporary data list
     */
    private static void findTime() {

        try {
            // Reading the Index Map
            LinkedHashMap<ArrayList<String>, String> indexMap = IndexMapReader.readMap();

            // Creating a set to go through each element of the HashMap
            Set<Map.Entry<ArrayList<String>, String>> set = indexMap.entrySet();

            // For each element in the set created
            for (Map.Entry<ArrayList<String>, String> elt : set) {

                // Converting the data time to instant
                Instant dataTime = Instant.parse(elt.getKey().get(3));

                // If the data time is within the entered time interval :
                if (timeBeg.compareTo(dataTime) <= 0 && timeEnd.compareTo(dataTime) >= 0) {

                    // The data's filename is added to the temporary data list
                    tempDataList.add(elt.getValue());

                }
            }
        } catch (Exception e) {
            System.out.println(Colors.RED + "-> Index Map not found." + Colors.RESET);
        }

    }

    /**
     * Displays the data filenames found (which fit the criteria) along with their
     * respective criteria values. (all criteria)
     */
    private static void display() {

        // If no data was found then
        if (finalDataList.size() == 0) {
            System.out.println(Colors.PURPLE + "-> 0 data file found :/." + Colors.RESET);
        } else if (finalDataList.size() >= 50) { // If too many datas were found :
            System.out.println(Colors.YELLOW + "-> " + finalDataList.size()
                    + " data files found! Please be more specific in your search." + Colors.RESET);
        } else { // If a reasonable number of datas was found :

            // Creating an inverse Index Map to retrieve the keys from values
            LinkedHashMap<String, ArrayList<String>> inverseMap = new LinkedHashMap<String, ArrayList<String>>();

            // Loading the Index Map
            LinkedHashMap<ArrayList<String>, String> indexMap = IndexMapReader.readMap();

            // Creating a set to go through each element of the index map
            Set<Map.Entry<ArrayList<String>, String>> setIndexMap = indexMap.entrySet();

            // Initializing the maximum satellite and type length for later aligning display
            int satL = 0;
            int typeL = 0;

            // For each element in the set :
            for (Map.Entry<ArrayList<String>, String> elt : setIndexMap) {
                if (finalDataList.contains(elt.getValue())) {

                    // Putting the filename (key) and the old key (value) in the inverse map
                    inverseMap.put(elt.getValue(), elt.getKey());

                    // Computing the maximum satellite string length for later aligning display
                    satL = Math.max(satL, elt.getKey().get(0).length());

                    // Computing the maximum type string length for later aligning display
                    typeL = Math.max(typeL, elt.getKey().get(1).length());
                }
            }

            // If only one data was found then :
            if (finalDataList.size() == 1) {
                System.out.println(Colors.YELLOW + "-> 1 data file found!" + Colors.RESET);
                System.out.println();
            } else { // If more multiple datas were found then :
                System.out.println(Colors.YELLOW + "-> " + finalDataList.size() + " data files found!" + Colors.RESET);
                System.out.println();
            }

            // Computing the maximum filename string length for later aligning
            // display
            int filenameL = 0;

            for (String dataName : finalDataList) {
                filenameL = Math.max(filenameL, dataName.length());
            }

            // Computing the maximum radius string length for later aligning
            // display if the location is active of course
            int radiusL = 0;

            if (locIsActive) {
                for (String dataName : finalDataList) {
                    radiusL = Math.max(radiusL, Integer.toString((int) round(radiusMap.get(dataName), 0)).length());
                }
            }

            // For each data file name in the final data list
            for (String dataName : finalDataList) {

                // Display Filename
                System.out.print("  Filename : ");
                System.out.print(Colors.PURPLE + dataName + Colors.RESET + " ");
                System.out.print(DataArchiver.repeat(filenameL - dataName.length(), ' '));

                // Display satellite name
                System.out.print("Satellite : ");
                String satelliteName = inverseMap.get(dataName).get(0);
                System.out.print(Colors.GREEN + satelliteName + Colors.RESET + " ");
                System.out.print(DataArchiver.repeat(satL - satelliteName.length(), ' '));

                // Display data type
                System.out.print("Type : ");
                String type = inverseMap.get(dataName).get(1);
                System.out.print(Colors.BLUE_BRIGHT + type + Colors.RESET + " ");
                System.out.print(DataArchiver.repeat(typeL - type.length(), ' '));

                // Display location
                System.out.print("Location : ");
                String location = inverseMap.get(dataName).get(2);
                String[] dataLoc = location.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                String dataLat = dataLoc[0] + dataLoc[1] + dataLoc[2] + dataLoc[3];
                String dataLon = dataLoc[4] + dataLoc[5] + dataLoc[6] + dataLoc[7];
                System.out.print(Colors.YELLOW + DataArchiver.repeat(10 - dataLat.length(), ' '));
                System.out.print(dataLat);
                System.out.print(" ");
                System.out.print(DataArchiver.repeat(11 - dataLon.length(), ' '));
                System.out.print(dataLon);
                System.out.print(" " + Colors.RESET);

                // If location is active, the distance between the entered location and the
                // data's location is displayed
                if (locIsActive) {
                    int radius = (int) round(radiusMap.get(dataName), 0);
                    System.out.print(Colors.YELLOW_BRIGHT + "(");
                    System.out.print(DataArchiver.repeat(radiusL - Integer.toString(radius).length(), ' '));
                    System.out.print(radius + " km) " + Colors.RESET);
                }

                // Display time
                System.out.print("Time : ");
                System.out.print(Colors.CYAN + inverseMap.get(dataName).get(3) + Colors.RESET);

                System.out.println();
                System.out.println();

            }
        }

        // Clearing the final list
        finalDataList.clear();

        // Resetting the number of criteria to zero for the next findData() call
        criteria = 0;
    }

    /**
     * Computes the surface distance in kilometers between two points A and B on our
     * beautiful Blue Marble using their latitude and longitude.
     * 
     * @param lat1 Point A's latitude
     * @param lon1 Point A's longitude
     * @param lat2 Point B's latitude
     * @param lon2 Point B' longitude
     * @return the distance in kilometers on Earth's surface between point A and
     *         point B
     */

    public static double GetDistance(double lat1, double lon1, double lat2, double lon2) {
        var R = 6371; // Radius of the earth in km
        var dLat = ToRadians(lat2 - lat1);
        var dLon = ToRadians(lon2 - lon1);
        var a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(ToRadians(lat1)) * Math.cos(ToRadians(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        var d = R * c; // Distance in km
        return d;
    }

    /**
     * Converts degrees to radians
     * 
     * @param deg Quantity in degrees
     * @return That quantity in radians
     */
    public static double ToRadians(double deg) {
        return deg * (Math.PI / 180);
    }

    /**
     * Rounds a double to a desired number of decimal places
     * 
     * @param value  the double to round
     * @param places the number of decimal places
     * @return the rounded value with 'places' number of decimal places
     */
    public static double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
