package es.centro.incidencias;

import java.util.Locale;

/**
 * Representa una incedencia
 * Contiene informormación específica como el id, el título, la prioridad y si está abierta
 * @author olga.dominguezbarrei
 * @version 1.0.0
 */

public final class Incidencia {

    /**
     * El id (identificador) es una cadena de caracteres que identifica la incidencia
     */
    private final String id;
    /**
     * El título es una cadena de caracteres que resume la indicencia
     */
    private final String titulo;
    /**
     * La prioridad es una cadena de caracteres que identifica el nivel de urgencia para la resolución de la incidencia
     */
    private final String prioridad;
    /**
     * Abierta es un booleano que indica si una indicencia está o no abierta
     */
    private final boolean abierta;

    /**
     * Constructor para crear una incidencia con todos sus parámetros
     * @param id El identificador de la incidencia
     * @param titulo El título de la incidencia
     * @param prioridad El grado de prioridad de la incidencia
     * @param abierta Si está o o no abierta la incidencia (true/false)
     */
    public Incidencia(String id, String titulo, String prioridad, boolean abierta) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.abierta = abierta;
    }

    /**
     * Obtiene el id de la incidencia
     * @return Una candena de texto con el id de la incidencia
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene el título de la incidencia
     * @return Una cadena de texto con el título de la incidencia
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene la prioridad de la incidencia
     * @return Una cadena de texto con un texto que indique la prioridad de la incidencia
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Obtiene si la incidencia está abierta
     * @return Un booleano con valor true si está abierta y false si no lo está
     */
    public boolean isAbierta() {
        return abierta;
    }

    /**
     * Obtiene la coincidencia del texto pasado como parámetro con la cadena de texto del id o del título
     * @param texto Una cadena de texto que podría formar parte o no del id o el título
     * @return Un booleano con valor true si coincide y false si no contiene esa secuencia de caracteres
     */
    public boolean coincideCon(String texto) {
        String criterio = texto.toLowerCase(Locale.ROOT);
        return id.toLowerCase(Locale.ROOT).contains(criterio)
                || titulo.toLowerCase(Locale.ROOT).contains(criterio);
    }

}
