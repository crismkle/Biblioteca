package bibliotecainterface;

import Materiales.MaterialBiblioteca;

public class Usuario{
    private final String nombre;
    private final long idUsuario;
    private int edad;
    private static int totalUsuarios = 0;

    public Usuario(String nombre, long idUsuario, int edad) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.edad = edad;
        totalUsuarios++;
    }

    /*
        realiza un préstamo si el material está disponible y cumple con las
        restricciones del tipo de material
    */
    public void realizarPrestamo(MaterialBiblioteca material) {
        material.prestamo();
    }

    public void devolverMaterial(MaterialBiblioteca material) {
        material.devolucion();
    }
    
    public int verificarEdad(){
        return edad;
    }
    
    public int getTotalUsuarios(){
        return totalUsuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public long getIdUsuario() {
        return idUsuario;
    }
}
