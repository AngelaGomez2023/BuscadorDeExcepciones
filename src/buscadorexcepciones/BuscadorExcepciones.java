/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscadorexcepciones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 * @author ag957
 */
public class BuscadorExcepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Definimos el directorio
        Path directorio = Paths.get("ruta/del/directorio");

        //Extension a buscar
        String extension = ".txt";

        try (Stream<Path> archivos = Files.list(directorio)) {
            long cantidadArchivos = archivos
                    //filtros
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(extension)) //filtrar pro extensión
                    .count();
            System.out.println("Cantidad de archivos con extensión " + extension + ": " + cantidadArchivos);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
