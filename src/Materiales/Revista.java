package Materiales;

import bibliotecainterface.Usuario;
import java.time.LocalDate;

public class Revista extends MaterialBiblioteca{
    private final int mes;
    private final int anio;
    private LocalDate fechaPrestamo;
    private final int diasLimite = 7;

    public Revista(int mes, int anio, int codigo, String titulo) {
        super(codigo, titulo, true);
        this.mes = mes;
        this.anio = anio;
        this.fechaPrestamo = null;
    }
    
    public boolean estaAtrasado(){
        return LocalDate.now().isAfter(fechaPrestamo.plusDays(diasLimite));
    }

    @Override
    public void prestamo() {
        /* Las revistas solo se pueden prestar
        por un máximo de 7 días. Si no está disponible,
        lanza una excepción */           
        if (super.isDisponible()){            
            System.out.println("Prestamo de revista exitoso\nPor favor, devuelva la revista antes del " + LocalDate.now().plusDays(7)); 
            super.setDisponible(false);
            this.fechaPrestamo = LocalDate.now();
        }else
            System.out.println("Prestamo fallido. La revista se encuentra prestada, intente en unos dias");
        
        mostrarInfo();
    }

    
    @Override
    public void devolucion() {
        if (estaAtrasado()){
            long cant = LocalDate.now().toEpochDay() - fechaPrestamo.plusDays(diasLimite).toEpochDay();
            System.out.println("Ha devuelto la revista " + cant + " dias tarde, se le cobrara una penalizacion.");
        }else
            System.out.println("Devolucion dentro de los dias requeridos");
        
        mostrarInfo();
        super.setDisponible(true);
        fechaPrestamo = null;
    }

    @Override
    public boolean restriccion(Usuario usuario) {
        return true;
    }
    
    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Mes: " + mes + "\nAnio: " + anio + "\nTipo: Revista\n");
    }
    
    
}
