
package Modelo;

import javafx.scene.image.Image;


public class Auto {
    private int ID;
    private String marca;
    private String modelo;
    private String tipo;
    private boolean disponible;
    private String imagen;
    private double Precio;
    private int NRentado;
//2724 mazda 2016  manual 9000.0 disponible C:\Users\mivil\Downloads\renault2016.png
    public Auto(int ID, String marca, String modelo, String tipo, double Precio, boolean disponible,String imagen,int NRentado) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.disponible = disponible;
        this.ID = ID;
        this.imagen = imagen;
        this.Precio = Precio;
        this.NRentado = NRentado;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
    

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNRentado() {
        return NRentado;
    }

    public void setNRentado(int NRentado) {
        this.NRentado = NRentado;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public int getID() {
        return ID;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return Precio;
    }

    @Override
    public String toString() {
        return "Auto{" + "ID=" + ID + ", marca=" + marca + ", modelo=" + modelo + ", tipo=" + tipo + ", disponible=" + disponible + ", imagen=" + imagen + ", Precio=" + Precio + '}';
    }
    
    
    
    
}
