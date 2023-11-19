/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Carlos Alburez 231311
 * Laboratorio 4
 */
import java.util.ArrayList;
import java.util.List;

/**
 * La clase UsuarioBase representa a un usuario básico en un sistema de biblioteca.
 * Hereda de la clase Usuario e incluye funcionalidades específicas para usuarios base,
 * como la capacidad de prestar libros y revistas.
 */
public class UsuarioBase extends Usuario {
    /** Lista de libros prestados por el usuario base. */
    private List<Libro> librosPrestados;
/** Lista de revistas prestadas por el usuario base. */
    private List<Revista> revistasPrestadas;

     /**
     * Constructor de la clase UsuarioBase.
     *
     * @param nombreUsuario El nombre de usuario del usuario base.
     * @param contraseña La contraseña del usuario base.
     */
    public UsuarioBase(String nombreUsuario, String contraseña) {
        super(nombreUsuario, contraseña);
        this.librosPrestados = new ArrayList<>();
        this.revistasPrestadas = new ArrayList<>();
    }
  /**
     * Obtiene la lista de libros prestados por el usuario base.
     *
     * @return La lista de libros prestados.
     */
    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }
 /**
     * Obtiene la lista de revistas prestadas por el usuario base.
     *
     * @return La lista de revistas prestadas.
     */
    public List<Revista> getRevistasPrestadas() {
        return revistasPrestadas;
    }
 /**
     * Agrega un libro a la lista de libros prestados por el usuario base.
     *
     * @param libro El libro a ser prestado.
     */
    public void agregarLibro(Libro libro) {
        if (librosPrestados.size() < 3) {
            librosPrestados.add(libro);
            System.out.println("Libro '" + libro.getTitulo() + "' agregado a la lista de préstamos.");
        } else {
            System.out.println("No puedes prestar más de 3 libros como usuario base.");
        }
    }
/**
     * Agrega una revista a la lista de revistas prestadas por el usuario base.
     *
     * @param revista La revista a ser prestada.
     */
    public void agregarRevista(Revista revista) {
        revistasPrestadas.add(revista);
        System.out.println("Revista '" + revista.getTitulo() + "' agregada a la lista de préstamos.");
    }

    @Override
    public String obtenerTipoUsuario() {
        return "Usuario Base";
    }
}
