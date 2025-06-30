package org.example;
import javax.swing.*;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Organizacion {
    public Organizacion(Torneo torneo, boolean EDO){


        InputStream is = Organizacion.class.getClassLoader().getResourceAsStream("Deportistas.txt");

        if (is == null) {
            System.out.println("Archivo no encontrado.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(" ");
                if(EDO){
                    for (int i = 0; i < palabras.length; i += 3) {
                        try {
                            String nombre = palabras[i];
                            String contacto = palabras[i + 1];
                            int edad = Integer.parseInt(palabras[i + 2]);
                            torneo.agregarParticipantes(new Deportista(nombre, contacto, edad));
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                else{
                    try {
                        for (int i = 0; i < palabras.length; i += 5) {
                            String nombre = palabras[i];
                            String contacto = palabras[i + 1];
                            int edad = Integer.parseInt(palabras[i + 2]);
                            torneo.agregarParticipantes(new Deportista(nombre, contacto, edad));
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
