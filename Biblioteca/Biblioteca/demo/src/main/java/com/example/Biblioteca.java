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
public class Biblioteca {
    
    // 1. Atributo de la clase inicializado en 0
    private Usuario[] listaUsuarios = new Usuario[0];

    // 2. Método de creación de usuarios
    public void registrarUsuario(String nombre, String pass, String rol) {
        // DEFINIR UNO NUEVO CON LONGITUD +1
        Usuario[] nuevoArray = new Usuario[this.listaUsuarios.length + 1];

        // Copiar los datos del anterior al nuevo
        for (int i = 0; i < this.listaUsuarios.length; i++) {
            nuevoArray[i] = this.listaUsuarios[i];
        }

        // Añadir el nuevo usuario en la última posición
        nuevoArray[nuevoArray.length - 1] = new Usuario(nombre, pass, rol);

        // SE LA PONEMOS AL ATRIBUTO DE LA CLASE
        this.listaUsuarios = nuevoArray;
    }
}
