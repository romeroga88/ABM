package BANCO;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ModificarCuenta {
    private void menu() {
        System.out.println("\t::MENU::\n1 - Modificar cuenta completa.\n2 - Agregar saldo.\n3 - Pagar Abono.\n4 - salir.");
    }

    public void Modificar() {
        GestorFicheroSerializado<Cuenta> gestor = new GestorFicheroSerializado<Cuenta>("resumen.bin");
        Scanner read = new Scanner(System.in);
        Scanner reads = new Scanner(System.in);
        FileInputStream fis = null;
        File fos = null;
        ObjectInputStream entrada = null;
        Cuenta d, c;
        int op, opc;
        float saldo;
        String entra;
        try {
            fos = new File("resumen.bin");
            fis = new FileInputStream("resumen.bin");
            entrada = new ObjectInputStream(fis);
            d = (Cuenta) entrada.readObject();
            gestor.mostrarDatos();
            System.out.println("Ingrese N° de cuenta para modificar cuenta");
            opc = read.nextInt();
            gestor.get(opc);
            if(gestor.existeDato(d)) {
                do {
                    menu();
                    op = read.nextInt();
                    switch (op) {
                        case 1:
                            System.out.print("Ingrese nombre: ");
                            entra = reads.nextLine();
                            d.setNombre(entra);
                            System.out.print("Ingrese DNI: ");
                            entra = reads.nextLine();
                            d.setDNI(entra);
                            d.setNumCuenta(opc);
                            System.out.print("Ingrese Contraseña: ");
                            entra = reads.nextLine();
                            d.setPassword(entra);
                            System.out.print("Ingrese saldo a cargar: ");
                            saldo = read.nextFloat();
                            d.setSaldo(saldo);
                            ObjectOutputStream salida;
                            salida = new MiObjectOutputStream(new FileOutputStream(fos,true));
                            //salida.writeObject(d);
                            gestor.guardarDato(d);
                            salida.close();
                            break;
                        case 2:
                            System.out.println("Ingrese saldo a su cuenta");
                            saldo = read.nextFloat();
                            d.recibirAbono(saldo);
                            gestor.guardarDato(d);
                            break;
                        case 3:
                            System.out.println("Ingrese saldo a pagar");
                            saldo = read.nextFloat();
                            d.pagarRecibo(saldo);
                            gestor.guardarDato(d);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Opcion ingresada incorrecta");
                            break;
                    }

                } while (op != 4);
            }
            else
                System.out.println("El N° de cuenta no existe");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();    //cierro el archivo.
                }
                if (entrada != null) {
                    entrada.close();    //cierro el lector de bajo nivel.
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
