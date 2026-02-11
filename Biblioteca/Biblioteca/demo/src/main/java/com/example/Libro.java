/**
 * @author David Espejo
 * Clase que representa un Libro en el sistema de gestión.
 */

/******************************************************************
 * RESPONSABLE: COMPAÑERO A
 * TAREAS: 
 * - Definición del objeto Libro (Atributos: título, autor, cat).
 * - Estado de disponibilidad y contador de préstamos.
 * - Método toString para visualización.
 ******************************************************************/
package com.example;

enum Genero {
    Romance, manga, ciencia_ficcion, magia, historicos, cientificos, educativos, terror, drama
}

public class Libro {
    private String titulo;
    private String autor;
    private String editorial;
    private long Isbn;
    private int n_paginas;
    private Genero genero;

    public Libro() {
    }

    public Libro(String titulo, String autor, String editorial, long Isbn, int n_paginas, Genero genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.Isbn = Isbn;
        this.n_paginas = n_paginas;
        this.genero = genero;
    }




    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public long getIsbn() {
        return Isbn;
    }

    public void setIsbn(long isbn) {
        Isbn = isbn;
    }

    public int getN_paginas() {
        return n_paginas;
    }

    public void setN_paginas(int n_paginas) {
        this.n_paginas = n_paginas;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

}
