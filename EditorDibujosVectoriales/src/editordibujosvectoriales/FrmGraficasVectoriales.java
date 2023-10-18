
package editordibujosvectoriales;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Yijana
 */
public class FrmGraficasVectoriales extends javax.swing.JFrame {

    boolean inicioTrazo;
    int x1, y1;
    Dibujo d;
    List<Trazo> trazos = new ArrayList<>();
    ListaLigada listaLigada;

    public FrmGraficasVectoriales() {
        initComponents();
        inicioTrazo = false;
        d = new Dibujo();
        listaLigada = new ListaLigada();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGraficas = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        txtResultado = new javax.swing.JTextField();
        cbxTipoTrazo = new javax.swing.JComboBox<>();
        btnEliminarDibujo = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dibujos Vectoriales");
        setLocation(new java.awt.Point(200, 200));

        pnlGraficas.setBackground(new java.awt.Color(0, 0, 0));
        pnlGraficas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlGraficasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlGraficasLayout = new javax.swing.GroupLayout(pnlGraficas);
        pnlGraficas.setLayout(pnlGraficasLayout);
        pnlGraficasLayout.setHorizontalGroup(
            pnlGraficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlGraficasLayout.setVerticalGroup(
            pnlGraficasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        jToolBar1.setRollover(true);

        txtResultado.setEditable(false);
        txtResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResultadoActionPerformed(evt);
            }
        });
        jToolBar1.add(txtResultado);

        cbxTipoTrazo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo Trazo", "LINEA", "RECTANGULO", "CIRCULO" }));
        cbxTipoTrazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoTrazoActionPerformed(evt);
            }
        });
        jToolBar1.add(cbxTipoTrazo);

        btnEliminarDibujo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Eliminar.png"))); // NOI18N
        btnEliminarDibujo.setFocusable(false);
        btnEliminarDibujo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarDibujo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarDibujo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDibujoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminarDibujo);

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Abrir.png"))); // NOI18N
        btnAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAbrir);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Guardar.png"))); // NOI18N
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
            .addComponent(pnlGraficas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGraficas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlGraficasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlGraficasMouseClicked
        int x = evt.getX();
        int y = evt.getY();
        Graphics g = pnlGraficas.getGraphics();
            txtResultado.setText("x=" + String.valueOf(x) + ", y=" + String.valueOf(y));
            if (!inicioTrazo) {
                inicioTrazo = true;
                x1 = x;
                y1 = y;
            } else {
                inicioTrazo = false;
                /*
                int ancho = x - x1 + 1;
                    if (x < x1) {
                        ancho = -ancho;
                        x1 = x;
                    }
                    int alto = y - y1;
                    if (y < y1) {
                        alto = -alto;
                        y1 = y;
                    }*/
                 // Calcular ancho y alto de manera adecuada
                int ancho = Math.abs(x - x1); // Valor absoluto para que siempre sea positivo
                int alto = Math.abs(y - y1);  // Valor absoluto para que siempre sea positivo

                // Calcular las coordenadas de inicio de manera adecuada
                int inicioX = Math.min(x, x1);
                int inicioY = Math.min(y, y1);
                
                
               // Dibuja según el tipo de trazo seleccionado
               Tipo trazoSeleccionado = Tipo.valueOf(cbxTipoTrazo.getSelectedItem().toString().toUpperCase());
               Trazo trazo = new Trazo(x1, y1, x, y, trazoSeleccionado);
               
                System.err.println("trazoSeleccionado: "+ trazoSeleccionado);
               switch (trazoSeleccionado) {
                   case LINEA:
                       g.setColor(Color.WHITE);
                       g.drawLine(inicioX, inicioY, x, y);
                       listaLigada.agregar(trazo);
                       break;
                   case RECTANGULO:
                       g.setColor(Color.WHITE);
                       g.drawRect(inicioX, inicioY, ancho, alto);
                       listaLigada.agregar(trazo);
                       break;
                   case CIRCULO:
                       g.setColor(Color.WHITE);
                       g.drawOval(inicioX, inicioY, ancho, alto);
                       listaLigada.agregar(trazo);
                       break;
                   default:
                       break;
               }
            }
    }//GEN-LAST:event_pnlGraficasMouseClicked

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        String nombreArchivo = Archivo.elegirArchivo("Seleccionar archivo", "Abrir", "*.*", "Todos los archivos");
        txtResultado.setText(nombreArchivo);
        if (nombreArchivo.length() > 0) {
            d.desdeArchivo(nombreArchivo);
            d.dibujar(pnlGraficas);
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void txtResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResultadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResultadoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombreArchivo = Archivo.elegirArchivo("Guardar archivo", "Guardar", "*.txt", "Archivos de texto");
        if (nombreArchivo != null) {
            Archivo.guardarDibujo(nombreArchivo, listaLigada);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cbxTipoTrazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoTrazoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoTrazoActionPerformed

    private void btnEliminarDibujoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDibujoActionPerformed
        eliminarDibujo();
    }//GEN-LAST:event_btnEliminarDibujoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGraficasVectoriales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnEliminarDibujo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxTipoTrazo;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel pnlGraficas;
    private javax.swing.JTextField txtResultado;
    // End of variables declaration//GEN-END:variables

   
    private void eliminarUltimoTrazo() {
        if (!trazos.isEmpty()) {
            listaLigada.eliminarUltimo();
            pnlGraficas.repaint(); 
        }
    }
    
    private void eliminarDibujo() {
       repaint();
    }
}
