/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ususario
 */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;

public class ImageSplitTest {

    public void main(String[] args) throws IOException {

        File file = new File("C:\\myimage.jpg"); // I have bear.jpg in my working directory
        FileInputStream fis = new FileInputStream(file);
        BufferedImage image = ImageIO.read(fis); //reading the image file

        int rows = 8; //You should decide the values for rows and cols variables
        int cols = 8;
        int chunks = rows * cols;

        String filas[] = {"A", "B", "C", "D", "E", "F", "G", "H"};


        int chunkWidth = image.getWidth() / cols; // determines the chunk width and height
        int chunkHeight = image.getHeight() / rows;
        int count = 0;
        BufferedImage imgs[] = new BufferedImage[chunks]; //Image array to hold image chunks
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                //Initialize the image array with image chunks
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

                // draws the image chunk
                Graphics2D gr = imgs[count++].createGraphics();
                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
                gr.dispose();
            }
        }
        int aux = imgs.length;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                ImageIO.write(imgs[aux], "jpg", new File("c:\\recortes\\" + filas[x] + "" + (y + 1) + ".jpg"));
                aux++;
            }
        }
        System.out.println("Mini images created");
    }

    public void recortar() throws IOException {
        System.out.println("entro a recortar");
        File file = new File("C:\\myimage.jpg"); // I have bear.jpg in my working directory
        FileInputStream fis = new FileInputStream(file);
        BufferedImage image = ImageIO.read(fis); //reading the image file

        int rows = 8; //You should decide the values for rows and cols variables
        int cols = 8;
        int chunks = rows * cols;

        String columnas[] = {"A", "B", "C", "D", "E", "F", "G", "H"};


        int chunkWidth = image.getWidth() / cols; // determines the chunk width and height
        int chunkHeight = image.getHeight() / rows;
        int count = 0;
        BufferedImage imgs[] = new BufferedImage[chunks]; //Image array to hold image chunks
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                //Initialize the image array with image chunks
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

                // draws the image chunk
                Graphics2D gr = imgs[count++].createGraphics();
                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
                gr.dispose();
                
            }
        }
        int aux= 0;
         for (int x = 7; x >= 0; x--) {
            for (int y = 0; y < cols; y++) {
                ImageIO.write(imgs[aux], "jpg", new File("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg"));
                aux++;
            }
        }
    }
}