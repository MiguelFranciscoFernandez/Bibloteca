
/**
 * @author Todos
 * Clase que representa el sistema de gestión.
 */

/******************************************************************
 * RESPONSABLE: COMPAÑERO C
 * TAREAS:
 * - Motor de ARRAYS DINÁMICOS (Redimensionado manual +1 / -1).
 * - Lógica interna de agregar/eliminar libros y usuarios del sistema.
 * - Gestión de préstamos y devoluciones.
 * - Generación de estadísticas globales.
 ******************************************************************/

package com.example;

import java.util.Arrays;

public class Biblioteca {
    private Libro[] libros;
    private Usuario[] usuarios;
    private Prestamos[] prestamos;

    // Constructor vacío - inicializa arrays vacíos
    public Biblioteca() {
        this.libros = new Libro[0];
        this.usuarios = new Usuario[0];
        this.prestamos = new Prestamos[0];
    }

    // Constructor con parámetros
    public Biblioteca(Libro[] libros, Usuario[] usuarios, Prestamos[] prestamos) {
        this.libros = libros;
        this.usuarios = usuarios;
        this.prestamos = prestamos;
    }

    public Libro[] getLibro() {
        return libros;
    }

    public Usuario[] getUsuario() {
        return usuarios;
    }

    public Prestamos[] getPrestamos() {
        return prestamos;
    }

    // ----------------------------------------------------------------
    // GESTIÓN DE LIBROS
    // ----------------------------------------------------------------

    public void Agregar_Libro(String titulo, String autor, String editorial, String isbn, int n_paginas,
            Genero genero) {
        libros = Arrays.copyOf(libros, libros.length + 1);
        libros[libros.length - 1] = new Libro(titulo, autor, editorial, isbn, n_paginas, genero);
        System.out.println("Nuevo libro añadido de forma correcta");
    }

    public void Eliminar_Libro(String titulo) {
        int indice = -1;
        for (int i = 0; i < libros.length; i++) {
            if (libros[i].getTitulo().equals(titulo)) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            System.out.println("Libro no encontrado");
            return;
        }
        Libro[] nuevoArray = new Libro[libros.length - 1];
        System.arraycopy(libros, 0, nuevoArray, 0, indice);
        System.arraycopy(libros, indice + 1, nuevoArray, indice, libros.length - indice - 1);
        libros = nuevoArray;
        System.out.println("El libro ha sido eliminado de esta biblioteca");
    }

    public void Eliminar_Libro_ISBN(String isbn) {
        int indice = -1;
        for (int i = 0; i < libros.length; i++) {
            if (libros[i].getIsbn().equals(isbn)) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            System.out.println("Libro no encontrado");
            return;
        }
        Libro[] nuevoArray = new Libro[libros.length - 1];
        System.arraycopy(libros, 0, nuevoArray, 0, indice);
        System.arraycopy(libros, indice + 1, nuevoArray, indice, libros.length - indice - 1);
        libros = nuevoArray;
        System.out.println("El libro ha sido eliminado de esta biblioteca");
    }

