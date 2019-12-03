package BANCO;


import java.io.*;
import java.util.ArrayList;

public class GestorFicheroSerializado<T> {
    private File fichero;
    private ArrayList<T> datos;

    public GestorFicheroSerializado(String fichero) {
        this.fichero = new File(fichero);
        this.datos = new ArrayList();
        obtenerDatos();
    }

    public GestorFicheroSerializado(File fichero) {
        this.fichero = fichero;
        this.datos = new ArrayList();
        obtenerDatos();
    }

    public void obtenerDatos() {

        if (fichero.exists()) {

            T elemento;

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {

                while (true) {
                    elemento = (T) ois.readObject();
                    datos.add(elemento);
                }

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (EOFException ex) {
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    /**
     * Guarda el elemento T en el fichero y en la lista
     */
    public void guardarDato(T elemento) {

        if (fichero.exists() && fichero.length() > 0) {

            // Uso MiObjectOutputStream para evitar problemas de cabecera
            try (MiObjectOutputStream oos = new MiObjectOutputStream(new FileOutputStream(fichero, true))) {

                oos.writeObject(elemento);

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        } else {

            // Uso ObjectOutputStream para crear la cabecera
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {

                oos.writeObject(elemento);

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        datos.add(elemento);

    }

    /**
     * Obtengo los datos
     */
    public ArrayList<T> getDatos() {
        return datos;
    }

    /**
     * Muestra los datos de la lista
     */
    public void mostrarDatos() {
        for (T e : datos) {
            System.out.println(e);
        }
    }

    public boolean existeDato(T elemento) {

        for (T e : datos) {
            if (e.equals(elemento)) {
                return true;
            }
        }

        return false;

    }

    public void borrarDato(T elemento) {
        if (datos.remove(elemento)) {
            ArrayList<T> copia = datos; //hacemos una copia de los datos del array
            datos = new ArrayList<>();

            fichero.delete();

            for (T e : copia) {
                guardarDato(e);
            }
        }

    }

    public void get(int i) {
        System.out.println(datos.get(i));
    }

}
