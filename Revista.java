/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Carlos Alburez 231311
 * Laboratorio 4
 */

public class Revista {
    private String titulo;
    private String categoria;
    private int añoPublicacion;
 /**
     * Constructor de la clase Revista.
     *
     * @param titulo El título de la revista.
     * @param categoria La categoría de la revista.
     * @param añoPublicacion El año de publicación de la revista.
     */
    public Revista(String titulo, String categoria, int añoPublicacion) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.añoPublicacion = añoPublicacion;
    }
 /**
     * Obtiene el título de la revista.
     *
     * @return El título de la revista.
     */
    public String getTitulo() {
        return titulo;
    }
/**
     * Obtiene la categoría de la revista.
     *
     * @return La categoría de la revista.
     */
    public String getCategoria() {
        return categoria;
    }
 /**
     * Obtiene el año de publicación de la revista.
     *
     * @return El año de publicación de la revista.
     */
    public int getAñoPublicacion() {
        return añoPublicacion;
    }
}
