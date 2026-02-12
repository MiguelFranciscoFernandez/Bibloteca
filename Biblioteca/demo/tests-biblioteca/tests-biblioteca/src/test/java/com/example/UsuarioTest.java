package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Usuario
 */
public class UsuarioTest {
    private Usuario usuario;
    private Usuario admin;

    @BeforeEach
    public void setUp() {
        // Crear usuarios de prueba antes de cada test
        usuario = new Usuario("Juan Pérez", "password123", "usuario");
        admin = new Usuario("María Admin", "admin123", "admin");
    }

    @Test
    public void testConstructor() {
        assertNotNull(usuario, "El usuario no debería ser null");
        assertEquals("Juan Pérez", usuario.getNombre());
        assertEquals("password123", usuario.getPassword());
        assertEquals("usuario", usuario.getRol());
        assertEquals(0, usuario.getLibrosPrestados(), "Los libros prestados deberían iniciar en 0");
        assertEquals(0, usuario.getLibrosDevueltos(), "Los libros devueltos deberían iniciar en 0");
    }

    @Test
    public void testGettersYSetters() {
        usuario.setNombre("Pedro López");
        usuario.setPassword("newpass456");
        usuario.setRol("admin");
        usuario.setLibrosPrestados(2);

        assertEquals("Pedro López", usuario.getNombre());
        assertEquals("newpass456", usuario.getPassword());
        assertEquals("admin", usuario.getRol());
        assertEquals(2, usuario.getLibrosPrestados());
    }

    @Test
    public void testIncrementarPrestamos() {
        assertEquals(0, usuario.getLibrosPrestados());
        
        usuario.incrementarPrestamos();
        assertEquals(1, usuario.getLibrosPrestados());
        
        usuario.incrementarPrestamos();
        assertEquals(2, usuario.getLibrosPrestados());
    }

    @Test
    public void testIncrementarDevolucion() {
        // Primero prestamos libros
        usuario.incrementarPrestamos();
        usuario.incrementarPrestamos();
        assertEquals(2, usuario.getLibrosPrestados());
        
        // Luego devolvemos
        usuario.incrementarDevolucion(2);
        assertEquals(1, usuario.getLibrosDevueltos());
        
        usuario.incrementarDevolucion(1);
        assertEquals(2, usuario.getLibrosDevueltos());
    }

    @Test
    public void testIncrementarDevolucionSinPrestamos() {
        // Si no hay libros prestados, no debería incrementar devoluciones
        assertEquals(0, usuario.getLibrosPrestados());
        usuario.incrementarDevolucion(0);
        assertEquals(0, usuario.getLibrosDevueltos(), "No debería incrementar si no hay préstamos");
    }

    @Test
    public void testTienePermisoAdmin_ConAdmin() {
        assertTrue(admin.tienePermisoAdmin(), "El usuario admin debería tener permisos");
    }

    @Test
    public void testTienePermisoAdmin_SinAdmin() {
        assertFalse(usuario.tienePermisoAdmin(), "El usuario normal no debería tener permisos admin");
    }

    @Test
    public void testTienePermisoAdmin_CaseInsensitive() {
        Usuario adminMayusculas = new Usuario("Admin", "pass", "ADMIN");
        assertTrue(adminMayusculas.tienePermisoAdmin(), "Debería reconocer 'ADMIN' como administrador");
        
        Usuario adminMinusculas = new Usuario("Admin", "pass", "admin");
        assertTrue(adminMinusculas.tienePermisoAdmin(), "Debería reconocer 'admin' como administrador");
        
        Usuario adminMixto = new Usuario("Admin", "pass", "AdMiN");
        assertTrue(adminMixto.tienePermisoAdmin(), "Debería reconocer 'AdMiN' como administrador");
    }

    @Test
    public void testValidarPassword_Correcta() {
        assertTrue(usuario.validarPassword("password123"), "La contraseña correcta debería validarse");
    }

    @Test
    public void testValidarPassword_Incorrecta() {
        assertFalse(usuario.validarPassword("wrongpass"), "La contraseña incorrecta no debería validarse");
    }

    @Test
    public void testValidarPassword_CaseSensitive() {
        assertFalse(usuario.validarPassword("PASSWORD123"), "La validación debería ser case-sensitive");
    }

    @Test
    public void testValidarPassword_Vacia() {
        assertFalse(usuario.validarPassword(""), "Una contraseña vacía no debería validarse");
    }

    @Test
    public void testMultiplesPrestamosYDevoluciones() {
        // Escenario completo
        usuario.incrementarPrestamos();
        assertEquals(1, usuario.getLibrosPrestados());
        
        usuario.incrementarPrestamos();
        assertEquals(2, usuario.getLibrosPrestados());
        
        usuario.incrementarDevolucion(2);
        assertEquals(1, usuario.getLibrosDevueltos());
        
        usuario.incrementarDevolucion(1);
        assertEquals(2, usuario.getLibrosDevueltos());
    }

    @Test
    public void testDiferentesTiposDeRoles() {
        Usuario usuarioNormal = new Usuario("User1", "pass", "usuario");
        assertFalse(usuarioNormal.tienePermisoAdmin());
        
        Usuario bibliotecario = new Usuario("User2", "pass", "bibliotecario");
        assertFalse(bibliotecario.tienePermisoAdmin());
        
        Usuario adminUser = new Usuario("User3", "pass", "admin");
        assertTrue(adminUser.tienePermisoAdmin());
    }
}
