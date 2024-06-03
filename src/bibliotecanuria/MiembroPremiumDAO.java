/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecanuria;
import java.sql.*;
import java.util.*;

/**
 *
 * @author nuria
 */
public class MiembroPremiumDAO {
      //Método para OBTENER Y MOSTRAR los detalles de todos los miembrosPremium.
    public static void printMPDetails(){
        String query = "SELECT * FROM MiembroPremium";
        try(Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
            
            while(rs.next()){
                int id_MP = rs.getInt("id_MP");
                String nombre_MP = rs.getString("nombre_MP");
                String rol = rs.getString("rol");
            
                System.out.println("  - " + rol + " con ID " + id_MP + " | Nombre: " + nombre_MP);
            }
                      
        }catch(SQLException e){
            System.out.println("Error con imprimir detalles de Miembro Premium.");
            e.printStackTrace(); //Ens tornaria el trazo del error, ens diu quin error hi ha al SQL.
        }
    }
    
    //Método para INSERTAR los detalles de todos los MIEMBROS PREMIUM.
    public static void insertMP(String nombre_MP, String rol){
        String query = "INSERT INTO MiembroPremium (nombre_MP, rol) VALUES (?, ?);";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setString(1, nombre_MP); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                pstmt.setString(2, rol);
                pstmt.executeUpdate();
                
                System.out.println("¡Tenemos un nuevo " + rol + " en nuestra biblioteca! Te damos la bienvenida " + nombre_MP + ".");
                
        }catch(SQLException e){
            System.out.println("Error con la inserción de un nuevo Miembro Premium.");
            e.printStackTrace();
        }
    }
    
    
      public static void insertMPLibroPrestado(int id_MP, String nombre_MP, int id_Libro, String titulo){
        String query = "INSERT INTO MP_LibrosPrestados (id_MP, nombre_MP, id_Libro, titulo) VALUES (?, ?, ?, ?);";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setInt(1, id_MP); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                pstmt.setString(2, nombre_MP);
                pstmt.setInt(3, id_Libro);
                pstmt.setString(4, titulo);
                pstmt.executeUpdate();
                
                System.out.println("   - " + nombre_MP + ", has cogido prestado el libro " + titulo); //imprimo información para ver en la terminal y...
                        
        }catch(SQLException e){
            System.out.println("Error con insertar un libro en la lista de Libros prestados por Miembros premium.");
            e.printStackTrace();
        }
    }
      
      public static void insertMpLibroPrestadoSiExiste(String nombre_MP, String titulo){
        String query = "INSERT INTO MP_LibrosPrestados (id_MP, nombre_MP, id_Libro, titulo)  SELECT mp.id_MP, mp.nombre_MP, l.id_Libro, l.titulo FROM MiembroPremium mp, Libro l WHERE mp.nombre_MP = ? and l.titulo = ?;";
    
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
                
            pstmt.setString(1, nombre_MP); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
            pstmt.setString(2, titulo); 
            pstmt.executeUpdate();    
                
        }catch(SQLException e){
            
            e.printStackTrace();
        }
    }
      
      public static void insertMpLibroReservadosSiExiste(String nombre_MP, String titulo){
        String query = "INSERT INTO MP_LibrosReservados (id_MP, nombre_MP, id_Libro, titulo)  SELECT mp.id_MP, mp.nombre_MP, l.id_Libro, l.titulo FROM MiembroPremium mp, Libro l WHERE mp.nombre_MP = ? and l.titulo = ?;";
    
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
                
            pstmt.setString(1, nombre_MP); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
            pstmt.setString(2, titulo); 
            pstmt.executeUpdate();    
                
        }catch(SQLException e){
            
            e.printStackTrace();
        }
    }
      
      
     
       public static boolean MPTieneLibroPrestado(String nombre_MP, String titulo) {
        String query = "SELECT * FROM MP_LibrosPrestados WHERE nombre_MP = ? AND titulo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nombre_MP);
            pstmt.setString(2, titulo);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Retorna true si el libro está prestado al usuario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    
    public static void eliminarMPLibroPrestado(String nombre_MP, String titulo) {
        String query = "DELETE FROM MP_LibrosPrestados WHERE nombre_MP = ? AND titulo = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nombre_MP);
            pstmt.setString(2, titulo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      
      
        public static void devolverLibroPrestadoMP(int id_Libro, String titulo){
        String query = "DELETE FROM MP_LibrosPrestados WHERE id_Libro = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setInt(1, id_Libro); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                //pstmt.setString(2, titulo);
                pstmt.executeUpdate();
                
                System.out.println("   - Se ha devuelto " + titulo + " correctamente Miembro Premium."); //imprimo información para ver en la terminal y...
                        
        }catch(SQLException e){
            System.out.println("No se ha devuelto correctamente el libro prestado.");
            e.printStackTrace();
        }
    }
    
      
       public static void cambiarDisponibiliad(String titulo, boolean dispo){
        String query = "UPDATE libro SET disponibilidad = ? WHERE titulo = ?; ";
        
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
            
            pstmt.setBoolean(1, dispo);
            pstmt.setString(2, titulo);
            pstmt.executeUpdate();
            
            System.out.println("La disponibilidad del libro " + titulo + " es la siguiente: " + dispo);
              
        }catch(SQLException e){
            System.out.println("No se ha podido cambiar la disponibilidad.");
            e.printStackTrace();
        }  
        
       
    }
    
    
      public static void deleteMiembroPremium(int id_MP){
        String query = "DELETE FROM MiembroPremium WHERE id_MP = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setInt(1, id_MP); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                pstmt.executeUpdate();
                System.out.println("Te echaremos de menos querido Miembro Premium con ID" + id_MP + ". ¡Vuelve pronto!");
        }catch(SQLException e){
            System.out.println("No se ha podido eliminar correctamente el Miembro Premium.");
            e.printStackTrace();
        }
    }
      
 public static List<String> getAllMPName(){
        List<String> usersName = new ArrayList<>();
        
        String query = "SELECT nombre_MP from MiembroPremium;";
        try(Connection conn = DatabaseConnection.getConnection();
              Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
            
            while(rs.next()){
                usersName.add(rs.getString("nombre_MP"));
            }
                
         }catch(SQLException e){
            
            e.printStackTrace();
        }
        return usersName;
    }
    
      
        
    

    public static void reservarLibro(int id_MP, String nombre_MP, int id_Libro, String titulo){
        String query = "INSERT INTO MP_LibrosReservados (id_MP, nombre_MP, id_Libro, titulo) VALUES (?, ?, ?, ?) WHERE disponibilidad (0);";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setInt(1,id_MP); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                pstmt.setString(2, nombre_MP);
                pstmt.setInt(3, id_Libro);
                pstmt.setString(4, titulo);
               
                pstmt.executeUpdate();
                
                System.out.println("   - " + nombre_MP + ", has reservado el libro " + titulo); //imprimo información para ver en la terminal y...
                        
        }catch(SQLException e){
            System.out.println("Oh, oh... Error con el insertUsuario.");
            e.printStackTrace();
        }
    }
    
 

  
}

    

