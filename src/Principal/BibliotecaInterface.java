package Principal;

import bibliotecainterface.Biblioteca;
import bibliotecainterface.Bibliotecario;
import Materiales.Revista;
import Materiales.DVD;
import Materiales.Libro;
import Materiales.MaterialBiblioteca;
import bibliotecainterface.Usuario;

public class BibliotecaInterface {

    public static void main(String[] args) {
        
        Biblioteca biblioteca = new Biblioteca();
        
        // Materiales
        MaterialBiblioteca material1 = new Libro("Gabriel Garcia Marquez", 00024, "Cronica de una muerte anunciada");
        MaterialBiblioteca material2 = new Libro("Julio Cortazar", 00017, "Rayuela");
        MaterialBiblioteca material3 = new Libro("Milan Kundera", 00035, "La vida esta en otra parte");
                
        MaterialBiblioteca material4 = new Revista(7, 1964, 00154, "Panorama");
        MaterialBiblioteca material5 = new Revista(2, 1999, 00154, "Para ti");
                
        MaterialBiblioteca material6 = new DVD(240, 00254, "Encarta multimedia");
        MaterialBiblioteca material7 = new DVD(190, 00275, "Historia de la Argentina");
        MaterialBiblioteca material8 = new DVD(215, 00210, "Making a Murderer");
        
        biblioteca.agregarMaterial(material1);
        biblioteca.agregarMaterial(material2);
        biblioteca.agregarMaterial(material3);
        biblioteca.agregarMaterial(material4);
        biblioteca.agregarMaterial(material5);
        biblioteca.agregarMaterial(material6);
        biblioteca.agregarMaterial(material7);
        biblioteca.agregarMaterial(material8);
                
        // Usuarios
        Usuario usuario1 = new Usuario("Jorge Lopez", 10064521, 30);
        Usuario usuario2 = new Usuario("Ana Laura Rodriguez", 10064545, 16);
        Usuario usuario3 = new Usuario("Lucia Perez", 10063695, 25);
        Usuario usuario4 = new Usuario("Pedro Blanco", 10061925, 23);
        
        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);
        biblioteca.registrarUsuario(usuario3);
        biblioteca.registrarUsuario(usuario4);
        
        // Bibliotecarios
        Bibliotecario biblioterio1 = new Bibliotecario("Ines Marquez", 0154);
        Bibliotecario biblioterio2 = new Bibliotecario("Juan Palotes", 1059);
        Bibliotecario biblioterio3 = new Bibliotecario("Maria De los Angeles", 1030);
        
        biblioteca.registrarBibliotecario(biblioterio1);
        biblioteca.registrarBibliotecario(biblioterio2);
        biblioteca.registrarBibliotecario(biblioterio3);
        
        
        // Muestra los materiales disponibles
        System.out.println("\n----------------------------");
        System.out.println("-- Materiales disponibles --");
        System.out.println("----------------------------\n");
        biblioteca.mostrarMaterialesDisponibles();
        
        
        // Realización de préstamos
        System.out.println("\n-------------------------");
        System.out.println("------- PRESTAMOS -------");
        System.out.println("-------------------------\n");
        biblioteca.realizarPrestamo(material2, usuario3);
        biblioteca.realizarPrestamo(material8, usuario2);
        biblioteca.realizarPrestamo(material5, usuario1);
        biblioteca.realizarPrestamo(material7, usuario4);
        biblioteca.realizarPrestamo(material5, usuario2);
        
        
        // Muestra los materiales disponibles
        System.out.println("\n----------------------------");
        System.out.println("-- Materiales disponibles --");
        System.out.println("----------------------------\n");
        biblioteca.mostrarMaterialesDisponibles();
                
        
        // Realización de devoluciones
        System.out.println("\n--------------------------");
        System.out.println("------- DEVOLUCIONES -----");
        System.out.println("--------------------------\n");
        biblioteca.devolverMaterial(material5, usuario1);
        biblioteca.devolverMaterial(material2, usuario3);        
        
        // Muestra los materiales disponibles
        System.out.println("\n----------------------------");
        System.out.println("-- Materiales disponibles --");
        System.out.println("----------------------------\n");
        biblioteca.mostrarMaterialesDisponibles();
        
    }
        
}
