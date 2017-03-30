
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ususario
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    String columnas[] = {"A", "B", "C", "D", "E", "F", "G", "H"};
    String tablero[][] = new String[8][8];
    String fnc = "";

    public Main() {
        initComponents();
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCheckBox1.setText("Permitir Enroque Blanco Flanco de Rey");

        jCheckBox2.setText("Permitir Enroque Blanco Flanco de Dama");

        jCheckBox3.setText("Permitir Enroque Negro Flanco de Rey");

        jCheckBox4.setText("Permitir Enroque Negro Flanco de Dama");

        jButton1.setText("Capturar Pantallazo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("Juegan las Blancas");

        jRadioButton2.setText("Juegan las negras");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    public void actuar() {
        try {
            jTextArea1.setText("");
            Thread.sleep(1000);
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(image, "png", new File("c:\\imx.png"));


            Toolkit tk = Toolkit.getDefaultToolkit(); //Toolkit class returns the default toolkit
            Dimension d = tk.getScreenSize();
            Pixeles localizador = new Pixeles();
            int[] xy = localizador.buscarEsquinaSuperiorIzquierda();
//Dimension class object stores width & height of the toolkit screen
// toolkit.getScreenSize() determines the size of the screen
            Rectangle rec = new Rectangle(xy[0], xy[1], 448, 448);
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
                        if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_blanco\\espacio.jpg")) {
                            tablero[fila][y] = "1";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_blanco\\pb.jpg")) {
                            tablero[fila][y] = "P";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_blanco\\PN.jpg")) {
                            tablero[fila][y] = "p";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_blanco\\ab.jpg")) {
                            tablero[fila][y] = "B";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_blanco\\AN.jpg")) {
                            tablero[fila][y] = "b";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_blanco\\cb.jpg")) {
                            tablero[fila][y] = "N";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_blanco\\CN.jpg")) {
                            tablero[fila][y] = "n";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_blanco\\tb.jpg")) {
                            tablero[fila][y] = "R";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_blanco\\TN.jpg")) {
                            tablero[fila][y] = "r";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_blanco\\db.jpg")) {
                            tablero[fila][y] = "Q";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_blanco\\DN.jpg")) {
                            tablero[fila][y] = "q";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_blanco\\rb.jpg")) {
                            tablero[fila][y] = "K";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_blanco\\RN.jpg")) {
                            tablero[fila][y] = "k";
                        }
                    } else {
                        if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_negro\\espacio.jpg")) {
                            tablero[fila][y] = "1";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_negro\\pb.jpg")) {
                            tablero[fila][y] = "P";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_negro\\PN.jpg")) {
                            tablero[fila][y] = "p";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_negro\\ab.jpg")) {
                            tablero[fila][y] = "B";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_negro\\AN.jpg")) {
                            tablero[fila][y] = "b";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_negro\\cb.jpg")) {
                            tablero[fila][y] = "N";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_negro\\CN.jpg")) {
                            tablero[fila][y] = "n";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_negro\\tb.jpg")) {
                            tablero[fila][y] = "R";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_negro\\TN.jpg")) {
                            tablero[fila][y] = "r";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_negro\\db.jpg")) {
                            tablero[fila][y] = "Q";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_negro\\DN.jpg")) {
                            tablero[fila][y] = "q";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_negro\\rb.jpg")) {
                            tablero[fila][y] = "K";
                        } else if (dif.compararImagenes("c:\\recortes\\" + columnas[y] + "" + (x + 1) + ".jpg", "\\recortesCompilado\\fondo_negro\\RN.jpg")) {
                            tablero[fila][y] = "k";
                        }
                    }
                }
                fila++;
            }

            if (jRadioButton1.isSelected()) {
                fnc = "";
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        fnc += "" + tablero[x][y];
                    }

                    if (x + 1 != 8) {
                        fnc += "/";
                    }

                }

                fnc += " w ";
            } else {
                fnc = "";
                for (int x = 7; x >= 0; x--) {
                    for (int y = 7; y >= 0; y--) {
                        fnc += "" + tablero[x][y];
                    }
                    if (x != 0) {
                        fnc += "/";
                    }
                }

                fnc += " b ";
            }
            if (jCheckBox1.isSelected()) {
                fnc += "K";
            }
            if (jCheckBox2.isSelected()) {
                fnc += "Q";
            }
            if (jCheckBox3.isSelected()) {
                fnc += "k";
            }
            if (jCheckBox4.isSelected()) {
                fnc += "q";
            }

            //System.out.println(""+fnc);    
            jTextArea1.setText(fnc);

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection data = new StringSelection("" + fnc);
            clipboard.setContents(data, data);



            //ImageIO is an API which is used to convert BufferedImage to a png/jpg image     
        } catch (Exception ex) {
            System.out.println("ha ocurrido un error" + ex.getMessage());
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        actuar();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
