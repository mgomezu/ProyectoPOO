package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlAutos {

    private ArrayList<Auto> autos = new ArrayList<>();

    public ControlAutos() throws FileNotFoundException {

        File lectura = new File("Autos.txt");
        Scanner flujoEntrada = null;

        if (lectura.exists()) {
            flujoEntrada = new Scanner(lectura);
            while (flujoEntrada.hasNext()) {
                int ID = flujoEntrada.nextInt();
                String marca = flujoEntrada.next();
                String modelo = flujoEntrada.next();
                String tipo = flujoEntrada.next();
                double Precio = Double.parseDouble(flujoEntrada.next());
                boolean disponible;
                if (flujoEntrada.next().equals("disponible")) {
                    disponible = true;
                } else {
                    disponible = false;
                }
                String ruta = flujoEntrada.next();
                int numero = Integer.parseInt(flujoEntrada.next());

                Auto auto = new Auto(ID, marca, modelo, tipo, Precio, disponible, ruta, numero);
                autos.add(auto);

            }
        }
    }

    public ArrayList ListaAutosDisponibles(String marca, String modelo, String tipo) throws IOException {
        ArrayList<Auto> autosDisponibles = new ArrayList<>();

        for (int i = 0; i < autos.size(); i++) {
            String marcaAuto = autos.get(i).getMarca();
            String modeloAuto = autos.get(i).getModelo();
            String tipoAuto = autos.get(i).getTipo();
            boolean disponibleAuto = autos.get(i).isDisponible();
            String Auto = marcaAuto + " " + modeloAuto + " " + tipoAuto;
            if (disponibleAuto) {
                if (marca.equals("Todos") && modelo.equals("Todos")
                        && tipo.equals("Todos")) {
                    autosDisponibles.add(autos.get(i));

                } else {
                    if (modelo.equals("Todos") && marca.equals("Todos")
                            && tipo.equals(tipoAuto)) {
                        autosDisponibles.add(autos.get(i));
                    } else {
                        if (modelo.equals("Todos") && marca.equals(marcaAuto)
                                && tipo.equals("Todos")) {
                            autosDisponibles.add(autos.get(i));
                        } else {
                            if (modelo.equals(modeloAuto) && marca.equals("Todos")
                                    && tipo.equals("Todos")) {
                                autosDisponibles.add(autos.get(i));
                            } else {
                                if (modelo.equals("Todos") && marca.equals(marcaAuto)
                                        && tipo.equals(tipoAuto)) {
                                    autosDisponibles.add(autos.get(i));
                                } else {
                                    if (modelo.equals(modeloAuto) && marca.equals("Todos")
                                            && tipo.equals(tipoAuto)) {
                                        autosDisponibles.add(autos.get(i));
                                    } else {
                                        if (modelo.equals(modeloAuto) && marca.equals(marcaAuto)
                                                && tipo.equals("Todos")) {
                                            autosDisponibles.add(autos.get(i));
                                        } else {
                                            if (modelo.equals(modeloAuto) && marca.equals(marcaAuto)
                                                    && tipo.equals(tipoAuto)) {
                                                autosDisponibles.add(autos.get(i));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        return autosDisponibles;
    }

    public double PrecioRenta(int tiempo, int precio, String boton) {
        double precioFinal = 0;
        double precioDia = precio * 22;
        double precioSemana = precio * 144;
        if (boton.equals("Horas")) {
            precioFinal = tiempo * precio;
        } else {
            if (boton.equals("Dias")) {
                precioFinal = precioDia * tiempo;
            } else {
                if (boton.equals("Semanas")) {
                    precioFinal = precioSemana * tiempo;
                }
            }
        }
        return precioFinal;
    }

}
