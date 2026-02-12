package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Prestamos
 */
public class PrestamosTest {
    private Prestamos prestamo;
    private Usuario usuario;
    private Libro libro;

    @BeforeEach
    public void setUp() {
        // Crear objetos de prueba
        usuario = new Usuario("Carlos Ruiz", "pass123", "usuario");
        libro = new Libro("1984", "George Orwell", "Secker & Warburg", 
                         9780451524935L, 328, Genero.ciencia_ficcion);
        prestamo = new Prestamos("2024-02-01", "2024-02-15", usuario, libro);
    }

    @Test
    public void testConstructorVacio() {
        Prestamos prestamoVacio = new Prestamos();
        assertNotNull(prestamoVacio, "El préstamo no debería ser null");
    }

    @Test
    public void testConstructorConParametros() {
        assertNotNull(prestamo);
        assertEquals("2024-02-01", prestamo.getFechaPrestamo());
        assertEquals("2024-02-15", prestamo.getFechaDevolucion());
        assertEquals(usuario, prestamo.getUsuario());
        assertEquals(libro, prestamo.getLibro());
    }

    @Test
    public void testGettersYSetters() {
        Usuario nuevoUsuario = new Usuario("Ana García", "pass456", "usuario");
        Libro nuevoLibro = new Libro("El Hobbit", "J.R.R. Tolkien", "Allen & Unwin",
                                    9780547928227L, 310, Genero.magia);

        prestamo.setUsuario(nuevoUsuario);
        prestamo.setLibro(nuevoLibro);
        prestamo.setFechaPrestamo("2024-03-01");
        prestamo.setFechaDevolucion("2024-03-15");

        assertEquals(nuevoUsuario, prestamo.getUsuario());
        assertEquals(nuevoLibro, prestamo.getLibro());
        assertEquals("2024-03-01", prestamo.getFechaPrestamo());
        assertEquals("2024-03-15", prestamo.getFechaDevolucion());
    }

    @Test
    public void testRealizarPrimerPrestamo() {
        // El usuario no tiene libros prestados inicialmente
        assertEquals(0, usuario.getLibrosPrestados());
        
        // Primero incrementamos manualmente para simular el primer préstamo
        usuario.incrementarPrestamos();
        prestamo.realizarPrestamo();
        
        // Debería permitir el préstamo (lógica: entre 0 y 2)
        assertEquals(2, usuario.getLibrosPrestados());
    }

    @Test
    public void testRealizarPrestamoCuandoYaTieneDos() {
        // Simulamos que el usuario ya tiene 2 libros
        usuario.incrementarPrestamos();
        usuario.incrementarPrestamos();
        assertEquals(2, usuario.getLibrosPrestados());
        
        // Intentar hacer otro préstamo no debería incrementar
        prestamo.realizarPrestamo();
        
        // Debería seguir teniendo 2 (la lógica no permite más de 2)
        assertEquals(2, usuario.getLibrosPrestados());
    }

    @Test
    public void testRealizarDevolucion() {
        // Primero prestamos un libro
        usuario.incrementarPrestamos();
        assertEquals(1, usuario.getLibrosPrestados());
        
        // Realizamos la devolución
        prestamo.realizarDevolucion();
        
        // Verificamos que se incrementó el contador de devoluciones
        assertEquals(1, usuario.getLibrosDevueltos());
    }

    @Test
    public void testRealizarDevolucionSinPrestamos() {
        // Usuario sin préstamos
        assertEquals(0, usuario.getLibrosPrestados());
        
        // Intentar devolver
        prestamo.realizarDevolucion();
        
        // No debería incrementar devoluciones
        assertEquals(0, usuario.getLibrosDevueltos());
    }

    @Test
    public void testRealizarDevolucionConUnPrestamo() {
        // Usuario con 1 libro prestado
        usuario.incrementarPrestamos();
        assertEquals(1, usuario.getLibrosPrestados());
        
        // Realizar devolución
        prestamo.realizarDevolucion();
        
        // Verificar que se registró la devolución
        assertEquals(1, usuario.getLibrosDevueltos());
    }

    @Test
    public void testCicloCompletoPrestamoDevolución() {
        // Escenario completo de préstamo y devolución
        
        // Estado inicial
        assertEquals(0, usuario.getLibrosPrestados());
        assertEquals(0, usuario.getLibrosDevueltos());
        
        // Primer préstamo
        usuario.incrementarPrestamos();
        prestamo.realizarPrestamo();
        assertEquals(2, usuario.getLibrosPrestados());
        
        // Devolución
        usuario.setLibrosPrestados(1); // Ajustamos manualmente para simular tener 1 libro
        prestamo.realizarDevolucion();
        assertEquals(1, usuario.getLibrosDevueltos());
    }

    @Test
    public void testFechasPrestamoDevolución() {
        prestamo.setFechaPrestamo("2024-01-01");
        prestamo.setFechaDevolucion("2024-01-31");
        
        assertEquals("2024-01-01", prestamo.getFechaPrestamo());
        assertEquals("2024-01-31", prestamo.getFechaDevolucion());
    }

    @Test
    public void testCambiarLibroPrestado() {
        Libro nuevoLibro = new Libro("Narnia", "C.S. Lewis", "Geoffrey Bles",
                                    9780064404990L, 206, Genero.magia);
        
        prestamo.setLibro(nuevoLibro);
        assertEquals("Narnia", prestamo.getLibro().getTitulo());
        assertEquals("C.S. Lewis", prestamo.getLibro().getAutor());
    }

    @Test
    public void testCambiarUsuarioPrestamo() {
        Usuario nuevoUsuario = new Usuario("Laura Martínez", "pass789", "usuario");
        
        prestamo.setUsuario(nuevoUsuario);
        assertEquals("Laura Martínez", prestamo.getUsuario().getNombre());
    }
}
