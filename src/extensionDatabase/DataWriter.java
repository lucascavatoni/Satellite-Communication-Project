/**
 * Simple Class describing "Data Writer" objects
 * 
 * @author Lucas Cavatoni
 */
package extensionDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import data.Data;

public class DataWriter {

    /**
     * Writes a Data Object to a binary file.
     * 
     * @param data     the Data to write
     * @param filename the name to give to the Data File
     */
    public static void writeData(Data data, String filename) {
        try {
            FileOutputStream f = new FileOutputStream(new File(filename));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(data);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }

    }

}
