/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca;

/**
 *
 * @author USUARIO 2022
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal para gestionar la biblioteca a través de la consola.
 */
public class Biblioteca {
    private static List<Libro> libros = new ArrayList<>();
    private static Usuario usuario;

    public static void main(String[] args) {
        // Inicializar la biblioteca con algunos libros
        libros.add(new Libro("Momo", "Michael Ende"));
        libros.add(new Libro("Siddhartha", "Hermann Hesse"));
        libros.add(new Libro("Pájaro Azul", "Maurice Maeterlinck"));
        libros.add(new Libro("El Aleph", "Jorge Luis Borges"));
        libros.add(new Libro("La Caverna", "José Saramago"));
        libros.add(new Libro("Cuentos de la selva", "Horacio Quiroga"));
        libros.add(new Libro("El Viejo y el Mar", "Ernest Hemingway"));
        libros.add(new Libro("El Lobo Estepario", "Hermann Hesse"));
        libros.add(new Libro("El Principito", "Antoine de Saint-Exupéry"));
        libros.add(new Libro("La Metamorfosis", "Franz Kafka"));

        
        
          

        // Crear un usuario
        usuario = new Usuario("Daniela");

        // Mostrar menú y manejar entrada del usuario
        Scanner scanner = new Scanner(System.in);
        String comando;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Listar libros");
            System.out.println("2. Cambiar disponibilidad de un libro");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Listar libros prestados");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            comando = scanner.nextLine();

            switch (comando) {
                case "1":
                    listarLibros();
                    break;
                case "2":
                    cambiarDisponibilidadLibro(scanner);
                    break;
                case "3":
                    prestarLibro(scanner);
                    break;
                case "4":
                    devolverLibro(scanner);
                    break;
                case "5":
                    usuario.listarLibrosPrestados();
                    break;
                case "6":
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    private static void listarLibros() {
        System.out.println("Libros en la biblioteca:");
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            String estado = libro.estaDisponible() ? "Disponible" : "No disponible";
            System.out.println((i + 1) + ". " + libro.getTitulo() + " por " + libro.getAutor() + " (" + estado + ")");
        }
    }

    private static void cambiarDisponibilidadLibro(Scanner scanner) {
        listarLibros();
        System.out.print("Ingrese el numero del libro para cambiar la disponibilidad: ");
        int numero = Integer.parseInt(scanner.nextLine()) - 1;

        if (numero >= 0 && numero < libros.size()) {
            Libro libro = libros.get(numero);
            System.out.print("Ingrese  disponible o no disponible: ");
            boolean disponibilidad = Boolean.parseBoolean(scanner.nextLine());
            libro.cambiarDisponibilidad(disponibilidad);
        } else {
            System.out.println("Numero de libro no valido.");
        }
    }

    private static void prestarLibro(Scanner scanner) {
        listarLibros();
        System.out.print("Ingrese el numero del libro que desea prestar: ");
        int numero = Integer.parseInt(scanner.nextLine()) - 1;

        if (numero >= 0 && numero < libros.size()) {
            Libro libro = libros.get(numero);
            usuario.prestarLibro(libro);
        } else {
            System.out.println("Numero de libro no valido.");
        }
    }

    private static void devolverLibro(Scanner scanner) {
        usuario.listarLibrosPrestados();
        System.out.print("Ingrese el numero del libro que desea devolver: ");
        int numero = Integer.parseInt(scanner.nextLine()) - 1;

        if (numero >= 0 && numero < usuario.librosPrestados.size()) {
            Libro libro = usuario.librosPrestados.get(numero);
            usuario.devolverLibro(libro);
        } else {
            System.out.println("Numero de libro no valido.");
        }
    }
}
