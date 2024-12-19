package bibliotecainterface;

import Materiales.MaterialBiblioteca;

public interface Prestamo {
    
    public void realizarPrestamo(MaterialBiblioteca material, Usuario usuario);
    public void devolverMaterial(MaterialBiblioteca material, Usuario usuario);
}
