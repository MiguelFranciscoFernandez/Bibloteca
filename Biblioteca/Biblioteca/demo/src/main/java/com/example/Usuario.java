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


}
