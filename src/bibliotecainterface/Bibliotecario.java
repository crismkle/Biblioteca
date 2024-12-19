package bibliotecainterface;

import Materiales.DVD;
import Materiales.MaterialBiblioteca;

public class Bibliotecario implements Prestamo {
    private final String nombre;
    private final long idBibliotecario;

    public Bibliotecario(String nombre, long idBibliotecario) {
        this.nombre = nombre;
        this.idBibliotecario = idBibliotecario;
    }

    public String getNombre() {
        return nombre;
    }

    public long getIdBibliotecario() {
        return idBibliotecario;
    }

    /* verifica que el material esté disponible y realiza el
            préstamo si cumple con las restricciones. */
    @Override
    public void realizarPrestamo(MaterialBiblioteca material, Usuario usuario) {
        
        if (material.restriccion(usuario))
            usuario.realizarPrestamo(material);
        else
            if (material instanceof DVD){
                System.out.println("Prestamo fallido. Los DVD solo se pueden prestar a mayores de edad");
                System.out.println("Edad: " + usuario.verificarEdad());
            }else
                System.out.println("El usuario no ha superado la restriccion");
                
    }

    @Override
    public void devolverMaterial(MaterialBiblioteca material, Usuario usuario) {
        /* permite devolver el material y marca el material como
            disponible */
        usuario.devolverMaterial(material);
    }
    
}