    public void Buscar_Libro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Libro encontrado:");
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println("ISBN: " + libro.getIsbn());
                return;
            }
        }
        System.out.println("Libro no encontrado");
    }

    // ----------------------------------------------------------------
    // GESTIÓN DE USUARIOS
    // ----------------------------------------------------------------

    public void Agregar_Usuario(String nombre, String password, String rol) {
        usuarios = Arrays.copyOf(usuarios, usuarios.length + 1);
        usuarios[usuarios.length - 1] = new Usuario(nombre, password, rol);
        System.out.println("Nuevo usuario añadido de forma correcta");
    }

    public void Eliminar_Usuario(String nombre) {
        int indice = -1;
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].getNombre().equalsIgnoreCase(nombre)) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            System.out.println("Usuario no encontrado");
            return;
        }
        Usuario[] nuevoArray = new Usuario[usuarios.length - 1];
        System.arraycopy(usuarios, 0, nuevoArray, 0, indice);
        System.arraycopy(usuarios, indice + 1, nuevoArray, indice, usuarios.length - indice - 1);
        usuarios = nuevoArray;
        System.out.println("El usuario ha sido eliminado de la biblioteca");
    }

    public boolean Validar_Password(String nombre, String intentoPassword) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                if (u.getPassword().equals(intentoPassword)) {
                    return true;
                } else {
                    System.out.println("Contraseña incorrecta para el usuario: " + nombre);
                    return false;
                }
            }
        }
        System.out.println("Usuario no encontrado");
        return false;
    }

    public boolean Tiene_Permiso_Admin(String nombre) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                return u.getRol().equalsIgnoreCase("admin");
            }
        }
        return false;
    }

    // ----------------------------------------------------------------
    // GESTIÓN DE PRÉSTAMOS
    // ----------------------------------------------------------------

    public void Registrar_Prestamo(String nombreUsuario, String tituloLibro, String fechaPrestamo,
            String fechaDevolucion) {
        Usuario usuario = null;
        Libro libro = null;

        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombreUsuario)) {
                usuario = u;
                break;
            }
        }
        for (Libro l : libros) {
            if (l.getTitulo().equalsIgnoreCase(tituloLibro)) {
                libro = l;
                break;
            }
        }

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }
        if (libro == null) {
            System.out.println("Libro no encontrado");
            return;
        }

        prestamos = Arrays.copyOf(prestamos, prestamos.length + 1);
        prestamos[prestamos.length - 1] = new Prestamos(fechaPrestamo, fechaDevolucion, usuario, libro);
        usuario.setLibrosPrestados(usuario.getLibrosPrestados() + 1);
        System.out.println("Préstamo registrado correctamente");
    }

    public void Registrar_Devolucion(String nombreUsuario, String tituloLibro) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombreUsuario)) {
                if (u.getLibrosPrestados() > 0) {
                    u.setLibrosDevueltos(u.getLibrosDevueltos() + 1);
                    System.out.println("Devolución registrada para el usuario: " + nombreUsuario);
                } else {
                    System.out.println("El usuario no tiene préstamos activos");
                }
                return;
            }
        }
        System.out.println("Usuario no encontrado");
    }

    // ----------------------------------------------------------------
    // MOSTRAR INFORMACIÓN
    // ----------------------------------------------------------------

    public void Mostrar_Libros() {
        if (libros.length == 0) {
            System.out.println("No hay libros disponibles en la biblioteca.");
            return;
        }
        System.out.println("Libros disponibles en la biblioteca:");
        for (Libro libro : libros) {
            System.out.println("- " + libro.getTitulo() + " por " + libro.getAutor());
        }
    }

    public void Mostrar_Usuarios() {
        if (usuarios.length == 0) {
            System.out.println("No hay usuarios registrados en la biblioteca.");
            return;
        }
        System.out.println("Usuarios registrados en la biblioteca:");
        for (Usuario usuario : usuarios) {
            System.out.println("- " + usuario.getNombre() + " (Rol: " + usuario.getRol() + ")");
        }
    }

    public boolean Mostrar_Libros_Prestados() {
        boolean Prestados = false;
        if (prestamos.length == 0) {
            System.out.println("No hay préstamos registrados.");
            return Prestados;
        }
        System.out.println("Libros actualmente prestados:");
        for (Prestamos p : prestamos) {
            System.out.println("- " + p.getLibro().getTitulo() + " prestado a " + p.getUsuario().getNombre()
                    + " | Fecha: " + p.getFechaPrestamo() + " | Devolución: " + p.getFechaDevolucion());
            Prestados = true;
        }
        return Prestados;
    }

    public void Mostrar_Prestamos_Prestados_Devueltos() {
        if (prestamos.length == 0) {
            System.out.println("No hay préstamos registrados.");
            return;
        }
        System.out.println("Préstamos registrados:");
        for (Prestamos p : prestamos) {
            System.out.println("- " + p.getUsuario().getNombre() + " -> " + p.getLibro().getTitulo()
                    + " | Fecha: " + p.getFechaPrestamo() + " | Devolución: " + p.getFechaDevolucion());
        }
        System.out.println("Devoluciones registradas:");
        for (Usuario u : usuarios) {
            if (u.getLibrosDevueltos() > 0) {
                System.out.println("- " + u.getNombre() + " ha devuelto " + u.getLibrosDevueltos() + " libro(s)");
            }
        }
    }

    public void Libros_Mas_Prestados() {
        if (prestamos.length == 0) {
            System.out.println("No hay préstamos registrados.");
            return;
        }
        int maxPrestamos = 0;
        for (Usuario u : usuarios) {
            if (u.getLibrosPrestados() > maxPrestamos) {
                maxPrestamos = u.getLibrosPrestados();
            }
        }
        System.out.println("Usuario(s) con más libros prestados (" + maxPrestamos + "):");
        for (Usuario u : usuarios) {
            if (u.getLibrosPrestados() == maxPrestamos) {
                System.out.println("- " + u.getNombre());
            }
        }
    }

    public void usuario_con_mas_prestamos_activos() {
        if (usuarios.length == 0) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        int maxPrestamos = 0;
        Usuario usuarioMaxPrestamos = null;
        for (Usuario u : usuarios) {
            if (u.getLibrosPrestados() > maxPrestamos) {
                maxPrestamos = u.getLibrosPrestados();
                usuarioMaxPrestamos = u;
            }
        }
        if (usuarioMaxPrestamos != null) {
            System.out.println("Usuario con más préstamos activos: " + usuarioMaxPrestamos.getNombre()
                    + " (" + maxPrestamos + " libros)");
        } else {
            System.out.println("No hay usuarios con préstamos activos.");
        }
    }

}
