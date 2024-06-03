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
public class Usuario {//Declaro los atributos como privados
          private static String nombre_Usuario;
        private String rol;
        private List<Libro> listaLibrosPrestados; //Creo una lista de libros prestados que añadiré dentro de cada usuario.
    
    /*Creo el constructor público para la clase Usuario y le paso los argumentos (atributos) 
    privados que he declarado anteriormente (ahora serán accesibles con el constructor)*/
        public Usuario(String nombre_Usuario, String rol){
            this.nombre_Usuario = nombre_Usuario;
            this.rol = rol;
            this.listaLibrosPrestados = new ArrayList<>(); //Inicializo la lista que se me creará cada vez que cree un usuario.
            UsuarioDAO.insertUsuario(nombre_Usuario, rol);
           
        }
    
    //Creo métodos para coger el valor de los diferentes argumentos.
        public static String getNombreUsuario(){ //Método para coger el nombre.
            return nombre_Usuario;
        }
        
        public List<Libro> getListaLibrosPrestados(){ //Método para coger la lista de libros prestados (de cada usuario).
            return listaLibrosPrestados;
        }
        
    //Creo métodos para cambiar los argumentos.
        public void setNombreUsuario(String nombreUsuarioNuevo){ //Método para llamar y cambiar el nombre.
            this.nombre_Usuario = nombreUsuarioNuevo;
        }
        
          public static List<String> getAllUsersName(){
            return  UsuarioDAO.getAllUsersName();
        }
        
          
        public static boolean isUserInList(String nombre){
            List<String> userName = Usuario.getAllUsersName();
            return userName.contains(nombre); // si contiene el nombre TRUE si no lo tiene FALSE      
        }
        
        
        
            public static void printUsuarioDetails(){
            UsuarioDAO.printUsuarioDetails();
           
            }
            
            public static void insertUsuario(String nombre_Usuario, String rol){
                UsuarioDAO.insertUsuario(nombre_Usuario, rol);
            }
        
            
            
           //El usuario coge un libro. SI usuario no existe, da error. Si Libro no existe, también da error.      
               public static void cogerLibroPrestado(String nombre_Usuario, String titulo){            
            if(Usuario.isUserInList(nombre_Usuario)){
                if(Libro.isLibroInLista(titulo)){
                    if (Libro.getDisponibilidad(titulo)){
                        UsuarioDAO.insertUsuarioLibroPrestadoSiExiste(nombre_Usuario, titulo);
                        LibroDAO.cambiarDisponibiliad(titulo, false);
                         System.out.println(nombre_Usuario + " has cogido prestado correctamente el libro " + titulo);
                    }else{ 
                        System.out.println("Lo lamentamos, pero el libro " + titulo + " no está disponible en estos momentos. Inténtalo de nuevo con otro libro.");
                    }
                    
                }else {
                    System.out.println("El libro " + titulo + " no está en nuestra base de datos. Inténtalo de nuevo con otro libro.");
                }
                
                
            }else{
                        System.out.println("El usuario " + nombre_Usuario + " no está en nuestra base de datos. Inténtalo de nuevo.");
                 
        
    } 
       } 
       
               
       public static void devolverLibro(String nombre_Usuario, String titulo) {
    // Verificar si el usuario está en la lista
    if (Usuario.isUserInList(nombre_Usuario)) {
        // Verificar si el libro está en la lista
        if (Libro.isLibroInLista(titulo)) {
            // Verificar si el usuario tiene prestado el libro
            if (UsuarioDAO.usuarioTieneLibroPrestado(nombre_Usuario, titulo)) {
                // Eliminar el libro de la lista de préstamos del usuario
                UsuarioDAO.eliminarUsuarioLibroPrestado(nombre_Usuario, titulo);
                // Cambiar la disponibilidad del libro a true
                LibroDAO.cambiarDisponibiliad(titulo, true);
                System.out.println(nombre_Usuario + " ha devuelto correctamente el libro " + titulo);
            } else {
                System.out.println(nombre_Usuario + " no tiene el libro " + titulo + " prestado.");
            }
        } else {
            System.out.println("El libro " + titulo + " no está en nuestra base de datos. Inténtalo de nuevo con otro libro.");
        }
    } else {
        System.out.println("El usuario " + nombre_Usuario + " no está en nuestra base de datos. Inténtalo de nuevo.");
    }
}
               
               
               public static void borrarUsuario(int id_Usuario){
            UsuarioDAO.deleteUsuario(id_Usuario);
            System.out.println("Te echaremos de menos querido Usuario con ID" + id_Usuario + ". ¡Vuelve pronto!");
            }
               
               
               
               //Escribir lista libros prestados
               
            public List<Libro> imprimirListaLibrosPrestados(){
            
            System.out.println("Lista de libros prestados de " + this.nombre_Usuario + ":");
            
            for(Libro libroP : listaLibrosPrestados){ //Con el FOR recorro la lista de libros prestados, que se encuentra en la clase Usuario (como es la clase donde estamos no le digo en qué clase está)
                System.out.println("    - " + libroP.getTituloLibro()); //Imprimo los libros prestados por el usuario. 
            }
            System.out.println("");
            return listaLibrosPrestados;
        }
        

        /*
       
        public void devolverLibro (String titulo){
            boolean libroExistenteB = false;
            
            for(Libro libroY : listaLibrosPrestados){ //Con el FOR recorro la lista de libros prestados, que se encuentra en la clase Usuario (como es la clase donde estamos no le digo en qué clase está)
                if(libroY.getTituloLibro().equals(titulo)){ //Si el título del libro (clase Libro) coincide con el titulo que le he pasado (a través de la clase Usuario)...
                    
                    libroExistenteB = true; //... le marco el boolean como TRUE;
                    
                        //No hace falta mirar si está disponible o no el libro porque estamos mirando solo la lista de libros prestados.
                        
                        System.out.println(this.nombre_Usuario + ", has devuelto el libro " + libroY.getTituloLibro() + ".\n  Podrás comprobar que ya no se encuentra en el apartado de <<Préstamos>> de tu cuenta."); //Imprimo información para ver en la terminal.
                        
                        listaLibrosPrestados.remove(libroY); //elimino el libro de la lista de libros prestados del Usuario que ha devuelto el libro e...
                        libroY.marcarLibroDevuelto(); //...implemento el método "marcarLibroDevuelto()" de la clase Libro.
                        
                        System.out.println(""); //Imprimo una l?nea en blanco.
                        
                } break; //Paro el bucle FOR (cuando se encuentra un libro de la lista de libros genérica y ha implementado el resto de métodos, ya no busca más).
            }           
            if (libroExistenteB == false){ //Una vez recorrida la lista de libros prestados, si el título del libro (clase Libro) no coincide con el título que le he pasado, le marco FALSE.
                System.out.println("No hemos encontrado el libro " + titulo + " entre los libros que tienes prestados actualmente."); //Imprimimos que no hemos encontrado el libro con el titulo que le ha pasado el usuario.
            }
            UsuarioDAO.devolverLibroPrestado(0, titulo);
            UsuarioDAO.cambiarDisponibiliad(titulo, libroExistenteB);
        }
        */
        
       
        
      
    } 
       
        


        



