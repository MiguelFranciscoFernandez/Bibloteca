package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

/**
 * 1. Compañero A: El Arquitecto de Datos (Modelos y Archivos)
 * 
 * Se encarga de crear el "molde" de lo que vamos a guardar.
 * 
 * Clase Libro.java: Atributos (título, autor, categoría, estado, contador de
 * préstamos) y sus métodos básicos.
 * 
 * Clase Usuario.java: Atributos (nombre, password, rol, contador de préstamos
 * activos) y sus métodos.
 * 
 * Documentación: Es el responsable de poner las etiquetas @author correctamente
 * en todas las clases y asegurar que el código sigue las normas de estilo.
 * 
 * 2. Compañero B: El Motor del Sistema (Lógica de Biblioteca)
 * 
 * Se encarga de que todo funcione "por dentro". Es quien más usará los Arrays.
 * 
 * Clase Biblioteca.java:
 * 
 * Gestionar el Array de Libros (Añadir, eliminar, buscar).
 * 
 * Gestionar el Array de Usuarios (Registrar nuevos, listar).
 * 
 * Estadísticas: Crear los métodos para encontrar el libro más popular o el
 * usuario con más libros.
 * 
 * 3. Compañero C: El Gestor de Flujo (Login, Roles y Préstamos)
 * 
 * Se encarga de la seguridad y de cómo el usuario interactúa con el sistema.
 * 
 * Sistema de Roles: Lógica de validación de administrador vs. usuario.
 * 
 * Gestión de Préstamos: Los métodos para cambiar el estado de un libro de
 * "disponible" a "prestado" y viceversa.
 * 
 * Clase Main.java: Crear la Consola Interactiva, los datos de prueba y el
 * sistema de Login que redirige a los menús correspondiente
 */