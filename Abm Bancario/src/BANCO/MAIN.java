package BANCO;

import java.util.Scanner;

public class MAIN {

    private static void VerMenu() {
        System.out.println("\t.:::BANCO:::.\n\t:::MENU:::\n1 - Crear Cuenta.\n2 - Eliminar Cuenta.\n3 - Modificar Cuenta.\n4 - Consultas.\n5 - Salir");
    }

    static void Consultar() {
        System.out.println(" :::CONSULTAS:::\n1 - Nombre.\n2 - DNI.\n3 - N° de Cuenta.\n4 - Saldo.\n5 - Volver.");
    }

    static void ModCuenta() {
        System.out.println(":::MODIFICAR CUENTA:::\n1 - Nombre.\n2 - DNI.\n3 - N° de cuenta.\n4 - Saldo.\n5 - Volver.");
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int op;
        do {
            VerMenu();
            op = read.nextInt();
            switch (op) {
                case 1:
                    AltaCuenta a = new AltaCuenta();
                    a.alta();
                    break;
                case 2:
                    BajaCuenta b = new BajaCuenta();
                    b.Eliminar();
                    break;
                case 3:
                    ModificarCuenta m = new ModificarCuenta();
                    m.Modificar();
                    break;
                case 4:
                    Consultas ver = new Consultas();
                    ver.Consultar();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opcion ingresada incorrecta.");
            }
        } while (op != 5);


    }
}
