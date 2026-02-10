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
    private Libro[] Libro;
    private Usuario[] Usuario;
    private Prestamos[] Prestamos;
    private int Lista_Libro;
    private int lista_Usuario;
    private int Lista_Prestamos;

    public Biblioteca(){

    }

    public Biblioteca(Libro[] Libro, Usuario[] Usuario, Prestamos[] Prestamos){
        this.Libro = new Libro[0];
        this.Usuario = new Usuario[0];
        this.Prestamos = new Prestamos[0];
        this.Lista_Libro = 0;
        this.Lista_Prestamos = 0;
        this.lista_Usuario = 0;
    }

    public Libro[] getLista_Libro() {
        return Lista_Libro;
    }

    public Usuario[] getLista_Usuario() {
        return lista_Usuario;
    }

    public Prestamos[] getLista_Prestamos() {
        return Lista_Prestamos;
    }

    //Metodos para agregar libro
    public void Agregar_Libro(String titulo){
        if (Lista_Libro < Libro.length) {
            Libro[Lista_Libro] = new Libro(titulo);
            Lista_Libro++;
            System.out.println("Nuevo libro aniadido de forma correcta");
        } else {
            System.out.println("No hay más espacio para aniadir un nuevo libro");
        }
    }

    public void Agregar_Libro(long isbn){
        if (Lista_Libro < Libro.length) {
            Libro[Lista_Libro] = new Libro(isbn);
            Lista_Libro++;
            System.out.println("Nuevo libro aniadido de forma correcta");
        } else {
            System.out.println("No hay más espacio para aniadir un nuevo libro");
        }
    }

    //Metodo para eliminar libros
    public void Eliminar_Libro(String titulo){
        for (int i = 0; i < Lista_Libro; i++) {
            if (Libro[i].getTitulo() == titulo) {
                for (int j = i; j < Lista_Libro - 1; j++) {
                    Libro[j] = Libro[j + 1];
                }
                Lista_Libro--;
                System.out.println("El libro ha sido eliminado de esta biblioteca");
                return;
            }
        }
        System.out.println("Libro no encontrada");
    }

    public void Eliminar_Libro(long isbn){
        for (int i = 0; i < Lista_Libro; i++) {
            if (Libro[i].getIsbn() == isbn) {
                for (int j = i; j < Lista_Libro - 1; j++) {
                    Libro[j] = Libro[j + 1];
                }
                Lista_Libro--;
                System.out.println("El libro ha sido eliminado de esta biblioteca");
                return;
            }
        }
        System.out.println("Libro no encontrada");
    }

    public void Buscar_Libro(String titulo){

    }
}
