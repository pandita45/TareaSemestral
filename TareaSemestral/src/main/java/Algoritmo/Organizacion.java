package Algoritmo;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Organizacion {
    /**
     * La clase Organizacion lee un txt donde esta guardada la inforamcion de los equipos
     * Dependiendo si son equipos o jugadores, obtiene sus datos e informacion clave
     * Crea instancias de Equipo y/o participante con la informacion y los agrega al torneo
     * @param torneo  Se le proporciona un torneo para que guarda la informacion
     * @param EOD Es un booleano que revisa si se selecciono un torneo de tipo Equipo o Deportista
     * @param archivo Se le proporciona un archivo del cual leer la informacion
     */
    public Organizacion(Torneo torneo, boolean EOD,String archivo){
        InputStream is = Organizacion.class.getClassLoader().getResourceAsStream(archivo);

        if (is == null) {
            System.out.println("Archivo no encontrado.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String linea;
            String contenido;
            StringBuilder sb = new StringBuilder();
            while ((linea = br.readLine()) != null) {
                sb.append(linea);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            contenido = sb.toString();
            if(EOD){
                String[] palabras = contenido.split(" ");
                for (int i = 0; i < palabras.length; i += 3) {
                    try {
                        String nombre = palabras[i];
                        String contacto = palabras[i + 1];
                        String edad = palabras[i + 2];
                        torneo.agregarParticipantes(new Deportista(nombre, contacto, edad));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            else{
                try {
                    String[] palabras = contenido.split("\\$");
                    for (String bloque : palabras) {
                        Equipo team = null;
                        String[] palabras2 = bloque.trim().split("\\s+");
                        for (int i = 0; i < palabras2.length;i += 3) {
                            String nombre = palabras2[i];
                            String contacto = palabras2[i+1];
                            String edad = palabras2[i+2];

                            if(i==0){
                                team = new Equipo(nombre,contacto,edad);
                                torneo.agregarParticipantes(team);
                            }
                            else{
                                team.agregarDeportista(new Deportista(nombre,contacto,edad));
                            }
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}