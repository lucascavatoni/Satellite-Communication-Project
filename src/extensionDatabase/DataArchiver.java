/**
 * Simple Class describing "Archiver" objects
 * 
 * @author Lucas Cavatoni
 */

package extensionDatabase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import data.Data;

public class DataArchiver {

    /**
     * Archives a Data Object to the disk in
     * PROJECT_FOLDER/DATA/SATELLITE_NAME/XXXXXXXXX.bin.
     * 
     * @param satName The name of the satellite
     * @param data    The Data Object to archive
     */
    public static void archiveData(String satName, Data data) {

        // Index of the data filename
        String index;

        // Number to write in the text file for the next data
        String nextSeqNum;
        try {

            File nextSeqNumFile = new File("DATA" + File.separator + satName + File.separator + "NEXTSEQNUM.txt");

            // Creating the directory DATA/SATELLITE_NAME/
            nextSeqNumFile.getParentFile().mkdirs();

            // If the file NEXSEQNUM.txt was created then :
            if (nextSeqNumFile.createNewFile()) {

                nextSeqNum = "000000001";
                index = "000000000";

            } else { // Else, then

                // Reading the file NEXTSEQNUM.txt
                BufferedReader reader = new BufferedReader(new FileReader(nextSeqNumFile));

                // Reading the first line
                index = reader.readLine();
                reader.close();

                // Index of next file is the current index plus one.
                int nextIndex = Integer.parseInt(index) + 1;

                // Converting the int index to a String
                String nextIndexString = Integer.toString(nextIndex);

                // Creating the new index for the NEXTSEQNUM.txt, index has to have a length of
                // 9.
                nextSeqNum = repeat(9 - nextIndexString.length(), '0') + nextIndexString;
            }

            // Writing the next data number in the NEXTSEQNUM.txt file
            PrintWriter out = new PrintWriter(nextSeqNumFile);
            out.println(nextSeqNum);
            out.close();

            // Writing the data object to a binary file
            String dataFileName = "DATA" + File.separator + satName + File.separator + index + ".bin";
            DataWriter.writeData(data, dataFileName);

            // To later search the datas, data filenames will be stored in a Linked HashMap
            // where the value is the filename and the key is what characterises the data :
            // satellite name, type, time, location

            // Generating the key
            ArrayList<String> key = new ArrayList<String>();

            key.add(satName); // First element of the key is Satellite Name
            key.add(data.getType()); // Second element of the key is Data Type
            key.add(data.getLocation()); // Third element of the key is Location
            key.add(data.getTimeStamp()); // Fourth element of the key is Time

            try {
                // Initialzing Index Map
                LinkedHashMap<ArrayList<String>, String> indexMap = new LinkedHashMap<ArrayList<String>, String>();

                // Reading a potentially existing Map
                indexMap = IndexMapReader.readMap();

                // Putting the key and data's filename in the HashMap
                indexMap.put(key, dataFileName);

                // Writing the HashMap to the map file
                IndexMapWriter.writeMap(indexMap);

            } catch (Exception em) {
                // Initializing Index Map
                LinkedHashMap<ArrayList<String>, String> indexMap = new LinkedHashMap<ArrayList<String>, String>();

                // Putting the key and data's filename in the HashMap
                indexMap.put(key, dataFileName);

                // Writing the HashMap to the map file
                IndexMapWriter.writeMap(indexMap);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Creates a String of desired length filled with a desired character. i.e.
     * repeat(5,'o') = "ooooo".
     * 
     * 
     * @param length     Length of the String you desire
     * @param charToFill Character you want to fill the String with
     * @return The String of length "length" filled with character "charToFill"
     */
    public static String repeat(int length, char charToFill) {
        char[] array = new char[length];
        int pos = 0;
        while (pos < length) {
            array[pos] = charToFill;
            pos++;
        }
        return new String(array);
    }

}
