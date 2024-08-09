/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

/**
 *
 * @author USUARIO 2022
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un usuario de la biblioteca.
 */
public class Usuario {
    private String nombre;
    List<Libro> librosPrestados;

    /**
     * Crea una nueva instancia de Usuario con el nombre dado.
     * @param nombre El nombre del usuario.
     */
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<>();
    }

    /**
     * Devuelve el nombre del usuario.
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Permite al usuario tomar prestado un libro si está disponible.
     * @param libro El libro a prestar.
     */
    public void prestarLibro(Libro libro) {
        if (libro.estaDisponible()) {
            libro.prestar();
            librosPrestados.add(libro);
        } else {
            System.out.println("No se puede prestar el libro '" + libro.getTitulo() + "' porque no está disponible.");
        }
    }

    /**
     * Permite al usuario devolver un libro.
     * @param libro El libro a devolver.
     */
    public void devolverLibro(Libro libro) {
        if (librosPrestados.contains(libro)) {
            libro.devolver();
            librosPrestados.remove(libro);
        } else {
            System.out.println("El libro '" + libro.getTitulo() + "' no está en la lista de libros prestados de este usuario.");
        }
    }

    /**
     * Muestra todos los libros que el usuario tiene prestados actualmente.
     */
    public void listarLibrosPrestados() {
        if (librosPrestados.isEmpty()) {
            System.out.println("No tienes libros prestados.");
        } else {
            System.out.println("Libros prestados por " + nombre + ":");
            for (Libro libro : librosPrestados) {
                System.out.println("- " + libro.getTitulo() + " por " + libro.getAutor());
            }
        }
    }
}
