package Materiales;

import bibliotecainterface.Usuario;

public abstract class MaterialBiblioteca {
    private final long codigo;
    private final String titulo;
    private boolean disponible;
    private static int totalMateriales = 0;

    public MaterialBiblioteca(long codigo, String titulo, boolean disponible) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponible = disponible;
        totalMateriales++;
    }
    
    public abstract void prestamo();
    
    public abstract void devolucion();
    
    public abstract boolean restriccion(Usuario usuario);

    public long getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public static int getTotalMateriales() {
        return totalMateriales;
    }    

    public void mostrarInfo() {
        System.out.println("Titulo: " + titulo + "\nCodigo: " + codigo);
    }
    
}
