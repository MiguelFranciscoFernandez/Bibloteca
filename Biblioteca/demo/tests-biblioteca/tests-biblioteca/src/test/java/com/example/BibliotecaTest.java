package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Biblioteca
 */
public class BibliotecaTest {
    private Biblioteca biblioteca;

    @BeforeEach
    public void setUp() {
        // Crear una biblioteca vacía antes de cada test
        biblioteca = new Biblioteca();
    }

    @Test
    public void testConstructorVacio() {
        assertNotNull(biblioteca);
        assertEquals(0, biblioteca.getLibro().length, "La biblioteca debería iniciar sin libros");
        assertEquals(0, biblioteca.getUsuario().length, "La biblioteca debería iniciar sin usuarios");
        assertEquals(0, biblioteca.getPrestamos().length, "La biblioteca debería iniciar sin préstamos");
    }

    @Test
    public void testConstructorConParametros() {
        Libro[] libros = new Libro[1];
        libros[0] = new Libro("Test", "Autor Test", "Editorial Test", 123456789L, 100, Genero.drama);
        
        Usuario[] usuarios = new Usuario[1];
        usuarios[0] = new Usuario("Usuario Test", "pass", "usuario");
        
        Prestamos[] prestamos = new Prestamos[0];
        
        Biblioteca bibConParametros = new Biblioteca(libros, usuarios, prestamos);
        
        assertNotNull(bibConParametros);
        assertEquals(1, bibConParametros.getLibro().length);
        assertEquals(1, bibConParametros.getUsuario().length);
        assertEquals(0, bibConParametros.getPrestamos().length);
    }

    @Test
    public void testAgregarLibro() {
        assertEquals(0, biblioteca.getLibro().length);
        
        biblioteca.Agregar_Libro("El Principito", "Antoine de Saint-Exupéry", 
                                "Reynal & Hitchcock", 9780156012195L, 96, Genero.drama);
        
        assertEquals(1, biblioteca.getLibro().length);
        assertEquals("El Principito", biblioteca.getLibro()[0].getTitulo());
        assertEquals("Antoine de Saint-Exupéry", biblioteca.getLibro()[0].getAutor());
    }

    @Test
    public void testAgregarMultiplesLibros() {
        biblioteca.Agregar_Libro("Libro 1", "Autor 1", "Editorial 1", 111L, 100, Genero.Romance);
        biblioteca.Agregar_Libro("Libro 2", "Autor 2", "Editorial 2", 222L, 200, Genero.manga);
        biblioteca.Agregar_Libro("Libro 3", "Autor 3", "Editorial 3", 333L, 300, Genero.terror);
        
        assertEquals(3, biblioteca.getLibro().length);
        assertEquals("Libro 1", biblioteca.getLibro()[0].getTitulo());
        assertEquals("Libro 2", biblioteca.getLibro()[1].getTitulo());
        assertEquals("Libro 3", biblioteca.getLibro()[2].getTitulo());
    }

    @Test
    public void testEliminarLibroPorTitulo() {
        // Agregar libros
        biblioteca.Agregar_Libro("Libro A", "Autor A", "Editorial A", 111L, 100, Genero.drama);
        biblioteca.Agregar_Libro("Libro B", "Autor B", "Editorial B", 222L, 200, Genero.terror);
        biblioteca.Agregar_Libro("Libro C", "Autor C", "Editorial C", 333L, 300, Genero.manga);
        
        assertEquals(3, biblioteca.getLibro().length);
        
        // Eliminar el libro B
        biblioteca.Eliminar_Libro("Libro B");
        
        assertEquals(2, biblioteca.getLibro().length);
        assertEquals("Libro A", biblioteca.getLibro()[0].getTitulo());
        assertEquals("Libro C", biblioteca.getLibro()[1].getTitulo());
    }

    @Test
    public void testEliminarLibroPorISBN() {
        // Agregar libros
        biblioteca.Agregar_Libro("Libro A", "Autor A", "Editorial A", 111L, 100, Genero.drama);
        biblioteca.Agregar_Libro("Libro B", "Autor B", "Editorial B", 222L, 200, Genero.terror);
        
        assertEquals(2, biblioteca.getLibro().length);
        
        // Eliminar por ISBN
        biblioteca.Eliminar_Libro(111L);
        
        assertEquals(1, biblioteca.getLibro().length);
        assertEquals("Libro B", biblioteca.getLibro()[0].getTitulo());
    }

    @Test
    public void testEliminarLibroNoExistentePorTitulo() {
        biblioteca.Agregar_Libro("Libro A", "Autor A", "Editorial A", 111L, 100, Genero.drama);
        
        int cantidadAntes = biblioteca.getLibro().length;
        
        // Intentar eliminar un libro que no existe
        biblioteca.Eliminar_Libro("Libro Inexistente");
        
        // La cantidad debería seguir siendo la misma
        assertEquals(cantidadAntes, biblioteca.getLibro().length);
    }

    @Test
    public void testEliminarLibroNoExistentePorISBN() {
        biblioteca.Agregar_Libro("Libro A", "Autor A", "Editorial A", 111L, 100, Genero.drama);
        
        int cantidadAntes = biblioteca.getLibro().length;
        
        // Intentar eliminar con ISBN inexistente
        biblioteca.Eliminar_Libro(999999L);
        
        assertEquals(cantidadAntes, biblioteca.getLibro().length);
    }

    @Test
    public void testBuscarLibroExistente() {
        biblioteca.Agregar_Libro("Harry Potter", "J.K. Rowling", "Bloomsbury", 
                                9780747532699L, 223, Genero.magia);
        
        // Este test solo verifica que no lance excepciones
        // La salida va a System.out
        assertDoesNotThrow(() -> biblioteca.Buscar_Libro("Harry Potter"));
    }

