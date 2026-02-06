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
    private int librosPrestados;

    public Usuario(String nombre, String password, String rol) {
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.librosPrestados = 0; // Inicialmente no tiene libros prestados
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    public int getLibrosPrestados() {

        return librosPrestados;
    }

    // Métodos para actualizar el contador del usuario
    public void incrementarPrestamos() {
        this.librosPrestados++;
    }

    public void decrementarPrestamos() {
        if (this.librosPrestados > 0)
            this.librosPrestados--;
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
}
