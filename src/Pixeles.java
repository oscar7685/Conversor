
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ususario
 */
public class Pixeles {

    /*public static void main(String arg[]) {
        BufferedImage img1 = null;
        BufferedImage img2 = null;
        try {
            File file1 = new File("c:\\imx.png"); // 



            img1 = ImageIO.read(file1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        int width1 = img1.getWidth(null);
        int height1 = img1.getHeight(null);


        long diff = 0;
        int r1ant = 0;
        int g1ant = 0;
        int b1ant = 0;

        outerloop:
        for (int y = 0; y < height1; y++) {
            for (int x = 0; x < width1; x++) {
                int rgb1 = img1.getRGB(x, y);

                int r1 = (rgb1 >> 16) & 0xff;
                int g1 = (rgb1 >> 8) & 0xff;
                int b1 = (rgb1) & 0xff;
                if (r1 == 41 && g1 == 120 && b1 == 219) {
                    if (r1ant == 113 && g1ant == 167 && b1ant == 196) {
                        int aux = img1.getRGB(x + 10, y);
                        int raux1 = (aux >> 16) & 0xff;
                        int gaux1 = (aux >> 8) & 0xff;
                        int baux1 = (aux) & 0xff;
                        if (raux1 == 42 && gaux1 == 119 && baux1 == 218) {
                            System.out.println("x: " + x + " y:" + y);
                            break outerloop;
                        }

                    }
                }
                r1ant = r1;
                g1ant = g1;
                b1ant = b1;
            }
        }
        System.out.println("height1: " + height1 + " width1: " + width1);
    }
*/
    public int[] buscarEsquinaSuperiorIzquierda() {
        BufferedImage img1 = null;
        BufferedImage img2 = null;
        int[] xy = new int[2];
        try {
            File file1 = new File("c:\\imx.png"); // 
            img1 = ImageIO.read(file1);

        } catch (IOException e) {
            e.printStackTrace();
        }
        int width1 = img1.getWidth(null);
        int height1 = img1.getHeight(null);


        long diff = 0;
        int r1ant = 0;
        int g1ant = 0;
        int b1ant = 0;

        outerloop:
        for (int y = 0; y < height1; y++) {
            for (int x = 0; x < width1; x++) {
                int rgb1 = img1.getRGB(x, y);

                int r1 = (rgb1 >> 16) & 0xff;
                int g1 = (rgb1 >> 8) & 0xff;
                int b1 = (rgb1) & 0xff;
                if (r1 == 41 && g1 == 120 && b1 == 219) {
                    if (r1ant == 113 && g1ant == 167 && b1ant == 196) {
                        int aux = img1.getRGB(x + 10, y);
                        int raux1 = (aux >> 16) & 0xff;
                        int gaux1 = (aux >> 8) & 0xff;
                        int baux1 = (aux) & 0xff;
                        if (raux1 == 42 && gaux1 == 119 && baux1 == 218) {
                            xy[0] = x + 76;
                            xy[1] = y + 25;
                            break outerloop;
                        }

                    }
                }
                r1ant = r1;
                g1ant = g1;
                b1ant = b1;
            }
        }
        System.out.println("retorna x: "+xy[0]+ " y:"+xy[1]);
        return xy;
    }
}
