package org.example;
import javax.swing.*;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Organizacion {
    public Organizacion(Torneo torneo, boolean EDO){
        InputStream is = Organizacion.class.getClassLoader().getResourceAsStream("Equipos.txt");

        if (is == null) {
            System.out.println("Archivo no encontrado.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if(EDO){
                    String[] palabras = linea.split(" ");
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
                        String[] palabras = linea.split("\\$");
                        System.out.println(Arrays.toString(palabras));
                        for (String bloque : palabras) {
                            Equipo team = null;
                            String[] palabras2 = bloque.split(" ");
                            for (int i = 0; i < palabras2.length;i += 3) {
                                String nombre = palabras2[i];
                                String contacto = palabras2[i+1];
                                int edad = Integer.parseInt(palabras2[i+2]);
                                if(i==0){
                                    team = new Equipo(nombre,contacto,edad);
                                    torneo.agregarParticipantes(team);
                                }
                                else{
                                    team.agregarDeportista(new Deportista(nombre,contacto,edad));
                                }
                            }
                            System.out.println(team.getNombre() + " " + team.getMiembros() + " " + team.getEdad());
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
