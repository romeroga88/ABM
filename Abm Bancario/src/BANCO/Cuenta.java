package BANCO;

import java.util.Objects;

public class Cuenta extends Persona {
    public int NumCuenta;
    public float Saldo;
    Cuenta(int NumCuenta) {
        this.NumCuenta=NumCuenta;
    }

    public int getNumCuenta() {
        return NumCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        NumCuenta = numCuenta;
    }

    public float getSaldo() {
        return Saldo;
    }

    public void setSaldo(float saldo) {
        Saldo = saldo;
    }
    @Override
    public String toString(){
        int c = 0;
        return "Cuenta: "+"Nombre "+Nombre+" DNI: "+DNI+" N° de Cuenta: "+NumCuenta+" Saldo: "+Saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cuenta)) return false;
        Cuenta cuenta = (Cuenta) o;
        return getNumCuenta() == cuenta.getNumCuenta();
    }
    public void recibirAbono(float abono) {
        this.Saldo =Saldo + abono;
        System.out.println("Abono acreditado correctamente");
    }
    public void pagarRecibo(float abono) {
        if (this.Saldo >= abono) {
            this.Saldo = Saldo- abono;
            System.out.println("Recibo pagado correctamente");
        } else System.out.println("Saldo insuficiente para pagar el recibo");
    }
}
