/**
 * Simple Class describing "Index Map Writer" objects
 * 
 * @author Lucas Cavatoni
 */

package extensionDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class IndexMapWriter {

    /**
     * Writes the Index Map to a DATA/Map.bin file.
     * 
     * @param indexMap the index Map you want to write to a file
     */
    public static void writeMap(LinkedHashMap<ArrayList<String>, String> indexMap) {
        try {
            File mapFile = new File("DATA" + File.separator + "Map.bin");
            mapFile.getParentFile().mkdirs();
            FileOutputStream f = new FileOutputStream(mapFile);
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(indexMap);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }

    }

}
