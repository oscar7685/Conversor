/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ususario
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class HelloWorldFrame extends JFrame implements ActionListener, ComponentListener {

    JButton b;//Reference of Button component of Swing
    JCheckBox chx1, chx2, chx3, chx4;
    String columnas[] = {"A", "B", "C", "D", "E", "F", "G", "H"};
    String tablero[][] = new String[8][8];
    String fnc = "";

    public HelloWorldFrame() {
        this.setVisible(true);
        this.setLayout(null);
        b = new JButton("Click Here");
        b.setBounds(10, 10, 120, 60);// It changes layout related information and takes x-coordinate,y-coordinate,width and height as the parameters
        b.setBackground(Color.red);
        b.setVisible(true);
        b.addActionListener(this);// Adding ActionListener on the Button
        add(b);
        setSize(300, 300);// sets the width & height of the window
        //addComponentListener(this);
        //actuar();

    }

    public void actuar() {
        try {
            Thread.sleep(1000);
            Toolkit tk = Toolkit.getDefaultToolkit(); //Toolkit class returns the default toolkit
            Dimension d = tk.getScreenSize();

//Dimension class object stores width & height of the toolkit screen
// toolkit.getScreenSize() determines the size of the screen
            Rectangle rec = new Rectangle(654, 418, 448, 448);
            // Rectangle rec = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
//Creates a Rectangle with screen dimensions, here we are capturing the entire screen,if you want you can change it accordingly (i.e you can also capture a particular area on the screen)          

            Robot ro = new Robot(); //a very important class to capture the screen image
            BufferedImage img = ro.createScreenCapture(rec);

//createScreenCapture() method takes Rectangle class instance as argument and returns BufferedImage

            File f;
            f = new File("C:\\myimage.jpg"); // File class is used to write the above generated buffered image to a file
            ImageIO.write(img, "jpg", f);

            ImageSplitTest p = new ImageSplitTest();
            p.recortar();

            ImgDiffPercent dif = new ImgDiffPercent();

            int fila = 0;
            for (int x = 7; x >= 0; x--) {
                for (int y = 0; y < 8; y++) {
                    if ((y % 2 == 0 && x % 2 != 0) || (y % 2 != 0 && x % 2 == 0)) {
                        //System.out.println("y");
                        if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\espacio.jpg")) {
                            tablero[fila][y] = "1";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\pb.jpg")) {
                            tablero[fila][y] = "P";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\PN.jpg")) {
                            tablero[fila][y] = "p";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\ab.jpg")) {
                            tablero[fila][y] = "B";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\AN.jpg")) {
                            tablero[fila][y] = "b";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\cb.jpg")) {
                            tablero[fila][y] = "N";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\CN.jpg")) {
                            tablero[fila][y] = "n";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\tb.jpg")) {
                            tablero[fila][y] = "R";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\TN.jpg")) {
                            tablero[fila][y] = "r";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\db.jpg")) {
                            tablero[fila][y] = "Q";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\DN.jpg")) {
                            tablero[fila][y] = "q";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\rb.jpg")) {
                            tablero[fila][y] = "K";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\RN.jpg")) {
                            tablero[fila][y] = "k";
                        }
                    } else {
                        if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\espacio.jpg")) {
                            tablero[fila][y] = "1";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\pb.jpg")) {
                            tablero[fila][y] = "P";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\PN.jpg")) {
                            tablero[fila][y] = "p";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\ab.jpg")) {
                            tablero[fila][y] = "B";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\AN.jpg")) {
                            tablero[fila][y] = "b";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\cb.jpg")) {
                            tablero[fila][y] = "N";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\CN.jpg")) {
                            tablero[fila][y] = "n";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\tb.jpg")) {
                            tablero[fila][y] = "R";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\TN.jpg")) {
                            tablero[fila][y] = "r";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\db.jpg")) {
                            tablero[fila][y] = "Q";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\DN.jpg")) {
                            tablero[fila][y] = "q";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\rb.jpg")) {
                            tablero[fila][y] = "K";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\RN.jpg")) {
                            tablero[fila][y] = "k";
                        }
                    }
                }
                fila++;
            }

            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    fnc += "" + tablero[x][y];
                }
                fnc += "/";
            }

            fnc = fnc.substring(0, fnc.length() - 2);
            fnc += " w ";
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Puede enrrocar las Blancas por flanco de rey?");
            if (respuesta == 0) {
                fnc += "K";
            }

            respuesta = JOptionPane.showConfirmDialog(null, "¿Puede enrrocar las Blancas por flanco de dama?");
            if (respuesta == 0) {
                fnc += "Q";
            }
            respuesta = JOptionPane.showConfirmDialog(null, "¿Puede enrrocar las Negras por flanco de rey?");
            if (respuesta == 0) {
                fnc += "k";
            }
            respuesta = JOptionPane.showConfirmDialog(null, "¿Puede enrrocar las Negras por flanco de dama?");
            if (respuesta == 0) {
                fnc += "q";
            }

            System.out.println("" + fnc);

