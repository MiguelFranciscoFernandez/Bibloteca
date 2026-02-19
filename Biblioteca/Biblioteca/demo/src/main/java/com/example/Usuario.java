/**
 * @author Miguel Francisco
 * Clase que representa un Usuario en el sistema de gestión.
 */
package com.example;

public class Usuario {
    private String nombre;
    private String password;
    private String rol;
    private int librosPrestados;
    private int librosDevueltos;

    public Usuario() {
    }

    public Usuario(String nombre, String password, String rol) {
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.librosPrestados = 0;
        this.librosDevueltos = 0;
    }

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

    public void setLibrosPrestados(int librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    public int getLibrosDevueltos() {
        return librosDevueltos;
    }

    public void setLibrosDevueltos(int librosDevueltos) {
        this.librosDevueltos = librosDevueltos;
    }
}