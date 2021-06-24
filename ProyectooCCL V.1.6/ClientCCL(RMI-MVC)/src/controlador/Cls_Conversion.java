

package controlador;

import java.io.FileInputStream;
import java.io.IOException;

public class Cls_Conversion {
     
    public static byte [] datos(FileInputStream valor) throws IOException{
         byte datos[] = new byte[1000000];
        int cont = 0;
        boolean final_ar = false;
        while (!final_ar) {
            int byte_entrada = valor.read();
            if (byte_entrada != -1) {
                datos[cont] = (byte) byte_entrada;
            }else{
                final_ar=true;
            }
            cont++;
        }
        return datos;
    }

}
