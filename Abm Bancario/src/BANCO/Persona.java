package BANCO;

import java.io.Serializable;

public class Persona implements Serializable {
    private static final long serialVersionUID = 1;
    public String Nombre;
    public String DNI;
    public transient String Password;
    Persona(){
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }



}
