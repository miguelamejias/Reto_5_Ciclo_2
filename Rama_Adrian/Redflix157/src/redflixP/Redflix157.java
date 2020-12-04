package redflixP;

import repositories.Director;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Redflix157 {
    
    private Director director1; 
  
    public Redflix157(){
        this.director1 = new Director();
    }
       
    public String testConnection(){
        try {
            Connection conn = ConnectionJDBC.getConnection();
            if (conn != null) {
                return "Conectado";
            }
            conn.close();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            return "Falla conexion";
        }
        return "Error en la conexion";
    }
    
    
    public static void main(String[] args) {
        Redflix157 redflix157 = new Redflix157();
        System.out.println(redflix157.testConnection());
        
//        Ventana ventana = new Ventana();
        
        System.out.println( redflix157.director1.searchAllDirectors());
//        System.out.println(redflix157.director1.insertDirector(108, "Eduin", "Morales", "Frances"));
        System.out.println( redflix157.director1.searchAllDirectors());
    }
}
