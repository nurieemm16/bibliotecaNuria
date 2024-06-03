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
public class AutorDAO {
     //Método para OBTENER Y MOSTRAR los detalles de todos los autores.
    public static void printAutorDetails(){
        String query = "SELECT * FROM Autor";
        try(Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
            
            while(rs.next()){
                int id_Autor = rs.getInt("id_Autor");
                String nombre_Autor = rs.getString("nombre_Autor");
                int anoNacimiento = rs.getInt("anoNacimiento");
                int anoMuerte = rs.getInt("anoMuerte");
                if (anoMuerte != 0) { 
                    System.out.println("  - Autor con ID " + id_Autor + " | " + nombre_Autor + " (" + anoNacimiento + "-" + anoMuerte + ")");
                }
                if(anoMuerte == 0){
                    System.out.println("  - Autor con ID " + id_Autor + " | " + nombre_Autor + " (" + anoNacimiento + "-)");
                }
            }
            
        }catch(SQLException e){
            System.out.println("Error con imprimir los datos de los autores.");
            e.printStackTrace(); //Ens tornaria el trazo del error, ens diu quin error hi ha al SQL.
        }
    }
    
    //Método para OBTENER Y MOSTRAR los detalles de UN autor.
    public static void printOneAutorDetails(int id_Autor){
        String query = "SELECT * FROM Autor WHERE id_Autor = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setInt(1, id_Autor);// El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                //int id_Autor = rs.getInt("id_Autor");
                String nombre_Autor = rs.getString("nombre_Autor");
                int anoNacimiento = rs.getInt("anoNacimiento");
                int anoMuerte = rs.getInt("anoMuerte");
                if (anoMuerte != 0) { 
                    System.out.println("(" + id_Autor + ") " + nombre_Autor + " (" + anoNacimiento + "-" + anoMuerte + "):");
                }
                if(anoMuerte == 0){
                    System.out.println("(" + id_Autor + ") " + nombre_Autor + " (" + anoNacimiento + "-):");
                }
            }
            
        }catch(SQLException e){
            System.out.println("Error con imprimir los datos de un autor.");
            e.printStackTrace(); //Ens tornaria el trazo del error, ens diu quin error hi ha al SQL.
        }
    }
    
    //Método para OBTENER Y MOSTRAR los detalles de los libros según autor.
    public static void printAutorLibroDetails(int id_Autor){
        String query = "SELECT l.id_Libro, l.titulo, l.disponibilidad FROM Libro l INNER JOIN Autor a ON l.autor = a.nombre_Autor WHERE a.id_Autor = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setInt(1, id_Autor);// El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                int id_Libro = rs.getInt("l.id_Libro");
                String titulo = rs.getString("l.titulo");
                boolean disponibilidad = rs.getBoolean("disponibilidad");
                
                System.out.println("    - Libro " + id_Libro + ": " + titulo + " | Disponibilidad: " + disponibilidad);
            }
            
        }catch(SQLException e){
            System.out.println("Error con imprimir los datos del autor con sus libros publicados.");
            e.printStackTrace(); //Ens tornaria el trazo del error, ens diu quin error hi ha al SQL.
        }
    }
    
    
      public static void insertAutor(String nombre_Autor, int anoNacimiento, int anoMuerte){
        String query = "INSERT INTO Autor (nombre_Autor, anoNacimiento, anoMuerte) VALUES (?, ?, ?);";
        try(Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setString(1, nombre_Autor); // El número es la posició de l'atribut, el nom es el mateix que hem posat als parèntesis de dalt.
                pstmt.setInt(2, anoNacimiento);
                pstmt.setInt(3, anoMuerte);
                pstmt.executeUpdate();
                
                System.out.println("¡Próximamente tendremos un nuevo autor con sus magníficos libros en nuestra biblioteca! ¿Conoces a " + nombre_Autor + "?");
                
        }catch(SQLException e){
            System.out.println("Error con insertar un nuevo autor.");
            e.printStackTrace();
        }
    }
    
    
    
    
    
     public static void deleteAutor(int id, String name) { 
    String query = "DELETE FROM Autor WHERE id_Autor = ? AND nombre_Autor= ?;";
    try (Connection conn = DatabaseConnection.getConnection(); 
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.executeUpdate();
        
        
    } catch (SQLException e) {
        System.out.println("Error con eliminar el autor.");
        e.printStackTrace();
    }
}
}
