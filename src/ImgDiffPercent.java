/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ususario
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.swing.JOptionPane;

public class ImgDiffPercent {

    public boolean compararImagenes(String imagen1, String imagen2) throws IOException {
        BufferedImage img1 = null;
        BufferedImage img2 = null;
        String path = new File(".").getCanonicalPath();
        //this.getClass().getClassLoader().getResourceAsStream(imagen2);

        try {
            File file1 = new File(imagen1); // 
            URL url = ImgDiffPercent.class.getResource("" + imagen2);

            //System.out.println(url);
            File file2 = new File(url.getPath()); // 
            img1 = ImageIO.read(file1);
            InputStream in;
            in = ImgDiffPercent.class.getClassLoader().getResourceAsStream(imagen2);

            img2 = ImageIO.read(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
        int width1 = img1.getWidth(null);
        int width2 = img2.getWidth(null);
        int height1 = img1.getHeight(null);
        int height2 = img2.getHeight(null);
        if ((width1 != width2) || (height1 != height2)) {
            System.err.println("Error: Images dimensions mismatch");
            return false;
        }
        long diff = 0;
        for (int y = 0; y < height1; y++) {
            for (int x = 0; x < width1; x++) {
                int rgb1 = img1.getRGB(x, y);
                int rgb2 = img2.getRGB(x, y);
                int r1 = (rgb1 >> 16) & 0xff;
                int g1 = (rgb1 >> 8) & 0xff;
                int b1 = (rgb1) & 0xff;
                int r2 = (rgb2 >> 16) & 0xff;
                int g2 = (rgb2 >> 8) & 0xff;
                int b2 = (rgb2) & 0xff;
                diff += Math.abs(r1 - r2);
                diff += Math.abs(g1 - g2);
                diff += Math.abs(b1 - b2);
            }
        }
        double n = width1 * height1 * 3;
        double p = diff / n / 255.0;
        if (p * 100 > 2.0) {
            return false;
        } else {
            return true;
        }
    }
}
