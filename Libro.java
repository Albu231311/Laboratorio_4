/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Carlos Alburez 231311
 * Laboratorio 4
 */

public class Libro {
    private String titulo;
    private String autor;
  /**
     * Constructor de la clase Libro.
     *
     * @param titulo El título del libro.
     * @param autor El autor del libro.
     */
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
/**
     * Obtiene el título del libro.
     *
     * @return El título del libro.
     */
    public String getTitulo() {
        return titulo;
    }
/**
     * Obtiene el autor del libro.
     *
     * @return El autor del libro.
     */
    public String getAutor() {
        return autor;
    }

}
