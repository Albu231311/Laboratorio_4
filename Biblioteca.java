/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Carlos Alburez 231311
 * Laboratorio 4
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Usuario> usuarios;
    private List<Libro> librosDisponibles;
    private List<Revista> revistasDisponibles;
/**
     * Constructor de la clase Biblioteca.
     * Inicializa las listas de usuarios, libros y revistas.
     */
    public Biblioteca() {
        this.usuarios = new ArrayList<>();
        this.librosDisponibles = new ArrayList<>();
        this.revistasDisponibles = new ArrayList<>();
    }
 /**
     * Agrega un usuario a la lista de usuarios de la biblioteca.
     *
     * @param usuario El usuario a agregar.
     */
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
/**
     * Autentica a un usuario en la biblioteca.
     *
     * @param nombreUsuario El nombre de usuario.
     * @param contraseña La contraseña del usuario.
     * @return El usuario autenticado o null si no se encuentra.
     */
    public Usuario autenticarUsuario(String nombreUsuario, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null;
    }
 /**
     * Cambia el tipo de cliente de UsuarioBase a UsuarioPremium.
     *
     * @param usuarioBase El usuario base a ser cambiado.
     * @param usuarioPremium El nuevo usuario premium.
     */
    public void cambiarTipoCliente(UsuarioBase usuarioBase, UsuarioPremium usuarioPremium) {
        usuarios.remove(usuarioBase);
        usuarios.add(usuarioPremium);
    }
  /**
     * Agrega un libro a la lista de libros disponibles en la biblioteca.
     *
     * @param libro El libro a agregar.
     */
    public void agregarLibro(Libro libro) {
        librosDisponibles.add(libro);
    }
/**
     * Agrega una revista a la lista de revistas disponibles en la biblioteca.
     *
     * @param revista La revista a agregar.
     */
    public void agregarRevista(Revista revista) {
        revistasDisponibles.add(revista);
    }
/**
     * Obtiene la lista de libros disponibles en la biblioteca.
     *
     * @return La lista de libros disponibles.
     */
    public List<Libro> getLibrosDisponibles() {
        return librosDisponibles;
    }
 /**
     * Obtiene la lista de revistas disponibles en la biblioteca.
     *
     * @return La lista de revistas disponibles.
     */
    public List<Revista> getRevistasDisponibles() {
        return revistasDisponibles;
    }

      /**
     * Guarda los préstamos de libros y revistas en un archivo CSV.
     *
     * @param libros Lista de libros prestados.
     * @param revistas Lista de revistas prestadas.
     * @param diasEntrega Número de días para la entrega.
     * @param horarioEntrega Horario de entrega.
     * @param sucursalRecoger Sucursal para recoger los materiales prestados.
     * @param nombreUsuario Nombre del usuario que realiza los préstamos.
     */
    public static void guardarPrestamosEnCSV(List<Libro> libros, List<Revista> revistas, int diasEntrega,
            String horarioEntrega, String sucursalRecoger, String nombreUsuario) {
        String csvFile = "prestamos.csv";
        try (FileWriter writer = new FileWriter(csvFile, true)) {
            for (Libro libro : libros) {
                writer.append(nombreUsuario).append(",").append(libro.getTitulo()).append(",").append("Libro")
                        .append(",").append(String.valueOf(diasEntrega)).append(",").append(horarioEntrega).append(",")
                        .append(sucursalRecoger).append("\n");
            }
            for (Revista revista : revistas) {
                writer.append(nombreUsuario).append(",").append(revista.getTitulo()).append(",").append("Revista")
                        .append(",").append(String.valueOf(diasEntrega)).append(",").append(horarioEntrega).append(",")
                        .append(sucursalRecoger).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
