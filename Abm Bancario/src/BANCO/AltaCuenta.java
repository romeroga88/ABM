package BANCO;

import java.io.*;
import java.util.Scanner;

public class AltaCuenta {
    Scanner read = new Scanner(System.in);
    Scanner reads = new Scanner(System.in);

    public void alta() {
        GestorFicheroSerializado<Cuenta> gestor = new GestorFicheroSerializado<Cuenta>("resumen.bin");
        File fos;
        Cuenta c;
        String entrada;
        int num, op;
        int cn = 0;
        float saldo;
        try {
            fos = new File("resumen.bin");
            fos.createNewFile();
            do {
                c = new Cuenta(cn);
                System.out.print("Ingrese nombre: ");
                entrada = reads.nextLine();
                c.setNombre(entrada);
                System.out.print("Ingrese DNI: ");
                entrada = reads.nextLine();
                c.setDNI(entrada);
                System.out.print("Ingrese Contraseña: ");
                entrada = reads.nextLine();
                c.setPassword(entrada);
                System.out.print("Ingrese saldo a cargar: ");
                saldo = read.nextFloat();
                c.setSaldo(saldo);
                ObjectOutputStream salida;
                if (fos.length() == 0) {
                    salida = new ObjectOutputStream(new FileOutputStream(fos));
                } else {
                    salida = new MiObjectOutputStream(new FileOutputStream(fos, true));
                }
                //salida.writeObject(c);
                cn++;
                gestor.guardarDato(c);
                salida.close();
                System.out.println("Ingresar otro cliente.\n 1 - Si.\t2 - volver al menu anterior.");
                op = read.nextInt();
            } while (op != 2);
        } catch (IOException e) {
            System.out.println(e);

        }

    }
}
