package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca Perez_Reberte = new Biblioteca();
        Usuario root = new Usuario("David", "1234", true);
        Usuario invitado = new Usuario("Usuario", "Usuario", false);
        Perez_Reberte.Agregar_Usuario_Directo(root);
        Perez_Reberte.Agregar_Usuario_Directo(invitado);

        System.out.println("=== LOGIN ===");
        System.out.print("Usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = sc.nextLine();

        Perez_Reberte.Login(usuario, contrasena);
        Perez_Reberte.inicio(usuario, contrasena);

        if (Perez_Reberte.getUsuarioActual().getRol()) {
            int opcion = sc.nextInt();
            sc.nextLine();
            do {
                switch (opcion) {
                    case 1:
                        System.out.println("Titulo");
                        String titulo = sc.nextLine();
                        System.out.println("Autor");
                        String autor = sc.nextLine();
                        System.out.println("Editorial");
                        String editorial = sc.nextLine();
                        System.out.println("ISBN");
                        String isbn = sc.nextLine();
                        System.out.println("Paginas");
                        int n_paginas = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Genero");
                        String genero = sc.nextLine();
                        Perez_Reberte.Agregar_Libro(titulo, autor, editorial, isbn, n_paginas, genero);
                        break;
                    case 2:
                        System.out.println("1 Eliminar por nombre ");
                        System.out.println("2 Eliminar por ISBN ");
                        int opcion2 = sc.nextInt();
                        sc.nextLine();
                        switch (opcion2) {
                            case 1:
                                System.out.println("Titulo");
                                String titulo2 = sc.nextLine();
                                Perez_Reberte.Eliminar_Libro(titulo2);
                                break;
                            case 2:
                                System.out.println("ISBN");
                                String isbn2 = sc.nextLine();
                                Perez_Reberte.Eliminar_Libro_ISBN(isbn2);
                                break;
                            default:
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Titulo");
                        String titulo3 = sc.nextLine();
                        Perez_Reberte.Buscar_Libro(titulo3);
                        break;
                    case 4:
                        Perez_Reberte.Mostrar_Libros();
                        break;
                    case 5:
                        System.out.println("nombre");
                        String nombre = sc.nextLine();
                        System.out.println("contraseña");
                        String contrasena1 = sc.nextLine();
                        System.out.println("¿Es administrador? 1 Si, 2 No");
                        int rol = sc.nextInt();
                        sc.nextLine();
                        boolean rol1;
                        if (rol == 1) {
                            rol1 = true;
                        } else {
                            rol1 = false;
                        }
                        Perez_Reberte.Agregar_Usuario(nombre, contrasena1, rol1);
                        break;
                    case 6:
                        Perez_Reberte.Mostrar_Usuarios();
                        break;
                    case 7:
                        System.out.print("Nombre de usuario: ");
                        String nombrePrestamo = sc.nextLine();
                        System.out.print("Título del libro: ");
                        String tituloPrestamo = sc.nextLine();
                        System.out.print("Fecha del préstamo (dd/mm/aaaa): ");
                        String fechaPrestamo = sc.nextLine();
                        Perez_Reberte.Registrar_Prestamo(nombrePrestamo, tituloPrestamo, fechaPrestamo);
                        break;
                    case 8:
                        System.out.print("Nombre de usuario: ");
                        String nombreDev = sc.nextLine();
                        System.out.print("Título del libro: ");
                        String tituloDev = sc.nextLine();
                        System.out.print("Fecha de devolución (dd/mm/aaaa): ");
                        String fechaDev = sc.nextLine();
                        Perez_Reberte.Registrar_Devolucion(nombreDev, tituloDev, fechaDev);
                        break;
                    case 9:
                        Perez_Reberte.Mostrar_Libros_Prestados();
                        break;
                    case 10:
                        Perez_Reberte.Mostrar_Prestamos_Prestados_Devueltos();
                        break;
                    case 11:
                        Perez_Reberte.Libros_Mas_Prestados();
                        break;
                    case 12:
                        Perez_Reberte.usuario_con_mas_prestamos_activos();
                        break;
                    case 0:
                        System.out.println("\n¡Hasta pronto!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
                Perez_Reberte.mostrarMenuAdmin();
                opcion = sc.nextInt();
                sc.nextLine();
            } while (opcion != 0);

        } else {
            int opcion;
            do {
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.print("Título: ");
                        String titulo = sc.nextLine();
                        Perez_Reberte.Buscar_Libro(titulo);
                        break;
                    case 2:
                        Perez_Reberte.Mostrar_Libros();
                        break;
                    case 3:
                        System.out.print("Nombre de usuario: ");
                        String nombrePrestamo = sc.nextLine();
                        System.out.print("Título del libro: ");
                        String tituloPrestamo = sc.nextLine();
                        System.out.print("Fecha del préstamo (dd/mm/aaaa): ");
                        String fechaPrestamo = sc.nextLine();
                        Perez_Reberte.Registrar_Prestamo(nombrePrestamo, tituloPrestamo, fechaPrestamo);
                        break;
                    case 4:
                        System.out.print("Nombre de usuario: ");
                        String nombreDev = sc.nextLine();
                        System.out.print("Título del libro: ");
                        String tituloDev = sc.nextLine();
                        System.out.print("Fecha de devolución (dd/mm/aaaa): ");
                        String fechaDev = sc.nextLine();
                        Perez_Reberte.Registrar_Devolucion(nombreDev, tituloDev, fechaDev);
                        break;
                    case 5:
                        Perez_Reberte.Libros_Mas_Prestados();
                        break;
                    case 0:
                        System.out.println("\n¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
                if (opcion != 0) {
                    Perez_Reberte.mostrarMenuUsuario();
                }
            } while (opcion != 0);
            sc.close();
        }
    }
}
