/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Carlos Alburez 231311
 * Laboratorio 4
 */

// Clase abstracta que representa un usuario
public abstract class Usuario {
    protected String nombreUsuario;
    protected String contraseña;
/**
     * Constructor de la clase Usuario.
     *
     * @param nombreUsuario El nombre de usuario del usuario.
     * @param contraseña La contraseña del usuario.
     */
    public Usuario(String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }
/**
     * Obtiene el nombre de usuario del usuario.
     *
     * @return El nombre de usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }
 /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContraseña() {
        return contraseña;
    }
 /**
     * Establece una nueva contraseña para el usuario.
     *
     * @param nuevaContraseña La nueva contraseña a establecer.
     */
    public void setContraseña(String nuevaContraseña) {
        this.contraseña = nuevaContraseña;
    }
/**
     * Obtiene el tipo de usuario.
     *
     * @return Una cadena que representa el tipo de usuario.
     */
    public abstract String obtenerTipoUsuario();
}
