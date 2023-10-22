import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

    /** 
     * Muestra un menú con opciones para gestionar el directorio establecido en @param RUTA_CARPETA 
     * 
     * @param RUTA_CARPETA Constante de clase que indica el directorio sobre el que trabajar.
     * @author Dante Sarotti
     * @version 0.1
     */
public class App {

    //Debe ser una ruta absoluta o relativa terminada en "/"
    private static final String RUTA_CARPETA = "carpetaFicheros/"; 
    
    public static void main(String[] args) {
        File folder = new File(RUTA_CARPETA);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("La carpeta establecida en el código no se encuentra.");
            return;
        }

        int opcion = 0;
        while (opcion != 10) {
            MostrarMenu();
            opcion = solicitarOpcion();

            switch (opcion) {
                case 1:
                    Ficheros.listarArchivosCarpetas(RUTA_CARPETA);
                    break;
                case 2:
                    Ficheros.verPermisosFichero(RUTA_CARPETA, solicitarEntrada("Introduce el nombre del fichero: "));
                    break;
                case 3:
                    Ficheros.leerFichero(RUTA_CARPETA, solicitarEntrada("Introduce el nombre del fichero a leer: "));
                    break;
                case 4:
                    Ficheros.escribirEnFichero(RUTA_CARPETA, solicitarEntrada("Introduce el nombre del fichero a escribir: "));
                    break;
                case 5:
                    Ficheros.crearFichero(RUTA_CARPETA, solicitarEntrada("Introduce el nombre del fichero a crear: "));
                    break;
                case 6:
                    Ficheros.borrarFichero(RUTA_CARPETA, solicitarEntrada("Introduce el nombre del fichero a borrar: "));
                    break;
                case 7:
                    Ficheros.crearDirectorio(RUTA_CARPETA, solicitarEntrada("Introduce el nombre del directorio a crear: "));
                    break;
                case 8:
                    Ficheros.borrarDirectorio(RUTA_CARPETA, solicitarEntrada("Introduce el nombre del directorio a borrar: "));
                    break;
                case 9:
                    Ficheros.mostrarRutaAbsolutaFichero(RUTA_CARPETA, solicitarEntrada("Introduche el nombre del fichero para mostrar su ruta absoluta: "));
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    /** 
     * Muestra un menú con las opciones disponibles.
     */
    private static void MostrarMenu() {
        System.out.println("\nSelecciona una opción:");
        System.out.println("1. Listar archivos y carpetas.");
        System.out.println("2. Ver permisos del fichero.");
        System.out.println("3. Leer el fichero.");
        System.out.println("4. Escribir en el fichero.");
        System.out.println("5. Crear un fichero.");
        System.out.println("6. Borrar el fichero.");
        System.out.println("7. Crear un directorio.");
        System.out.println("8. Borrar un directorio.");
        System.out.println("9. Mostrar ruta absoluta de un fichero.");
        System.out.println("10. Salir.");
    }
    
    /** 
     * Solicita que el usuario introduzca un numero para el menú.
     * 
     * @return El número que el usuario ha escogido, -1 si no ha introducido un entero.
     */
    private static int solicitarOpcion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el número de la opción: ");
        try{
            return scanner.nextInt();
        }catch(InputMismatchException e){
            return -1;
        }
    }
    
    /** 
     * Solicita que el usuario intrduzca una entrada para la opción escogida.
     * 
     * @param mensaje El mensaje que indica al usuario qué debe introducir.
     * @return El String que ha introducido el usuario.
     */
    private static String solicitarEntrada(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}