package es.centro.incidencias;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que contiene la lógica de la aplicación
 */
public final class App {
    /**
     * Constructor vacío
     */
    private App() {
    }

    /**
     * Metodo main ejecutable que instancia un gestor con contenido por defecto.
     * Muestra un menú para que el usuario pueda realizar acciones de gestión.
     * @param args Array que recibe argumentos desde la línea de comandos al ejecutar el programa
     */
    public static void main(String[] args) {
        GestorIncidencias gestor = new GestorIncidencias();

        if (args.length == 0) {
            ejecutarMenuInteractivo(gestor);
            return;
        }

        if ("ayuda".equalsIgnoreCase(args[0])) {
            mostrarAyuda();
            return;
        }

        String operacion = args[0].toLowerCase();
        switch (operacion) {
            case "listar" -> mostrar(gestor.listar());
            case "abiertas" -> mostrar(gestor.listarAbiertas());
            case "buscar" -> buscar(args, gestor);
            case "detalle" -> mostrarDetalle(args, gestor);
            default -> {
                System.out.println("Operación desconocida: " + args[0]);
                mostrarAyuda();
            }
        }
    }

    /**
     * Lee las distintas entradas del usuario y llama al metodo correspondiente a la acción que indique
     * @param gestor Gestor que contiene la lista de incidencia sobre la que se realizarán operaciones
     */
    private static void ejecutarMenuInteractivo(GestorIncidencias gestor) {
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("GESTOR DE INCIDENCIAS");
        System.out.println("Aplicación de consulta de avisos de soporte del centro.");

        while (continuar) {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");

            if (!entrada.hasNextLine()) {
                return;
            }

            String opcion = entrada.nextLine().trim();
            System.out.println();

            switch (opcion) {
                case "1" -> mostrar(gestor.listar());
                case "2" -> mostrar(gestor.listarAbiertas());
                case "3" -> buscarDesdeMenu(entrada, gestor);
                case "4" -> mostrarDetalleDesdeMenu(entrada, gestor);
                case "0" -> {
                    continuar = false;
                    System.out.println("Aplicación finalizada.");
                }
                default -> System.out.println("La opción indicada no es válida.");
            }

            System.out.println();
        }
    }

    /**
     * Imprime por consola las opciones del menú y que número debe presionar el usuario para ejecuatar cada una de ellas
     */
    private static void mostrarMenu() {
        System.out.println("----------------------------------------");
        System.out.println("1. Mostrar todas las incidencias");
        System.out.println("2. Mostrar las incidencias abiertas");
        System.out.println("3. Buscar incidencias");
        System.out.println("4. Consultar una incidencia por su ID");
        System.out.println("0. Salir");
        System.out.println("----------------------------------------");
    }

    /**
     * Lee un texto para buscar alguna incidencia que coincida con la cadena
     * introducida ya sea en id o en título. Si la entrada está vacía o solo contiene espacios
     * muestra "Debes ontroducir algún texto
     * @param entrada Instancia de Scanner necesaria para pedir datos al usuario
     * @param gestor GestorIncodencias sobre el que se realizará la búsqueda
     */
    private static void buscarDesdeMenu(Scanner entrada, GestorIncidencias gestor) {
        System.out.print("Texto que deseas buscar: ");
        String texto = entrada.hasNextLine() ? entrada.nextLine().trim() : "";

        if (texto.isBlank()) {
            System.out.println("Debes introducir algún texto.");
            return;
        }

        mostrar(gestor.buscar(texto));
    }

    /**
     * Lee un identificador e improme la información detallada de la incidencia correspondiente.
     * Si la entrada está vacía o solo contiene espacios se informará con un mensaje
     * @param entrada Instancia de Scanner necesaria para pedir datos al usuario
     * @param gestor {@code GestorIncidencias} en que se se buscará el id
     */
    private static void mostrarDetalleDesdeMenu(Scanner entrada, GestorIncidencias gestor) {
        System.out.print("Identificador de la incidencia: ");
        String id = entrada.hasNextLine() ? entrada.nextLine().trim() : "";

        if (id.isBlank()) {
            System.out.println("Debes introducir un identificador.");
            return;
        }

        mostrarDetalle(id, gestor);
    }

    /**
     * Imprime la incidencia del gestor que coincida con el texto que haya escrito el usuario
     * @param args Conjunto de argumentos tecleados en linea de comandos por el usuario
     * @param gestor Gestor que contiene las incidencias en las que se buscan coincidencias
     */
    private static void buscar(String[] args, GestorIncidencias gestor) {
        if (args.length < 2) {
            System.out.println("Debes indicar el texto que deseas buscar.");
            return;
        }

        String texto = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
        mostrar(gestor.buscar(texto));
    }

    /**
     * Extrae la última entrada válida de linea de comandos que contiene un id, con esa informaicón
     * llama a otro metodo para que muestre el detalle con la incidencia corespondiente
     * @param args Conjunto de argumnetos leídos de línea de comandos
     * @param gestor Gestor que contiene las incidencias
     */
    private static void mostrarDetalle(String[] args, GestorIncidencias gestor) {
        if (args.length < 2) {
            System.out.println("Debes indicar el identificador de la incidencia.");
            return;
        }

        mostrarDetalle(args[1], gestor);
    }

    /**
     * Muestra por pantalla los datos de la incidencia que corresponda con el id que recibe por paámetro
     * @param id Identificador de la incidencia que se quiere imprimir
     * @param gestor Gestor que contiene la lista de incidencias
     */

    private static void mostrarDetalle(String id, GestorIncidencias gestor) {
        try {
            System.out.println(gestor.buscarPorId(id));
        } catch (IncidenciaNoEncontradaException excepcion) {
            System.out.println(excepcion.getMessage());
        }
    }

    /**
     * Muestra todas las incidencias de la lista, si está vacío, muestra un mensaje de que no
     * se han encontrado incidencias
     * @param incidencias Lista de incidencias que se van a imprimir
     */
    private static void mostrar(List<Incidencia> incidencias) {
        if (incidencias.isEmpty()) {
            System.out.println("No se han encontrado incidencias.");
            return;
        }
        incidencias.forEach(System.out::println);
    }

    /**
     * Muestra por pantalla el listado de comandos y su acción correspondiente
     */
    private static void mostrarAyuda() {
        System.out.println("Gestor de incidencias");
        System.out.println("  ayuda              Muestra esta ayuda");
        System.out.println("  listar              Muestra todas las incidencias");
        System.out.println("  abiertas            Muestra las incidencias abiertas");
        System.out.println("  buscar <texto>      Busca por identificador o título");
        System.out.println("  detalle <id>        Muestra una incidencia");
    }
}
