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

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public int getLibrosPrestados() {
        return librosPrestados;
    }
    public void prestarLibro() {
        librosPrestados++;
    }
    public void devolverLibro() {
        if (librosPrestados > 0) {
            librosPrestados--;
        }
    }
}
