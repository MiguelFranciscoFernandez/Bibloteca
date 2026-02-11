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
    private int librosDevueltos;

    public Usuario(String nombre, String password, String rol) {
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.librosPrestados = 0;
        this.librosDevueltos = 0;
    }

    // Getters y setters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setLibrosPrestados(int librosPrestados) {
        this.librosPrestados = librosPrestados;
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

    public int getLibrosDevueltos() {
        return librosDevueltos;
    }

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
}
