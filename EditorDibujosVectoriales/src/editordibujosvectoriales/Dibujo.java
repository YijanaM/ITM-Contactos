package editordibujosvectoriales;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * 
 * @author Yijana
 */
public class Dibujo {

    private List<Trazo> dibujo;

    //metodo para cargar el dibujo desde un archivo plano
    public boolean desdeArchivo(String nombreArchivo) {
        boolean abierto = true;
        //Iniciar el dibujo vacio
        dibujo = new ArrayList<>();
        BufferedReader br = Archivo.abrirArchivo(nombreArchivo);
        //se pudo abrir el archivo?
        if (br != null) {
            try {
                //Leer primera linea del archivo
                String linea = br.readLine();
                while (linea != null) {
                    //crear el trazo
                    String[] datos = linea.split(";");
                    Tipo tipo = null;

                    //buscar el tipo de trazo
                    for (int i = 0; i < Tipo.values().length; i++) {
                        if (Tipo.values()[i].toString().equals(datos[0])) {
                            tipo = Tipo.values()[i];
                        }
                    }
                    //obtener las coordenadas
                    int x1 = Integer.parseInt(datos[1]);
                    int y1 = Integer.parseInt(datos[2]);
                    int x2 = Integer.parseInt(datos[3]);
                    int y2 = Integer.parseInt(datos[4]);

                    Trazo p = new Trazo(x1, y1, x2, y2, tipo);
                    //agregarla al dibujo
                    dibujo.add(p);
                    //leer la siguiente linea
                    linea = br.readLine();
                }
            } catch (IOException ex) {
                abierto = false;
            }
        } else {
            abierto = false;
        }

        return abierto;
    }//abrir

    public void dibujar(JPanel pnl) {
        Graphics g = pnl.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, pnl.getWidth(), pnl.getHeight());
        for (Trazo p : dibujo) {
            p.dibujar(pnl);
        }
    }

    public Trazo buscar(int x, int y) {
        for (Trazo p : dibujo) {
            if (p.contiene(x, y)) {
                return p;
            }

        }
        return null;
    }

}
