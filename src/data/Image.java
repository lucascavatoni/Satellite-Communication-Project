/**
 * Simple Class describing "Image" objects
 * 
 * @author Lucas Cavatoni
 */

package data;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.FlowLayout;

public class Image implements DataSample {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Width of the image.
     */
    private int width = 100;

    /**
     * Height of the image.
     */
    private int height = 100;

    /**
     * List of pixels of the image (row by row) so the image can be serializable.
     * Because a bufferedimage is not serializable.
     */
    private ArrayList<Integer> pixels = new ArrayList<Integer>();
    // private static JFrame frame;
    // private static JLabel label;

    /**
     * Creates a random list of gray pixels
     */
    public Image() {
        for (int i = 0; i < this.width * this.height; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 255 + 1); // RED
            int g = r; // GREEN
            int b = r; // BLUE
            int p = (r << 16) | (g << 8) | b;
            pixels.add(p);

        }

    }

    /**
     * Transcribes the list of pixels into an image and displays it a a seperate
     * java window.
     */
    public void display() {
        try {
            BufferedImage image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);

            for (int y = 0; y < this.height; y++) {
                for (int x = 0; x < this.width; x++) {
                    image.setRGB(x, y, this.pixels.get(y * this.width + x));
                }
            }
            JFrame frame = new JFrame();
            frame.getContentPane().setLayout(new FlowLayout());
            frame.getContentPane().add(new JLabel(new ImageIcon(image)));
            frame.pack();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
