package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.DronGenerico;
import modelo.DronMaritimo;
import modelo.DronMontana;

/**
 * Clase principal para ejecutar la simulación de la flota de drones
 * * @author kenneth
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE DRONES - SIMULACIÓN ===\n");

        //  Creación de la flota utilizando polimorfismo
        List<DronGenerico> flota = new ArrayList<>();

        // Añadimos un dron marítimo y uno de montaña
        flota.add(new DronMaritimo(1, 120, 50, true, 25));   // Resistencia baja (<30), penaliza tiempo
        flota.add(new DronMontana(2, 60, 40, true, 1.5));  // Con factor de altitud 1.5

        // Definición de misiones de prueba
        int[] misiones = {10, 50, -5}; // Distancias en km

        //  Procesamiento de misiones
        for (DronGenerico dron : flota) {
            System.out.println("------------------------------------------------");
            System.out.println("PROCESANDO DRON ID: " + dron.getId() + " [" + dron.getClass().getSimpleName() + "]");
            
            for (int distancia : misiones) {
                try {
                    System.out.print("Misión de " + distancia + " km: ");
                    dron.tiempoRespuesta(distancia);
                } catch (IllegalStateException e) {
                    System.err.println("ERROR DE ESTADO: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println("ERROR DE DATO: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("ERROR INESPERADO: " + e.getMessage());
                }
            }
        }

        //  Prueba de dron inoperativo
        System.out.println("\n------------------------------------------------");
        System.out.println("PRUEBA DE SEGURIDAD: Dron apagado");
        DronMaritimo dronApagado = new DronMaritimo(3, 100, 10, false, 80);
        try {
            dronApagado.tiempoRespuesta(10);
        } catch (IllegalStateException e) {
            System.out.println("Confirmado: El sistema bloqueó la misión. Motivo: " + e.getMessage());
        }

        System.out.println("\n=== FIN DE LA SIMULACIÓN ===");
    }
}