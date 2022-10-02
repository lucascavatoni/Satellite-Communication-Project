/**
 * Simple Interface describing "Data Sample" objects
 * 
 * @author Lucas Cavatoni
 */
package data;

import java.io.Serializable;

public interface DataSample extends Serializable {

    /**
     * Displays the data measured (image, temperature, humidity etc...).
     */
    public void display();

}
