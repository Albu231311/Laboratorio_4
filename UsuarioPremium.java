/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Carlos Alburez 231311
 * Laboratorio 4
 */


import java.util.ArrayList;
import java.util.List;

/**
 * La clase UsuarioPremium representa a un usuario con privilegios premium en un sistema de biblioteca.
 * Hereda de la clase Usuario e incluye funcionalidades específicas para usuarios premium,
 * como la capacidad de prestar libros y revistas.
 */
public class UsuarioPremium extends Usuario {

    /** Lista de libros prestados por el usuario premium. */
    private List<Libro> librosPrestados;

     /** Lista de revistas prestadas por el usuario premium. */
    private List<Revista> revistasPrestadas;

     /**
     * Constructor de la clase UsuarioPremium.
     *
     * @param nombreUsuario El nombre de usuario del usuario premium.
     * @param contraseña La contraseña del usuario premium.
     */
    public UsuarioPremium(String nombreUsuario, String contraseña) {
        super(nombreUsuario, contraseña);
        this.librosPrestados = new ArrayList<>();
        this.revistasPrestadas = new ArrayList<>();
    }

    /**
     * Obtiene la lista de libros prestados por el usuario premium.
     *
     * @return La lista de libros prestados.
     */
    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }
/**
     * Obtiene la lista de revistas prestadas por el usuario premium.
     *
     * @return La lista de revistas prestadas.
     */
    public List<Revista> getRevistasPrestadas() {
        return revistasPrestadas;
    }
/**
     * Agrega un libro a la lista de libros prestados por el usuario premium.
     *
     * @param libro El libro a ser prestado.
     */
    public void agregarLibro(Libro libro) {
        if (librosPrestados.size() < 5) {
            librosPrestados.add(libro);
            System.out.println("Libro '" + libro.getTitulo() + "' agregado a la lista de préstamos.");
        } else {
            System.out.println("No puedes prestar más de 5 libros como usuario premium.");
        }
    }
 /**
     * Agrega una revista a la lista de revistas prestadas por el usuario premium.
     *
     * @param revista La revista a ser prestada.
     */
    public void agregarRevista(Revista revista) {
        revistasPrestadas.add(revista);
        System.out.println("Revista '" + revista.getTitulo() + "' agregada a la lista de préstamos.");
    }

    @Override
    public String obtenerTipoUsuario() {
        return "Usuario Premium";
    }
}
