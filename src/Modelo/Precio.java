
package Modelo;


public class Precio {
    
    public double PrecioRenta(double tiempo, double precio, String boton){
        double precioFinal = 0;
        double precioDia = precio*22;
        double precioSemana = precio*144;
        if(boton.equals("Horas")){
            precioFinal = tiempo*precio;
        }else{
        if(boton.equals("Dias")){
            precioFinal = precioDia*tiempo;
        }else{
        if(boton.equals("Semanas")){
            precioFinal = precioSemana*tiempo;
        }
        }
        }
        return precioFinal;
    }
}
