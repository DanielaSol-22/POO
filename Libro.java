/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

/**
 *
 * @author USUARIO 2022
 */
/**
 * Representa un libro en la biblioteca.
 */
public class Libro {
    private String titulo;
    private String autor;
    private boolean disponible;

    /**
     * Crea una nueva instancia de Libro con el título, autor y marca el libro como disponible.
     * @param titulo El título del libro.
     * @param autor El autor del libro.
     */
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    /**
     * Devuelve el título del libro.
     * @return El título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Devuelve el autor del libro.
     * @return El autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Devuelve si el libro está disponible.
     * @return true si el libro está disponible, false en caso contrario.
     */
    public boolean estaDisponible() {
        return disponible;
    }

    /**
     * Marca el libro como prestado.
     */
    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println("El libro '" + titulo + "' ha sido prestado.");
        } else {
            System.out.println("El libro '" + titulo + "' no está disponible para préstamo.");
        }
    }

    /**
     * Marca el libro como devuelto.
     */
    public void devolver() {
        disponible = true;
        System.out.println("El libro '" + titulo + "' ha sido devuelto.");
    }

    /**
     * Cambia la disponibilidad del libro.
     * @param disponibilidad true para disponible, false para no disponible.
     */
    public void cambiarDisponibilidad(boolean disponibilidad) {
        this.disponible = disponibilidad;
        String estado = disponibilidad ? "disponible" : "no disponible";
        System.out.println("El libro '" + titulo + "' ahora está " + estado + ".");
    }
}
