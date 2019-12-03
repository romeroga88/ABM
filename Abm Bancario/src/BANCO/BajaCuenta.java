package BANCO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BajaCuenta {
    public void Eliminar() {
        GestorFicheroSerializado<Cuenta> gestor = new GestorFicheroSerializado<Cuenta>("resumen.txt");
        Scanner read = new Scanner(System.in);
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        Cuenta d;
        int op, opc;

        try {
            fis = new FileInputStream("resumen.txt");
            entrada = new ObjectInputStream(fis);
            d = (Cuenta) entrada.readObject();
            System.out.println("Ingrese N° de cuenta para borrar cuenta");
            opc = read.nextInt();
            d = new Cuenta(opc);
            System.out.println(gestor.existeDato(d));
            if (gestor.existeDato(d)){
                gestor.borrarDato(d);
            }
            else {
                System.out.println("La cuenta no se encuentra");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