//ImageIO is an API which is used to convert BufferedImage to a png/jpg image     
        } catch (Exception ex) {
            System.out.println("ha ocurrido un error" + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)//This method is invoked when an action occurs 
    {
        if (e.getSource() == b) //It matches the object on which the event occurred
        {
            this.dispose();
            try {
                Thread.sleep(1000);
                Toolkit tk = Toolkit.getDefaultToolkit(); //Toolkit class returns the default toolkit
                Dimension d = tk.getScreenSize();

//Dimension class object stores width & height of the toolkit screen
// toolkit.getScreenSize() determines the size of the screen
                Rectangle rec = new Rectangle(654, 418, 448, 448);
                // Rectangle rec = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
//Creates a Rectangle with screen dimensions, here we are capturing the entire screen,if you want you can change it accordingly (i.e you can also capture a particular area on the screen)          

                Robot ro = new Robot(); //a very important class to capture the screen image
                BufferedImage img = ro.createScreenCapture(rec);

//createScreenCapture() method takes Rectangle class instance as argument and returns BufferedImage

                File f;
                f = new File("C:\\myimage.jpg"); // File class is used to write the above generated buffered image to a file
                ImageIO.write(img, "jpg", f);

                ImageSplitTest p = new ImageSplitTest();
                p.recortar();

                ImgDiffPercent dif = new ImgDiffPercent();

                int fila = 0;
                for (int x = 7; x >= 0; x--) {
                    for (int y = 0; y < 8; y++) {
                        if ((y % 2 == 0 && x % 2 != 0) || (y % 2 != 0 && x % 2 == 0)) {
                            //System.out.println("y");
                            if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\espacio.jpg")) {
                                tablero[fila][y] = "1";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\pb.jpg")) {
                                tablero[fila][y] = "P";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\PN.jpg")) {
                                tablero[fila][y] = "p";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\ab.jpg")) {
                                tablero[fila][y] = "B";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\AN.jpg")) {
                                tablero[fila][y] = "b";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\cb.jpg")) {
                                tablero[fila][y] = "N";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\CN.jpg")) {
                                tablero[fila][y] = "n";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\tb.jpg")) {
                                tablero[fila][y] = "R";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\TN.jpg")) {
                                tablero[fila][y] = "r";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\db.jpg")) {
                                tablero[fila][y] = "Q";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\DN.jpg")) {
                                tablero[fila][y] = "q";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\rb.jpg")) {
                                tablero[fila][y] = "K";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_blanco\\RN.jpg")) {
                                tablero[fila][y] = "k";
                            }
                        } else {
                            if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\espacio.jpg")) {
                                tablero[fila][y] = "1";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\pb.jpg")) {
                                tablero[fila][y] = "P";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\PN.jpg")) {
                                tablero[fila][y] = "p";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\ab.jpg")) {
                                tablero[fila][y] = "B";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\AN.jpg")) {
                                tablero[fila][y] = "b";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\cb.jpg")) {
                                tablero[fila][y] = "N";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\CN.jpg")) {
                                tablero[fila][y] = "n";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\tb.jpg")) {
                                tablero[fila][y] = "R";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\TN.jpg")) {
                                tablero[fila][y] = "r";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\db.jpg")) {
                                tablero[fila][y] = "Q";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\DN.jpg")) {
                                tablero[fila][y] = "q";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\rb.jpg")) {
                                tablero[fila][y] = "K";
                            } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "C:\\recortesCompilado\\fondo_negro\\RN.jpg")) {
                                tablero[fila][y] = "k";
                            }
                        }
                    }
                    fila++;
                }

                String fnc = "";
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        fnc += "" + tablero[x][y];
                    }
                    fnc += "/";
                }
                System.out.println("" + fnc);

//ImageIO is an API which is used to convert BufferedImage to a png/jpg image     
            } catch (Exception ex) {
                System.out.println("ha ocurrido un error" + ex.getMessage());
            }
        }
    }

   
    @Override
    public void componentMoved(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentShown(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void componentResized(ComponentEvent e) {
        System.out.println("X:" + this.getX() + " Y:" + this.getY() + " ancho:" + this.getWidth() + "alto:" + this.getHeight());
    }
}