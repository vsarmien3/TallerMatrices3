/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author USUARIO
 */
public class Helper {
    public static int mensaje(Component ventana, String info, String titulo, int tipo) {
        int retorno = -1;
        switch (tipo) {
            case 1:
                JOptionPane.showMessageDialog(ventana, info, titulo, JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(ventana, info, titulo, JOptionPane.ERROR_MESSAGE);
                break;
            case 3:
                retorno = JOptionPane.showConfirmDialog(ventana, info, titulo, JOptionPane.YES_NO_OPTION);
                break;
        }
        return retorno;
    }

    public static String recibirDatos(Component ventana, String info) {
        String aux;
        aux = JOptionPane.showInputDialog(ventana, info);
        return aux;
    }

    public static void habilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(true);

        }
    }

    public static void deshabilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(false);

        }
    }

    public static void limpiarTabla(JTable tabla) {
        int nf, nc;
        nf = tabla.getRowCount();
        nc = tabla.getColumnCount();

        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {

                tabla.setValueAt("", i, j);
            }
        }
    }

    public static void tablaPorDefecto(JTable tabla) {
        DefaultTableModel tm;
        tm = (DefaultTableModel) tabla.getModel();
        tm.setColumnCount(0);
        tm.setRowCount(0);

    }

    public static int cantidadNumerosPares(JTable tabla) {
        int nf, nc, aux, cont = 0;
        nf = tabla.getRowCount();
        nc = tabla.getColumnCount();
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {

                aux = (int) tabla.getValueAt(i, j);
                if (aux % 2 == 0) {
                    cont++;
                }

            }

        }

        return cont;
    }

    public static void numerosPares(JTable tabla1, JTable tabla2) {
        int nf, nc, aux;
        nf = tabla1.getRowCount();
        nc = tabla1.getColumnCount();
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {

                aux = (int) tabla1.getValueAt(i, j);
                if (aux % 2 == 0) {
                    tabla2.setValueAt(aux, i, j);
                }
            }
        }
    }

    public static void diagonalPrincipal(JTable tabla1, JTable tabla2) {
        int nf, nc, aux;
        nf = tabla1.getRowCount();
        nc = tabla1.getColumnCount();
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {

                aux = (int) tabla1.getValueAt(i, j);
                if (i == j) {
                    tabla2.setValueAt(aux, i, j);
                }
            }
        }
    }

    public static void letraC(JTable tabla1, JTable tabla2) {
        int nf, nc, aux;
        nf = tabla1.getRowCount();
        nc = tabla1.getColumnCount();
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {

                aux = (int) tabla1.getValueAt(i, j);
                if (i == 0 || j == 0 || i == nf - 1) {
                    tabla2.setValueAt(aux, i, j);
                }

            }

        }

    }

    public static void letraH(JTable tabla1, JTable tabla2) {
        int nf, nc, aux;
        nf = tabla1.getRowCount();
        nc = tabla1.getColumnCount();
        for (int i = 0; i < nf; i++) {
            for (int j = 0; j < nc; j++) {

                aux = (int) tabla1.getValueAt(i, j);
                if (j == 0 || j == nc - 1 || i == (nf - 1) / 2) {
                    tabla2.setValueAt(aux, i, j);
                }

            }

        }
    }

    public static int[][] pasarDatosMatriz(JTable tabla1) {
        int nf, nc;
        nf = tabla1.getRowCount();
        nc = tabla1.getColumnCount();
        int m[][] = new int[nf][nc];

        for (int i = 0; i < m.length; i++) {

            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int) tabla1.getValueAt(i, j);
            }
        }
        return m;
    }

    public static String recorridoHaciaArriba(int m[][], int j) {
        String aux = "";
        int nf = m.length;
        for (int i = (nf - 1); i >= 0; i--) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }

    public static String recorridoHaciaArriba(int m[][], int j, int in, int fin) {
        String aux = "";
        for (int i = in; i >= fin; i--) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }

    public static String recorridoHaciaAbajo(int m[][], int j) {
        String aux = "";
        int nf = m.length;
        for (int i = 0; i < nf; i++) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }

    public static String recorridoHaciaAbajo(int m[][], int j, int in, int fin) {
        String aux = "";
        for (int i = in; i < fin; i++) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }

    public static String recorridoUno(JTable tabla1) {
        int m[][] = pasarDatosMatriz(tabla1);
        int nc = m[0].length;
        String aux = "";

        for (int j = 0; j < nc; j++) {
            if (j % 2 == 0) {
                aux = aux + recorridoHaciaArriba(m, j);
            } else {
                aux = aux + recorridoHaciaAbajo(m, j);
            }

        }
        aux = aux.substring(0, aux.length() - 2);
        return aux;
    }

    public static String recorridoHaciaIzquierda(int[][] m, int i) {
        String aux = "";
        int nc = m[0].length;

        for (int j = (nc - 1); j >= 0; j--) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }

    public static String recorridoHaciaIzquierda(int[][] m, int i, int in, int fin) {
        String aux = "";

        for (int j = in; j >= fin; j--) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }

    public static String recorridoHaciaDerecha(int[][] m, int i) {
        String aux = "";
        int nc = m[0].length;

        for (int j = 0; j < nc; j++) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }

    public static String recorridoHaciaDerecha(int[][] m, int i, int in, int fin) {
        String aux = "";

        for (int j = in; j <= fin; j++) {
            aux = aux + m[i][j] + ", ";
        }
        return aux;
    }

     public static String recorridoDiagonalSecundariaAbajo(int[][] m) {
        String aux = "";
        int nf = m.length;
        int nc = m[0].length;

         for (int i = 0; i <nf; i++) {
             aux = aux + m[i][nc-1-i] + ", ";
         }

        return aux;
    }
     
      public static String recorridoDiagonalSecundariaArriba(int[][] m) {
        String aux = "";
        int nf = m.length;
        int nc = m[0].length;

         for (int i = nf-1; i >=0; i--) {
             aux = aux + m[i][nc-1-i] + ", ";
         }

        return aux;
    }
      
      public static String recorridoDiagonalSecundariaArriba(int[][] m,int in, int fin) {
        String aux = "";
        int nf = m.length;
        int nc = m[0].length;

         for (int i = in; i >=fin; i--) {
             aux = aux + m[i][nc-1-i] + ", ";
         }

        return aux;
    }
     
      public static String recorridoDiagonalSecundariaAbajo(int[][] m, int in, int fin) {
        String aux = "";
         int nc = m[0].length;
         for (int i = in; i <=fin; i++) {
              aux = aux + m[i][nc-1-i] + ", ";
         }

        return aux;
    }
    
    public static String recorridoDiagonalPrincipalAbajo(int[][] m) {
        String aux = "";
        int nf = m.length;
     

        for (int i = 0; i < nf; i++) {
            aux = aux + m[i][i] + ", ";
        }

        return aux;
    }
    
    public static String recorridoDiagonalPrincipalArriba(int[][] m) {
        String aux = "";
        int nf = m.length;
     

        for (int i = (nf-1); i >= 0; i--) {
            aux = aux + m[i][i] + ", ";
        }

        return aux;
    }
    
     public static String recorridoDiagonalPrincipalArriba(int[][] m, int in, int fin) {
        String aux = "";
  
        for (int i = in; i >= fin; i--) {
            aux = aux + m[i][i] + ", ";
        }

        return aux;
    }

    public static String recorridoDiagonalPrincipalAbajo(int[][] m, int in, int fin) {
        String aux = "";

        for (int i = in; i <= fin; i++) {
            aux = aux + m[i][i] + ", ";
        }

        return aux;
    }

    public static String recorridoDos(JTable tabla1) {
        int[][] m = pasarDatosMatriz(tabla1);
        int nf = m.length;
        String aux = "";
        for (int i = 0; i < nf; i++) {
            if (i % 2 == 0) {
                aux = aux + Helper.recorridoHaciaIzquierda(m, i);
            } else {
                aux = aux + Helper.recorridoHaciaDerecha(m, i);
            }

        }
        aux =aux.substring(0, aux.length() - 2);
        return aux;
    }
    
    
    
    public static String recorridoTres(JTable tabla){
        int m[][],in,fin,nf,nc;
        m = pasarDatosMatriz(tabla);
        String aux = "";
        nf = m.length;
        nc = m[0].length;
        in=0;
        fin = nf/2;
        aux = aux + Helper.recorridoDiagonalPrincipalAbajo(m, in, fin);
        in = fin+1;
        fin = nf - 1;
        aux = aux + Helper.recorridoDiagonalSecundariaAbajo(m, in, fin);
        aux = aux + Helper.recorridoHaciaDerecha(m, fin, 1, nc-1);
        aux = aux.substring(0, aux.length() - 2);
        return aux;
           
    }
    public static String mostrar(int[][] m){
       String aux ="";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
               aux = aux + m[i][j] + " ";           
            }
            aux = aux + "\n";    
        }
        return aux;
    }
    
    
}
