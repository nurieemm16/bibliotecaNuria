/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecanuria;
import java.util.*;

/**
 *
 * @author nuria
 */

public class MiembroPremium extends Usuario {
    //Declaro los atributos como privados
        private List<Libro> listaLibrosReservados; //Creo una lista de libros reservados que a�adir� dentro de cada miembro premium.
    
    /*Creo el constructor p�blico para la clase Usuario y le paso los argumentos (atributos) 
    privados que he declarado anteriormente (ahora ser�n accesibles con el constructor)*/
        public MiembroPremium(String nombre_MP, String rol){
            super(nombre_MP, rol);
            this.listaLibrosReservados = new ArrayList<>(); //Inicializo la lista que se me crear� cada vez que cree un miembro premium.
            MiembroPremiumDAO.insertMP(nombre_MP, rol);
        }
        
    //Creo m�todos para coger el valor de los diferentes argumentos.     
        public List<Libro> getListaLibrosReservados(){ //M�todo para coger la lista de libros reservados (de cada miembro premium).
            return listaLibrosReservados;
        }
        
        public String getNombreMiembroPremium(){ //M�todo para coger el nombre de la clase padre (Usuario)
            return super.getNombreUsuario();
        }
    
   
        
        public List<Libro> imprimirListaLibrosReservados(){
            
            System.out.println("Lista de libros reservados de " + this.getNombreMiembroPremium() + ":");

            for(Libro libroP : listaLibrosReservados){ //Con el FOR recorro la lista de libros reservados, que se encuentra en la clase MiembroPremium (como es la clase donde estamos no le digo en qu� clase est�)
                System.out.println("    - " + libroP.getTituloLibro()); //Imprimo los libros reservados por el usuario.
            }
            System.out.println("");
            return listaLibrosReservados;
        }
        
        
                      
      
        
       
        public static boolean isMPInList(String nombre){
            List<String> userName = MiembroPremium.getAllMPName();
            return userName.contains(nombre); // si contiene el nombre TRUE si no lo tiene FALSE      
        }
        
        
                   public static void printMPDetails(){
            MiembroPremiumDAO.printMPDetails();
        }
           
           
            public static void insertMP(String nombre_MP, String rol){
                 MiembroPremiumDAO.insertMP(nombre_MP, rol);
        }
        
        
        
        public static void cogerLibroPrestadoYsinoReservado(String nombre_MP, String titulo){            
            if(MiembroPremium.isMPInList(nombre_MP)){
                if(Libro.isLibroInLista(titulo)){
                    if (Libro.getDisponibilidad(titulo)){
                        MiembroPremiumDAO.insertMpLibroPrestadoSiExiste(nombre_MP, titulo);
                        LibroDAO.cambiarDisponibiliad(titulo, false);
                         System.out.println(nombre_MP+ "  has cogido prestado correctamente el libro " + titulo);
                    } else if(Libro.getDisponibilidad(titulo) != true){
                    MiembroPremiumDAO.insertMpLibroReservadosSiExiste(nombre_MP, titulo);
                    System.out.println(nombre_MP + "  has escogido el libro "+ titulo + " pero lamentablemente no está disponible. Al ser miembro Premium te lo hemos reservado!");
                    }
                    else{ 
                        System.out.println(nombre_MP + " lo lamentamos, pero el libro " + titulo + " no está disponible en estos momentos. Inténtalo de nuevo con otro libro.");
                    }
                    
                }else {
                    System.out.println("El libro " + titulo + " no está en nuestra base de datos. Inténtalo de nuevo con otro libro.");
                }
                
                
            }else{
                        System.out.println("El usuario premium con el siguiente nombre: " + nombre_MP + " no está en nuestra base de datos. Inténtalo de nuevo.");
                 
        
    } 
       }
        
        
              public static void devolverLibroMiembroPremium(String nombre_MP, String titulo) {
    // Verificar si el usuario está en la lista
    if (MiembroPremium.isMPInList(nombre_MP)) {
        // Verificar si el libro está en la lista
        if (Libro.isLibroInLista(titulo)) {
            // Verificar si el usuario tiene prestado el libro
            if (MiembroPremiumDAO.MPTieneLibroPrestado(nombre_MP, titulo)) {
                // Eliminar el libro de la lista de préstamos del usuario
                MiembroPremiumDAO.eliminarMPLibroPrestado(nombre_MP, titulo);
                // Cambiar la disponibilidad del libro a true
                LibroDAO.cambiarDisponibiliad(titulo, true);
                System.out.println(nombre_MP + " has devuelto correctamente el libro " + titulo);
            } else {
                System.out.println(nombre_MP + " no tienes el libro " + titulo + " prestado.");
            }
        } else {
            System.out.println("El libro " + titulo + " no está en nuestra base de datos. Inténtalo de nuevo con otro libro.");
        }
    } else {
        System.out.println("El Miembro Premium " + nombre_MP + " no está en nuestra base de datos. Inténtalo de nuevo.");
    }
}
        
        
        public static void devolverLibroPrestadoMP(int id_Libro, String titulo){
            MiembroPremiumDAO.devolverLibroPrestadoMP(id_Libro, titulo);
        }

            
            
          public static void deleteMiembroPremium(int id_MP){
              MiembroPremiumDAO.deleteMiembroPremium(id_MP);
              
          }
            
        
         public static List<String> getAllMPName(){
            return  MiembroPremiumDAO.getAllMPName();
        }
                       
     
        
        
}
