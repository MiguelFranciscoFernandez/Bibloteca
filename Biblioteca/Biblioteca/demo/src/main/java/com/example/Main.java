package com.example;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblio = new Biblioteca();

        biblio.registrarUsuario("Admin01", "root123", "admin");
        biblio.registrarUsuario("JuanPerez", "password99", "usuario");
        biblio.registrarUsuario("MariaG", "clave456", "usuario");

    }
}
