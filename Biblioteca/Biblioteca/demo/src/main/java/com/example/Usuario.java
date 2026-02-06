/**
 * @author Miguel Francisco
 * Clase que representa un Libro en el sistema de gestión.
 */

/******************************************************************
 * RESPONSABLE: COMPAÑERO B
 * TAREAS: 
 * - Definición del objeto Usuario (Nombre, password, rol).
 * - Gestión de préstamos activos por perfil.
 * - Métodos para actualizar el contador de libros del usuario.
 ******************************************************************/
package com.example;
public class Usuario {
    private String nombre;
    private String password;
    private String rol;
    private int prestamosActivos; // Para las estadicsticas globales

    public Usuario(String nombre, String password, String rol) {
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.prestamosActivos = 0; // Inicialmente sin préstamos
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }
    public String getRol() {
        return rol;
    }
    public int getPrestamosActivos() {
        return prestamosActivos;
    }
}


