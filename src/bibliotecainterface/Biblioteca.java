package bibliotecainterface;

import Materiales.MaterialBiblioteca;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Biblioteca implements Prestamo {
    List<MaterialBiblioteca> materiales;
    List<Usuario> usuarios;
    List<Bibliotecario> bibliotecarios;
    
    public Biblioteca() {
        materiales = new ArrayList<>();
        usuarios = new ArrayList<>();
        bibliotecarios = new ArrayList<>();
    }    
    
    public void agregarMaterial(MaterialBiblioteca material){
        materiales.add(material);        
    }
    
    public void registrarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    
    public void registrarBibliotecario(Bibliotecario bibliotecario){
        bibliotecarios.add(bibliotecario);
    }
    
    public void mostrarMaterialesDisponibles(){
        int cant = 0;
        for(MaterialBiblioteca material : materiales){
            if (material.isDisponible()){
                material.mostrarInfo();
                cant++;
            }
        }
        System.out.println("Cantidad material disponible: " + cant);
        System.out.println("Cantidad total: " + MaterialBiblioteca.getTotalMateriales());
    }

    // permite realizar un préstamo a un usuario
    @Override
    public void realizarPrestamo(MaterialBiblioteca material, Usuario usuario) {   
        Random random = new Random();
        int biblioIndex = random.nextInt(bibliotecarios.size());
        
        Bibliotecario bibliotecario = bibliotecarios.get(biblioIndex);        
        bibliotecario.realizarPrestamo(material, usuario);
        System.out.println("Usuario: " + usuario.getNombre() + "\nBibliotecario: " + bibliotecario.getNombre() + "\n");
        System.out.println("--------------------------\n");
    }

    // permite devolver un material
    @Override
    public void devolverMaterial(MaterialBiblioteca material, Usuario usuario) {  
        Random random = new Random();
        int biblioIndex = random.nextInt(bibliotecarios.size());
        
        Bibliotecario bibliotecario = bibliotecarios.get(biblioIndex);
        bibliotecario.devolverMaterial(material, usuario);
        System.out.println("Usuario: " + usuario.getNombre() + "\nBibliotecario: " + bibliotecario.getNombre() + "\n");
        System.out.println("--------------------------\n");
    }
    
    
}
