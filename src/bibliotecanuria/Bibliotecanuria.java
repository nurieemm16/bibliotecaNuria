/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bibliotecanuria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nuria
 */
public class Bibliotecanuria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //OPERACIONES CRUD
        //CREO USUARIO
        //Usuario Usuario9 = new Usuario ("Aïda Salas","usuario");
        //Usuario Usuario10 = new Usuario ("Camila Salas","usuario");
        //Usuario Usuario12 = new Usuario ("Carme Llort","usuario");
       
        
        
         //BORRO USUARIO
        //Usuario.borrarUsuario(16);
        //Usuario.borrarUsuario(15);
        //Usuario.borrarUsuario(14);
        //Usuario.borrarUsuario(11);
    
        
        
        
        //CREO AUTOR
       
         //Autor.insertarAutor("Edgar Allan Poe", 1809, 1849);
        //AutorDAO.insertAutor("Mercè Rodoreda", 1908, 1983);
        //AutorDAO.printAutorDetails();
        
        
        //BORRO AUTOR**
        //AutorDAO.deleteAutor(5, "Carlos Ruiz Zafón");
        //AutorDAO.printAutorDetails();
        //Autor.borrarAutor(1, "dsfs");
    
        //CREO LIBRO
        //Autor.publicarLibro("Circo Máximo", "Santiago Posteguillo");
        //Autor.publicarLibro("Circo Mínimo", "Santiago NoPosteguillo");
        //LibroDAO.insertLibro("Mirall Trencat", "Mercè Rodoreda", true);
        //LibroDAO.printLibroDetails();
       // Libro.insertLibro("La armadura de la luz", "Ken Follett", true);
        
          //BORRO LIBRO
        
        //LibroDAO.deleteLibro(10, "La plaça del diamant");
        //LibroDAO.printLibroDetails();
        //Libro.deleteLibro(17, "El laberinto de los espiritus");
    
        //CREO MIEMBRO PREMIUM
        //MiembroPremium.insertMP("Aitana Bonit", "MiembroPremium");
        
        //MiembroPremiumDAO.insertMP("Jana Llorent", "miembro premium");
        //MiembroPremiumDAO.printMPDetails();
         //MiembroPremium  MiembroPremium11 = new MiembroPremium("Roger Marí", "MiembroPremium");
         //MiembroPremium  miembroPremium12 = new MiembroPremium("Marina Rogina", "miembro premium");
   
        
        //BORRO MIEMBRO PREMIUM
        //MiembroPremium.deleteMiembroPremium(12);
        //MiembroPremiumDAO.deleteMiembroPremium(4);
        //MiembroPremiumDAO.printMPDetails();
        
        
        
         System.out.println("AUTORES Y LIBROS:");
        
          
        //Autor ID 2 - Libros
       
                 //Lista de libros publicados por el autor ID 2
                //Detalles del autor ID 2
                    Autor.printOneAutorDetails(2);
                           
                //Libros publicados por el autor ID 2 (Se imprime en la consola)
                    Autor.imprimirListaLibrosAutor(2);       
                
        System.out.println("");
        
        //Autor ID 3 - Libros
          
             //Lista de libros publicados por el autor ID 3
                //Detalles del autor ID 3
                     Autor.printOneAutorDetails(3);
                           
                //Libros publicados por el autor ID 3 (Se imprime en la consola)
                    Autor.imprimirListaLibrosAutor(3);        
                
        System.out.println("");
        
        //Autor ID 4 - Libros
            
            
            //Lista de libros publicados por el autor ID 4
                //Detalles del autor ID 4
                   Autor.printOneAutorDetails(4);
                           
                //Libros publicados por el autor ID 4 (Se imprime en la consola)
                   Autor.imprimirListaLibrosAutor(4);   
                    
        //Autor ID 5 - Libros
            
            //Lista de libros publicados por el autor ID 5
                //Detalles del autor ID 5
                     Autor.printOneAutorDetails(5);
                           
                //Libros publicados por el autor ID 5 (Se imprime en la consola)
                   Autor.imprimirListaLibrosAutor(5); 
                   
                   
                   
           //Autor ID 6 - Libros
            
            //Lista de libros publicados por el autor ID 6
                //Detalles del autor ID 6
                     Autor.printOneAutorDetails(6);
                           
                //Libros publicados por el autor ID 6 (Se imprime en la consola)
                   Autor.imprimirListaLibrosAutor(6); 
        
                    
                    System.out.println("----------");
        
        System.out.println("Lista de autores:");
        Autor.printAutorDetails();
        
        System.out.println("Lista de libros:");
        Libro.imprimirListaLibrosGenerica();
        
        System.out.println("-----------------------------------------------------------------------------------");     
                 
  
        System.out.println("Nuevos usuarios:");
        //Creo nuevos Usuarios
          //Usuario.insertUsuario("Natàlia Espill", "Usuario");
            System.out.println("");
        System.out.println("Nuevos miembros premium:");
        //Creo nuevos Miembros Premium
            //MiembroPremium.insertMP("Désirée Pitch", "MiembroPremium");
            
            
        System.out.println("----------");
        System.out.println("Lista de Usuarios:");
        Usuario.printUsuarioDetails();

        System.out.println("Lista de Miembros Premium:");
        MiembroPremium.printMPDetails();
        
        System.out.println("-----------------------------------------------------------------------------------");     
        
        //PRESTAMOS: 
        
      
        
        System.out.println("PRÉSTAMOS USUARIOS Y MIEMBROS PREMIUM:");
        
        
        // USUARIO NORMAL:
        //Un usuario NORMAL toma prestado algún libro
        
        //Usuario.cogerLibroPrestado("Marc Guasch", "Mirall Trencat");
      
           // USUARIO PREMIUM:
     
        //Un usuario que no es miembro premium  toma prestado algún libro (que está disponible)- ha de decir que no porque Núria Marzo es usuario normal y no premium
        //MiembroPremium.cogerLibroPrestadoYsinoReservado("Núria Marzo", "Roma soy yo");
        
        //Un  miembro premium  toma prestado algún libro (que está disponible)
        //MiembroPremium.cogerLibroPrestadoYsinoReservado("Toni Usón", "Circo Máximo");
        
        //Mismo miembro premium anterior toma prestado otro libro (que está disponible)
        //MiembroPremium.cogerLibroPrestadoYsinoReservado("Toni Usón", "Los Pilares de la tierra");
        
        //Un miembro premium  toma prestado algún libro (que NO está disponible, y entonces queda como reservado)
        //MiembroPremium.cogerLibroPrestadoYsinoReservado("Àlex Ramos", "Mirall Trencat");
        
       
        
            
         //DEVOLUCIONES:    
      System.out.println("DEVOLUCIONES:");
      
      //Usuario.devolverLibro("Núria Marzo", "Roma soy yo");
      //MiembroPremium.devolverLibroMiembroPremium("Toni Usón", "Los Pilares de la tierra");
      
      
     // Usuario.devolverLibro(nombre_Usuario, titulo);
        //Un usuario devuelve algún libro
                //UsuarioDAO.devolverLibroPrestado(3, "El aliento de los Dioses");
                //UsuarioDAO.cambiarDisponibiliad("El aliento de los Dioses", true);
            //UsuarioDAO.devolverLibroPrestado(4, "Elantris");
            //UsuarioDAO.cambiarDisponibiliad("Elantris", true);
            //UsuarioDAO.devolverLibroPrestado(6, "Marina");
            //UsuarioDAO.cambiarDisponibiliad("Marina", true);
            //UsuarioDAO.devolverLibroPrestado(7, "Los Pilares de la tierra");
             //UsuarioDAO.cambiarDisponibiliad("Los Pilares de la tierra", true);
            //UsuarioDAO.devolverLibroPrestado(8, "La Caída de los Gigantes");
            //UsuarioDAO.cambiarDisponibiliad("La Caída de los Gigantes", true);
            //MiembroPremiumDAO.devolverLibroPrestadoMP(12, "Mirall Trencat");
            //MiembroPremiumDAO.cambiarDisponibiliad("Mirall Trencat", true);
           //UsuarioDAO.devolverLibroPrestado(3, "El aliento de los Dioses");
            //LibroDAO.librosDevueltos(3, true);
                //UsuarioDAO.devolverLibroPrestado(4, "Elantris");
       //UsuarioDAO.cambiarDisponibiliad("Elantris", true);
            
        //Lista genérica de libros que se han prestado (no incluye los libros devueltos)
            //System.out.println("Lista de libros prestados ACTUALIZADA:");
            //LibroDAO.printLibrosPrestados();
            
            
    
            
        
        System.out.println("-----------------------------------------------------------------------------------");
        
        
        
        
      /*
                
      
     
    //Aquí nos comprueba si un usuario está en nuestra base de datos usuarios normales, no premium
    System.out.println("Lista completa Usuarios");
     List<String> nombresUsuario = Usuario.getAllUsersName();
     
     String nombre = "Maya Moliner";
     if(Usuario.isUserInList(nombre)){
         System.out.println(nombre + " se encuentra en la lista de usuarios");
     }else{
         System.out.println("Lo lamentamos pero "+ nombre + " no se encuentra en la lista de usuarios");
     }
    
     
     //Aquí nos comprueba si un libro está en nuestra base de datos
     System.out.println("Lista completa Libros");
    
     List<String> nombresLibros = Libro.getAllLibrosName(); //de getAllLibrosName() irá a LibroDAO, hará su funcion y me lo devolverá
              System.out.println("Lista Libros");
  
       String titulo = "Roma soy yo";
     
     if(Libro.isLibroInLista(titulo)){
         System.out.println("Te informamos que el libro " + titulo + " se encuentra en nuestra biblioteca");
     }else{
         System.out.println("Lo lamentamos pero actualmente no tenemos el libro "+ titulo);*/
     
      
      
   
   
     }
    
    
     
    
   
  
 }
   
 
    
     
      
    


    
       
    
   



