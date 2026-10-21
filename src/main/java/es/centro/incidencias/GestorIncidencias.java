package es.centro.incidencias;

import java.util.List;

/**
 * Gestor encargado de administra y consultar un conjunto de incidencias.
 * Proporciona métodos para listar, filtrar, buscar por texto y por identificador
 *
 * @author olga.dominguezbarrei
 * @version 1.0.0
 * @since 1.0.0
 */
public final class GestorIncidencias {

    /**
     * Conjunto de incidencias de tamaño flexible que serás administradas en el gestor
     */
    private final List<Incidencia> incidencias;

    /**
     * Constructor que no recibe parámetros.
     * Construye una nueva instancia de {@code GestorIncidencia} inicializando una lista de incidencias predeterminadas.
     */
    public GestorIncidencias() {
        incidencias = List.of(
                new Incidencia("INC-001", "No se puede iniciar sesión", "alta", true),
                new Incidencia("INC-002", "Actualizar el navegador", "media", false),
                new Incidencia("INC-003", "Impresora sin conexión", "baja", true),
                new Incidencia("INC-004", "Fallo de red en el aula", "alta", true)
        );
    }

    /**
     * Devuelve la lista de todas las indencias registradas en el momento de la consulta
     * @return Una lista con el conjunto de incidencias
     */
    public List<Incidencia> listar() {
        return incidencias;
    }

    /**
     * Filtra y devuelve únicamente las incidencias abiertas
     * @return Una lista de las incidencias abiertas
     */
    public List<Incidencia> listarAbiertas() {
        return incidencias.stream()
                .filter(Incidencia::isAbierta)
                .toList();
    }

    /**
     * Busca incidencias que coincidan con el texto de búsqueda proporcionado
     * @param texto El texto o palabra clave a buscar en la lista de incidencias
     * @return Una lista con las incidencias coon coinciden con el criterio de búsqueda
     */
    public List<Incidencia> buscar(String texto) {
        return incidencias.stream()
                .filter(incidencia -> incidencia.coincideCon(texto))
                .toList();
    }

    /**
     * Busca y devuelve una incidencia específica según su identificador
     * La búsqueda no distingue entre mayúsculas y minúsculas
     * @param id El identificador de la incidencia que buscamos
     * @return La incidencia encontrada
     * @throws IncidenciaNoEncontradaException Si no existe ninguna incidencia con el id proporcionado
     */
    public Incidencia buscarPorId(String id) throws IncidenciaNoEncontradaException {
        return incidencias.stream()
                .filter(incidencia -> incidencia.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new IncidenciaNoEncontradaException(id));
    }

    /**
     * Obtiene una incidencia que coincida con el id indicado
     * @deprecated Este metodo está obsoleto. Utiliza {@link #buscarPorId(String)} en su lugar
     * la cual lanza una excepción en caso de no encontrar la incidencia en lugar de retornar nulo.
     * @param id El identificador único de la incidencia
     * @return La incidencia no encontrada, o {@code null} si no se encuentra.
     * @since 1.0.0
     */
    @Deprecated(since = "1.0.0", forRemoval = false)
    public Incidencia obtenerIncidencia(String id) {
        try {
            return buscarPorId(id);
        } catch (IncidenciaNoEncontradaException excepcion) {
            return null;
        }
    }
}
