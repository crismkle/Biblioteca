
package Materiales;

import bibliotecainterface.Usuario;

public class DVD extends MaterialBiblioteca{
    private final int duracion;

    public DVD(int duracion, int codigo, String titulo) {
        super(codigo, titulo, true);
        this.duracion = duracion;
    }

    @Override
    public void prestamo() {
        /*
            los DVDs solo se
            pueden prestar a usuarios mayores de 18 años (verificando la edad
            del usuario). Si no está disponible o el usuario no cumple con la
            edad mínima, lanza una excepción
        */
        if (super.isDisponible()){
            super.setDisponible(false);
            System.out.println("Prestamo del DVD exitoso");
        }
        else
            System.out.println("Prestamo fallido. El DVD se encuentra prestado, intente en unos dias");
        
        mostrarInfo();
    }

    @Override
    public void devolucion() {
        super.setDisponible(true);
        System.out.println("Devolucion exitosa");
        mostrarInfo();
    }

    @Override
    public boolean restriccion(Usuario usuario) {
        return usuario.verificarEdad() >= 18;
    }
    
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Duracion: " + duracion + " min\nTipo: DVD\n");
    }
    
    
}
