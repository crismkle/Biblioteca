package Materiales;

import bibliotecainterface.Usuario;

public class Libro extends MaterialBiblioteca{
    private final String autor;

    public Libro(String autor, int codigo, String titulo) {
        super(codigo, titulo, true);
        this.autor = autor;
    }

    @Override
    public void prestamo() {
        if (super.isDisponible()){
            super.setDisponible(false);
            System.out.println("Prestamo de libro exitoso");            
        }
        else
            System.out.println("Prestamo fallido. El libro se encuentra prestado, intente en unos dias");
        
        mostrarInfo();
    }

    @Override
    public void devolucion() {
        super.setDisponible(true);
        System.out.println("Devolucion exitosa");
        mostrarInfo();
    }

    public String getAutor() {
        return autor;
    } 

    @Override
    public boolean restriccion(Usuario usuario) {
        return true;
    }
    
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Autor: " + autor + "\nTipo: Libro\n");
    }
    
    
}
