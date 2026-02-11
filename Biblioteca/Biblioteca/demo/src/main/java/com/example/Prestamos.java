package com.example;
public class Prestamos {
    private Usuario usuario;
    private Libro libro;
    private String fechaPrestamo;
    private String fechaDevolucion;


    public Prestamos(){

    }
    
    public Prestamos(String fechaPRestamo , String fechaDevolucion, Usuario usuario, Libro libro){
        this.fechaPrestamo = fechaPRestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.usuario = usuario;
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }


    // Realizar préstamo
    public void realizarPrestamo() {
        if (usuario.getLibrosPrestados() < 2 && usuario.getLibrosPrestados() > 0) {
            usuario.incrementarPrestamos();
            System.out.println("Préstamo realizado del  " + libro.getTitulo() + "ha sido prestado el " + this.fechaPrestamo + "  a " + usuario.getNombre());
        } else {
            System.out.println("El usuario " + usuario.getNombre() + " ya tiene 2 libros prestados. No se puede realizar el préstamo.");
        }
    }

    // Realizar devolución
        public void realizarDevolucion() {
        if (usuario.getLibrosPrestados() > 0 && usuario.getLibrosPrestados() < 2) {
            usuario.incrementarDevolucion(usuario.getLibrosPrestados());
            System.out.println("Devolución realizada del " + libro.getTitulo() + " se ha devuelto el " + this.fechaDevolucion + " por " + usuario.getNombre());
        } else {
            System.out.println("El usuario " + usuario.getNombre() + " no tiene libros prestados. No se puede realizar la devolución de ningun libro.");
        }
    }
}

