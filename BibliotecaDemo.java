
/**
 * Universidad del Valle de Guatemala
 * Departamento de Ciencias de la Computación
 * Carlos Alburez 231311
 * Laboratorio 4
 */
import java.util.Scanner;

public class BibliotecaDemo {

    /**
     * Método principal que inicia la aplicación de demostración de la biblioteca.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        Libro libro1 = new Libro("Java Programming", "John Doe");
        Libro libro2 = new Libro("Python Basics", "Jane Smith");
        Revista revista1 = new Revista("Science Today", "Science", 2023);
        Revista revista2 = new Revista("National Geographic", "Nature", 2023);

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarRevista(revista1);
        biblioteca.agregarRevista(revista2);


        ejecutarAplicacion(biblioteca, scanner);
    }
/**
     * Método para ejecutar la aplicación de la biblioteca, proporcionando un menú interactivo.
     *
     * @param biblioteca La instancia de la clase Biblioteca.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    private static void ejecutarAplicacion(Biblioteca biblioteca, Scanner scanner) {
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    modoRegistro(biblioteca, scanner);
                    break;
                case 2:
                    modoIngresarSalir(biblioteca, scanner);
                    break;
                case 3:
                    modoSeleccion(biblioteca, scanner);
                    break;
                case 4:
                    modoPrestamo(biblioteca, scanner);
                    break;
                case 5:
                    System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 6);
    }

     /**
     * Método para manejar el modo de registro de usuarios.
     *
     * @param biblioteca La instancia de la clase Biblioteca.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    private static void modoRegistro(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("\n--- Modo Registro ---");
        System.out.print("Ingrese un nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese una contraseña: ");
        String contraseña = scanner.nextLine();
        System.out.print("Seleccione un plan (1: Base, 2: Premium): ");
        int plan = scanner.nextInt();
        scanner.nextLine();

        if (plan == 1) {
            biblioteca.agregarUsuario(new UsuarioBase(nombreUsuario, contraseña));
            System.out.println("Usuario Base registrado con éxito.");
        } else if (plan == 2) {
            biblioteca.agregarUsuario(new UsuarioPremium(nombreUsuario, contraseña));
            System.out.println("Usuario Premium registrado con éxito.");
        } else {
            System.out.println("Opción no válida.");
        }
    }
/**
     * Método para manejar el modo de ingreso/salida de usuarios.
     *
     * @param biblioteca La instancia de la clase Biblioteca.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    private static void modoIngresarSalir(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("\n--- Modo Ingresar/Salir ---");
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        Usuario usuario = biblioteca.autenticarUsuario(nombreUsuario, contraseña);

        if (usuario != null) {
            System.out.println("Ingreso exitoso como " + usuario.getNombreUsuario());
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos. Inténtelo de nuevo.");
        }
    }
 /**
     * Método para manejar el modo de selección de materiales por parte de los usuarios.
     *
     * @param biblioteca La instancia de la clase Biblioteca.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    private static void modoSeleccion(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("\n--- Modo Selección ---");

        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        Usuario usuario = biblioteca.autenticarUsuario(nombreUsuario, contraseña);

        if (usuario != null) {
            System.out.println("Ingreso exitoso como " + usuario.getNombreUsuario());

            if (usuario instanceof UsuarioBase) {
                seleccionarLibroRevista((UsuarioBase) usuario, biblioteca, scanner);
            } else if (usuario instanceof UsuarioPremium) {
                seleccionarLibroRevista((UsuarioPremium) usuario, biblioteca, scanner);
            }
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos. Inténtelo de nuevo.");
        }
    }

    private static void seleccionarLibroRevista(UsuarioBase usuario, Biblioteca biblioteca, Scanner scanner) {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar libro");
        System.out.println("2. Agregar revista");
        System.out.println("3. Vaciar lista");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                agregarLibro(usuario, biblioteca, scanner);
                break;
            case 2:
                agregarRevista(usuario, biblioteca, scanner);
                break;
            case 3:
                vaciarLista(usuario);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void seleccionarLibroRevista(UsuarioPremium usuario, Biblioteca biblioteca, Scanner scanner) {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar libro");
        System.out.println("2. Agregar revista");
        System.out.println("3. Vaciar lista");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                agregarLibro(usuario, biblioteca, scanner);
                break;
            case 2:
                agregarRevista(usuario, biblioteca, scanner);
                break;
            case 3:
                vaciarLista(usuario);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void agregarLibro(Usuario usuario, Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el título del libro: ");
        String tituloLibro = scanner.nextLine();

        Libro libro = buscarLibro(biblioteca, tituloLibro);

        if (libro != null) {
            if (usuario instanceof UsuarioBase) {
                ((UsuarioBase) usuario).agregarLibro(libro);
                System.out.println("Libro '" + libro.getTitulo() + "' agregado a la lista de préstamos.");
            } else if (usuario instanceof UsuarioPremium) {
                ((UsuarioPremium) usuario).agregarLibro(libro);
                System.out.println("Libro '" + libro.getTitulo() + "' agregado a la lista de préstamos.");
            }
        } else {
            System.out.println("Libro no encontrado en la biblioteca.");
        }
    }

    private static void agregarRevista(Usuario usuario, Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Ingrese el título de la revista: ");
        String tituloRevista = scanner.nextLine();

        Revista revista = buscarRevista(biblioteca, tituloRevista);

        if (revista != null) {
            if (usuario instanceof UsuarioBase) {
                ((UsuarioBase) usuario).agregarRevista(revista);
                System.out.println("Revista '" + revista.getTitulo() + "' agregada a la lista de préstamos.");
            } else if (usuario instanceof UsuarioPremium) {
                ((UsuarioPremium) usuario).agregarRevista(revista);
                System.out.println("Revista '" + revista.getTitulo() + "' agregada a la lista de préstamos.");
            }
        } else {
            System.out.println("Revista no encontrada en la biblioteca.");
        }
    }

    private static Libro buscarLibro(Biblioteca biblioteca, String titulo) {
        for (Libro libro : biblioteca.getLibrosDisponibles()) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    private static Revista buscarRevista(Biblioteca biblioteca, String titulo) {
        for (Revista revista : biblioteca.getRevistasDisponibles()) {
            if (revista.getTitulo().equalsIgnoreCase(titulo)) {
                return revista;
            }
        }
        return null;
    }

    private static void vaciarLista(Usuario usuario) {
        if (usuario instanceof UsuarioBase) {
            ((UsuarioBase) usuario).getLibrosPrestados().clear();
            ((UsuarioBase) usuario).getRevistasPrestadas().clear();
            System.out.println("Lista de préstamos vaciada.");
        } else if (usuario instanceof UsuarioPremium) {
            ((UsuarioPremium) usuario).getLibrosPrestados().clear();
            ((UsuarioPremium) usuario).getRevistasPrestadas().clear();
            System.out.println("Lista de préstamos vaciada.");
        }
    }
    /**
     * Método para manejar el modo de préstamo de materiales por parte de los usuarios.
     *
     * @param biblioteca La instancia de la clase Biblioteca.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    private static void modoPrestamo(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("\n--- Modo Préstamo ---");

        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        Usuario usuario = biblioteca.autenticarUsuario(nombreUsuario, contraseña);

        if (usuario != null) {
            System.out.println("Ingreso exitoso como " + usuario.getNombreUsuario());

            if (usuario instanceof UsuarioBase) {
                gestionarPrestamo((UsuarioBase) usuario, biblioteca, scanner);
            } else if (usuario instanceof UsuarioPremium) {
                gestionarPrestamo((UsuarioPremium) usuario, biblioteca, scanner);
            }
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos. Inténtelo de nuevo.");
        }
    }

    private static void gestionarPrestamo(UsuarioBase usuario, Biblioteca biblioteca, Scanner scanner) {
        if (usuario.getLibrosPrestados().isEmpty() && usuario.getRevistasPrestadas().isEmpty()) {
            System.out.println("No tiene libros ni revistas seleccionadas para préstamo.");
            return;
        }

        System.out.print("Defina los días de entrega (máximo " + 30 + " días): ");
        int diasEntrega = scanner.nextInt();
        scanner.nextLine();

        if (diasEntrega <= 0 || diasEntrega > 30) {
            System.out.println("Número de días no válido. El préstamo no fue procesado.");
            return;
        }

        System.out.println("Libros seleccionados para préstamo:");
        for (Libro libro : usuario.getLibrosPrestados()) {
            System.out.println("- " + libro.getTitulo());
        }

        System.out.println("Revistas seleccionadas para préstamo:");
        for (Revista revista : usuario.getRevistasPrestadas()) {
            System.out.println("- " + revista.getTitulo());
        }

        Biblioteca.guardarPrestamosEnCSV(usuario.getLibrosPrestados(), usuario.getRevistasPrestadas(), diasEntrega, "",
                "", usuario.getNombreUsuario());

        System.out.println("Préstamo procesado exitosamente.");
        usuario.getLibrosPrestados().clear();
        usuario.getRevistasPrestadas().clear();
    }

    private static void gestionarPrestamo(UsuarioPremium usuario, Biblioteca biblioteca, Scanner scanner) {
        if (usuario.getLibrosPrestados().isEmpty() && usuario.getRevistasPrestadas().isEmpty()) {
            System.out.println("No tiene libros ni revistas seleccionadas para préstamo.");
            return;
        }

        System.out.print("Defina los días de entrega (máximo " + 50 + " días): ");
        int diasEntrega = scanner.nextInt();
        scanner.nextLine();

        if (diasEntrega <= 0 || diasEntrega > 50) {
            System.out.println("Número de días no válido. El préstamo no fue procesado.");
            return;
        }

        System.out.print("Defina el horario de entrega (AM/PM): ");
        String horarioEntrega = scanner.nextLine();

        System.out.print("Defina la sucursal para recoger el préstamo: ");
        String sucursalRecoger = scanner.nextLine();

        System.out.println("Libros seleccionados para préstamo:");
        for (Libro libro : usuario.getLibrosPrestados()) {
            System.out.println("- " + libro.getTitulo());
        }

        System.out.println("Revistas seleccionadas para préstamo:");
        for (Revista revista : usuario.getRevistasPrestadas()) {
            System.out.println("- " + revista.getTitulo());
        }

        Biblioteca.guardarPrestamosEnCSV(usuario.getLibrosPrestados(), usuario.getRevistasPrestadas(), diasEntrega,
                horarioEntrega, sucursalRecoger, usuario.getNombreUsuario());

        System.out.println("Préstamo procesado exitosamente.");
        usuario.getLibrosPrestados().clear();
        usuario.getRevistasPrestadas().clear();
    }
/**
     * Método para mostrar el menú principal de la aplicación.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Modo Registro");
        System.out.println("2. Modo Ingresar/Salir");
        System.out.println("3. Modo Selección");
        System.out.println("4. Modo Préstamo");
        System.out.println("5. Salir");
    }
}