    @Test
    public void testBuscarLibroNoExistente() {
        biblioteca.Agregar_Libro("Libro A", "Autor A", "Editorial A", 111L, 100, Genero.drama);
        
        // Verificar que no lance excepciones al buscar libro inexistente
        assertDoesNotThrow(() -> biblioteca.Buscar_Libro("Libro Inexistente"));
    }

    @Test
    public void testBuscarLibroCaseInsensitive() {
        biblioteca.Agregar_Libro("El Señor de los Anillos", "J.R.R. Tolkien", 
                                "Allen & Unwin", 9780618640157L, 1178, Genero.magia);
        
        // La búsqueda debería ser case insensitive
        assertDoesNotThrow(() -> biblioteca.Buscar_Libro("el señor de los anillos"));
        assertDoesNotThrow(() -> biblioteca.Buscar_Libro("EL SEÑOR DE LOS ANILLOS"));
    }

    @Test
    public void testMostrarLibrosVacio() {
        // Verificar que no lance excepciones cuando la biblioteca está vacía
        assertDoesNotThrow(() -> biblioteca.Mostrar_Libros());
    }

    @Test
    public void testMostrarLibrosConLibros() {
        biblioteca.Agregar_Libro("Libro 1", "Autor 1", "Editorial 1", 111L, 100, Genero.Romance);
        biblioteca.Agregar_Libro("Libro 2", "Autor 2", "Editorial 2", 222L, 200, Genero.manga);
        
        // Verificar que no lance excepciones
        assertDoesNotThrow(() -> biblioteca.Mostrar_Libros());
    }

    @Test
    public void testEliminarPrimerLibro() {
        biblioteca.Agregar_Libro("Libro 1", "Autor 1", "Editorial 1", 111L, 100, Genero.Romance);
        biblioteca.Agregar_Libro("Libro 2", "Autor 2", "Editorial 2", 222L, 200, Genero.manga);
        biblioteca.Agregar_Libro("Libro 3", "Autor 3", "Editorial 3", 333L, 300, Genero.terror);
        
        biblioteca.Eliminar_Libro("Libro 1");
        
        assertEquals(2, biblioteca.getLibro().length);
        assertEquals("Libro 2", biblioteca.getLibro()[0].getTitulo());
    }

    @Test
    public void testEliminarUltimoLibro() {
        biblioteca.Agregar_Libro("Libro 1", "Autor 1", "Editorial 1", 111L, 100, Genero.Romance);
        biblioteca.Agregar_Libro("Libro 2", "Autor 2", "Editorial 2", 222L, 200, Genero.manga);
        biblioteca.Agregar_Libro("Libro 3", "Autor 3", "Editorial 3", 333L, 300, Genero.terror);
        
        biblioteca.Eliminar_Libro("Libro 3");
        
        assertEquals(2, biblioteca.getLibro().length);
        assertEquals("Libro 2", biblioteca.getLibro()[1].getTitulo());
    }

    @Test
    public void testEliminarLibroDelMedio() {
        biblioteca.Agregar_Libro("Libro 1", "Autor 1", "Editorial 1", 111L, 100, Genero.Romance);
        biblioteca.Agregar_Libro("Libro 2", "Autor 2", "Editorial 2", 222L, 200, Genero.manga);
        biblioteca.Agregar_Libro("Libro 3", "Autor 3", "Editorial 3", 333L, 300, Genero.terror);
        
        biblioteca.Eliminar_Libro("Libro 2");
        
        assertEquals(2, biblioteca.getLibro().length);
        assertEquals("Libro 1", biblioteca.getLibro()[0].getTitulo());
        assertEquals("Libro 3", biblioteca.getLibro()[1].getTitulo());
    }

    @Test
    public void testAgregarYEliminarTodosLosLibros() {
        biblioteca.Agregar_Libro("Libro 1", "Autor 1", "Editorial 1", 111L, 100, Genero.Romance);
        biblioteca.Agregar_Libro("Libro 2", "Autor 2", "Editorial 2", 222L, 200, Genero.manga);
        
        assertEquals(2, biblioteca.getLibro().length);
        
        biblioteca.Eliminar_Libro("Libro 1");
        biblioteca.Eliminar_Libro("Libro 2");
        
        assertEquals(0, biblioteca.getLibro().length);
    }

    @Test
    public void testGetters() {
        assertNotNull(biblioteca.getLibro());
        assertNotNull(biblioteca.getUsuario());
        assertNotNull(biblioteca.getPrestamos());
    }

    @Test
    public void testAgregarLibrosConDiferentesGeneros() {
        biblioteca.Agregar_Libro("Romance Book", "Author", "Edit", 1L, 100, Genero.Romance);
        biblioteca.Agregar_Libro("Manga Book", "Author", "Edit", 2L, 100, Genero.manga);
        biblioteca.Agregar_Libro("SciFi Book", "Author", "Edit", 3L, 100, Genero.ciencia_ficcion);
        biblioteca.Agregar_Libro("Magic Book", "Author", "Edit", 4L, 100, Genero.magia);
        biblioteca.Agregar_Libro("History Book", "Author", "Edit", 5L, 100, Genero.historicos);
        biblioteca.Agregar_Libro("Science Book", "Author", "Edit", 6L, 100, Genero.cientificos);
        biblioteca.Agregar_Libro("Educational Book", "Author", "Edit", 7L, 100, Genero.educativos);
        biblioteca.Agregar_Libro("Horror Book", "Author", "Edit", 8L, 100, Genero.terror);
        biblioteca.Agregar_Libro("Drama Book", "Author", "Edit", 9L, 100, Genero.drama);
        
        assertEquals(9, biblioteca.getLibro().length);
    }
}
