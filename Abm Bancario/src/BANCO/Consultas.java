package BANCO;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.Scanner;

public class Consultas {
    public void Consultar() {
        GestorFicheroSerializado<Cuenta> gestor = new GestorFicheroSerializado<Cuenta>("resumen.bin");
        Scanner read = new Scanner(System.in);
        FileInputStream fi = null;
        ObjectInputStream entrad = null;
        int op;
        try {
            fi = new FileInputStream("resumen.bin");
            entrad = new ObjectInputStream(fi);
            System.out.println("1 - Lista de clientes\n2 - salir.");
            op = read.nextInt();
            if (op == 1) {
                System.out.println("Ingrese N° de cuenta a consultar");
                int opc = read.nextInt();
                Cuenta c = new Cuenta(opc);
                if (gestor.existeDato(c)) {
                    gestor.get(opc);
                }
                else
                    System.out.println("La cuenta no se encuentra");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            if (fi != null) {
                fi.close();    //cierro el archivo.
            }
            if (entrad != null) {
                entrad.close();    //cierro el lector de bajo nivel.
            }
        } catch (EOFException e) {
            System.out.println("No hay mas datos que mostrar");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
