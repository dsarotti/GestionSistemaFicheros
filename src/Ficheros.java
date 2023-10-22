import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ficheros {
    
    /**
     * Muestra el contenido del directorio indicado.
     * @param rutaCarpeta El directorio que listar.
     */
    public static void listarArchivosCarpetas(String rutaCarpeta) {
        File carpeta = new File(rutaCarpeta);
        File[] archivos = carpeta.listFiles();
        System.out.println("Listando archivos y carpetas en " + carpeta.getAbsolutePath() + ":");
        for (File archivo : archivos) {
            System.out.println(archivo.getName());
        }
    }
    
    /** 
     * Muestra los permisos del fichero.
     * @param nombrefichero El fichero del cual mostrar permisos.
     */
    public static void verPermisosFichero(String rutaCarpeta, String nombrefichero) {
        File fichero = new File(rutaCarpeta + nombrefichero);
        if (fichero.exists()) {
            System.out.println("Permisos del fichero " + fichero.getAbsolutePath() + ":");
            System.out.println("Lectura: " + (fichero.canRead()?"Si":"No"));
            System.out.println("Escritura: " + (fichero.canWrite()?"Si":"No"));
            System.out.println("Ejecucion: " + (fichero.canExecute()?"Si":"No"));
        }else{
            System.out.println("No se encuentra el fichero o directorio");
        }
    }

    /** 
     * Muestra el contenido del fichero.
     * @param nombrefichero El fichero a leer.
     */
    public static void leerFichero(String rutaCarpeta, String nombreFichero) {
        File fichero = new File(rutaCarpeta +nombreFichero);
        try (FileReader fr = new FileReader(fichero)) {
            int c;
            System.out.println("Contenido del fichero " + fichero.getAbsolutePath() + ":");
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        }
    }
    
    /** 
     * Solicita una entrada por teclaro y la guarda al final del fichero.
     * @param nombreFichero El fichero a editar.
     */
    public static void escribirEnFichero(String rutaCarpeta, String nombreFichero) {
        File archivo = new File(rutaCarpeta+nombreFichero);
        if (!archivo.exists()||archivo.isFile()){
            try (FileWriter fw = new FileWriter(archivo, true)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Introduce el texto a escribir (termina con Ctrl+D en Linux/Unix o Ctrl+Z en Windows):");
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    fw.write(System.lineSeparator());
                    fw.write(line);
                }
                fw.close();
                System.out.println("Contenido escrito en el fichero.");
            } catch (IOException e) {
                System.out.println("Error al escribir en el fichero.");
            }
        }else{
            System.out.println("La ruta no pertenece a un archivo.");
        }
    }
    
    /** 
     * Crea un fichero nuevo.
     * @param nombreFichero el nombre del fichero a crear.
     */
    public static void crearFichero(String rutaCarpeta, String nombreFichero) {
        if (nombreFichero.isBlank()){
            System.out.println("El nombre no puede estar vacío. No se creará el fichero.");
        }else{
            File nuevoFichero = new File(rutaCarpeta+nombreFichero);
            try {
                if (nuevoFichero.createNewFile()) {
                    System.out.println("Archivo creado con éxito.");
                } else {
                    System.out.println(nuevoFichero.getAbsolutePath());
                    System.out.println("El archivo ya existe.");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo.");
            }
        }
    }
    
    /** 
     * Borra un fichero.
     * @param nombreFichero nombre del fichero a borrar.
     */
    public static void borrarFichero(String rutaCarpeta, String nombreFichero) {
        if (nombreFichero.isBlank()){
            System.out.println("El nombre no puede estar vacío.");
        }else{
            File archivoBorrar = new File(rutaCarpeta+nombreFichero);
            if (archivoBorrar.exists() && archivoBorrar.isFile()) {
                if (archivoBorrar.delete()) {
                    System.out.println("Archivo borrado exitosamente.");
                } else {
                    System.out.println("No se pudo borrar el archivo.");
                }
            } else {
                System.out.println("El archivo no existe.");
            }
        }
        
    }
    
    /** 
     * Crea un nuevo directorio.
     * @param directorio nombre del directorio a crear.
     */
    public static void crearDirectorio(String rutaCarpeta, String directorio) {
        if (directorio.isBlank()){
            System.out.println("El nombre no puede estar vacío. No se creará el directorio.");
        }else{
            File nuevoDirectorio = new File(rutaCarpeta+directorio);
            try {
                if (nuevoDirectorio.mkdir()) {
                    System.out.println("Directorio creado exitosamente.");
                } else {
                    System.out.println("Error al crear el directorio.");
                }
            } catch (SecurityException e) {
                System.out.println("No se ha permitido crear el directorio.");
            }
        }
    }
    
    /** 
     * Borra un directorio.
     * @param directorio nombre del directorio a borrar.
     */
    public static void borrarDirectorio(String rutaCarpeta, String directorio) {
        if (directorio.isBlank()){
            System.out.println("El nombre no puede estar vacío.");
        }else{
            File directorioBorrar = new File(rutaCarpeta + directorio);
            if (directorioBorrar.exists() && directorioBorrar.isDirectory()) {
                try{
                    if (directorioBorrar.delete()) {
                        System.out.println("Directorio borrado exitosamente.");
                    } else {
                        System.out.println("Error al borrar el directorio.");
                    }
                }catch(SecurityException e){
                    System.out.println("No se ha permitido borrar el directorio");
                }
            } else {
                System.out.println("El directorio no existe.");
            }
        }
    }
    
    /** Muestra la ruta absoluta de un fichero.
     * @param fichero Nombre del fichero del cual mostrar la ruta absoluta.
     */
    public static void mostrarRutaAbsolutaFichero(String rutaCarpeta, String fichero){
        if (fichero.isBlank()){
            System.out.println("El nombre no puede estar vacío.");
        }else{
            File ficheroRuta = new File(rutaCarpeta + fichero);
            if(ficheroRuta.exists() && ficheroRuta.isFile()){
                System.out.println(ficheroRuta.getAbsolutePath());
            }else{
                System.out.println("No existe un fichero con el nombre \"" + fichero + "\"");
            }
        }
    }
}
