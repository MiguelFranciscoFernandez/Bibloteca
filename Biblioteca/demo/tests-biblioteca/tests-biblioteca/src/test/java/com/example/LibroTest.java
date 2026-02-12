package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Libro
 */
public class LibroTest {
    private Libro libro;

    @BeforeEach
    public void setUp() {
        // Configurar un libro de prueba antes de cada test
        libro = new Libro("El Quijote", "Miguel de Cervantes", "Editorial Planeta", 
                         9788408043640L, 1200, Genero.historicos);
    }

    @Test
    public void testConstructorVacio() {
        Libro libroVacio = new Libro();
        assertNotNull(libroVacio, "El libro no debería ser null");
    }

    @Test
    public void testConstructorConParametros() {
        assertNotNull(libro, "El libro no debería ser null");
        assertEquals("El Quijote", libro.getTitulo(), "El título debería ser 'El Quijote'");
        assertEquals("Miguel de Cervantes", libro.getAutor(), "El autor debería ser 'Miguel de Cervantes'");
        assertEquals("Editorial Planeta", libro.getEditorial(), "La editorial debería ser 'Editorial Planeta'");
        assertEquals(9788408043640L, libro.getIsbn(), "El ISBN debería coincidir");
        assertEquals(1200, libro.getN_paginas(), "El número de páginas debería ser 1200");
        assertEquals(Genero.historicos, libro.getGenero(), "El género debería ser 'historicos'");
    }

    @Test
    public void testGettersYSetters() {
        // Test de setters
        libro.setTitulo("Cien años de soledad");
        libro.setAutor("Gabriel García Márquez");
        libro.setEditorial("Sudamericana");
        libro.setIsbn(9780307474728L);
        libro.setN_paginas(471);
        libro.setGenero(Genero.drama);

        // Test de getters
        assertEquals("Cien años de soledad", libro.getTitulo());
        assertEquals("Gabriel García Márquez", libro.getAutor());
        assertEquals("Sudamericana", libro.getEditorial());
        assertEquals(9780307474728L, libro.getIsbn());
        assertEquals(471, libro.getN_paginas());
        assertEquals(Genero.drama, libro.getGenero());
    }

    @Test
    public void testTodosLosGeneros() {
        // Verificar que todos los géneros funcionan correctamente
        libro.setGenero(Genero.Romance);
        assertEquals(Genero.Romance, libro.getGenero());
        
        libro.setGenero(Genero.manga);
        assertEquals(Genero.manga, libro.getGenero());
        
        libro.setGenero(Genero.ciencia_ficcion);
        assertEquals(Genero.ciencia_ficcion, libro.getGenero());
        
        libro.setGenero(Genero.magia);
        assertEquals(Genero.magia, libro.getGenero());
        
        libro.setGenero(Genero.cientificos);
        assertEquals(Genero.cientificos, libro.getGenero());
        
        libro.setGenero(Genero.educativos);
        assertEquals(Genero.educativos, libro.getGenero());
        
        libro.setGenero(Genero.terror);
        assertEquals(Genero.terror, libro.getGenero());
    }

    @Test
    public void testIsbnPositivo() {
        libro.setIsbn(1234567890123L);
        assertTrue(libro.getIsbn() > 0, "El ISBN debería ser positivo");
    }

    @Test
    public void testNumeroPaginasPositivo() {
        libro.setN_paginas(500);
        assertTrue(libro.getN_paginas() > 0, "El número de páginas debería ser positivo");
    }
}
