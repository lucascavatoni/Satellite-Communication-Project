/**
 * Simple Class describing "Index Map Reader" objects
 * 
 * @author Lucas Cavatoni
 */

package extensionDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@SuppressWarnings("unchecked") // This is because there is a Unchecked cast from Object to
                               // LinkedHashMap<ArrayList<String>,String> warning at...(1)
public class IndexMapReader {

    /**
     * Reads the Index Map located at DATA/Map.bin.
     * 
     * @return the Index Map
     */
    public static LinkedHashMap<ArrayList<String>, String> readMap() {
        LinkedHashMap<ArrayList<String>, String> indexMap = null;
        try {
            FileInputStream fi = new FileInputStream(new File("DATA" + File.separator + "Map.bin"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            indexMap = (LinkedHashMap<ArrayList<String>, String>) oi.readObject(); // (1)...this line

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return indexMap;

    }

}
