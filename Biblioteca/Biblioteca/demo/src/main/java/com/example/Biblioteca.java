/**
 * @author David Conde
 * Clase que representa  el sistema de gestión.
 */

/******************************************************************
 * RESPONSABLE: COMPAÑERO C
 * TAREAS: 
 * - Motor de ARRAYS DINÁMICOS (Redimensionado manual +1 / -1).
 * - Lógica interna de agregar/eliminar libros del sistema.
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

    // AGREGRAR USUARIO

    // AGREGAR LIBRO
    public void Agregar_Libro(String titulo, String autor, String editorial, String isbn, int n_paginas,
            Genero genero) {
        libros = Arrays.copyOf(libros, libros.length + 1);
        libros[libros.length - 1] = new Libro(titulo, autor, editorial, isbn, n_paginas, genero);
        System.out.println("Nuevo libro añadido de forma correcta");
    }

    // ELIMINAR LIBRO por título
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

    // ELIMINAR LIBRO por ISBN
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

    // BUSCAR LIBRO
    public void Buscar_Libro(String titulo) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i].getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Libro encontrado:");
                System.out.println("Título: " + libros[i].getTitulo());
                System.out.println("Autor: " + libros[i].getAutor());
                System.out.println("ISBN: " + libros[i].getIsbn());
                return;
            }
        }
        System.out.println("Libro no encontrado");
    }

    // Mostrar todos los libros disponibles
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
    //parte Usuario
    // Métodos para actualizar el contador del usuario
    public void incrementarPrestamos() {
        this.librosPrestados++;
    }

    public void incrementarDevolucion(int librosprestados) {
        if (this.librosPrestados > 0)
            this.librosDevueltos++;
    }

    public boolean tienePermisoAdmin() {
        if (this.rol.equalsIgnoreCase("admin")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarPassword(String intentoPassword) {
        if (this.password.equals(intentoPassword)) {
            return true;
        } else {
            // Mensaje opcional de aviso
            System.out.println(" Contraseña incorrecta para el usuario: " + this.nombre);
            return false;
        }
    }

     //Parte prestamo
    
    // Realizar préstamo
    public void realizarPrestamo() {
        if (usuario.getLibrosPrestados() < 2 && usuario.getLibrosPrestados() >= 0) {
            usuario.incrementarPrestamos();
            System.out.println("Préstamo realizado del  " + libro.getTitulo() + "ha sido prestado el " + this.fechaPrestamo + "  a " + usuario.getNombre());
        } else {
            System.out.println("El usuario " + usuario.getNombre() + " ya tiene 2 libros prestados. No se puede realizar el préstamo.");
        }
    }

    // Realizar devolución
        public void realizarDevolucion() {
        if (usuario.getLibrosPrestados() > 0 && usuario.getLibrosPrestados() < 2) {
            usuario.incrementarDevolucion(usuario.getLibrosPrestados());
            System.out.println("Devolución realizada del " + libro.getTitulo() + " se ha devuelto el " + this.fechaDevolucion + " por " + usuario.getNombre());
        } else {
            System.out.println("El usuario " + usuario.getNombre() + " no tiene libros prestados. No se puede realizar la devolución de ningun libro.");
        }
    }

    //Saber si el libroesta prestado o no un libro
}


