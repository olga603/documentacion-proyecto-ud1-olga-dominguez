package es.centro.incidencias;

/**
 * Excepción personalizada que se lanza cuando se intenta buscar una incidencia por id y no se encuentra ninguna que coincida
 * @author olga.dominguezbarrei
 * @version 1.0.0
 * @see java.lang.Exception
 */
public class IncidenciaNoEncontradaException extends Exception {

    /**
     * Construye una nueva instancia de {@code IncidenciaNoEncontradaException}
     * con un mensaje descriptivo que incluye el identificador de la incidencia que no pudo ser encontrada
     * @param id El id que provocó el error
     */
    public IncidenciaNoEncontradaException(String id) {
        super("No existe ninguna incidencia con el identificador " + id + ".");
    }
}
