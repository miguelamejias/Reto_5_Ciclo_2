package repositories;

import redflixP.ConnectionJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Director {
    
    private Connection conn;
    
    public Director(){
        this.conn = ConnectionJDBC.getConnection();
    }
    
    public String insertDirector(int id, String name, String apellido, String nacionalidad ){
        try {
            String sql = "INSERT INTO director(dir_id, dir_nombre, dir_apellido, dir_nacionalidad)"
                        + " VALUES (?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, apellido);
            statement.setString(4, nacionalidad);
         
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return "Se registró exitosamente el director " + name + " " + apellido;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Insercion fallida!\n";
        }
        return "Error en Insercion\n";
    }
    
    public String searchAllDirectors(){
        try {
            String sql = "SELECT director.dir_id, director.dir_nombre, director.dir_apellido, "
                    + "director.dir_nacionalidad FROM director;";
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            int count = 0;
        
            while (result.next()){
                int dir_id = result.getInt(1);
                String dir_nombre = result.getString(2);
                String dir_apellido = result.getString(3);
                String dir_nacionalidad = result.getString(4);
                
                System.out.println("ID: " + dir_id + "\tNombre: " + dir_nombre + "\tApelido: "+ dir_apellido + 
                                    "\tNacionalidad: "+ dir_nacionalidad);
                count += 1;
            }
            System.out.println("Directores Obtenidos: " + count);
            return "Busqueda exitosa!\n";
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Busqueda fallida!\n";
        }
    }
    
    public String searchPieceByExposition(int exp_id){
        try {
            String sql = "SELECT obra.obr_id, obra.obr_nombre, obra.obr_tipo, obra.obr_costo, exposicion.exp_nombre "
                    + "FROM obra JOIN exposicion WHERE obra.exp_id = exposicion.exp_id AND obra.exp_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, exp_id);
            ResultSet result = statement.executeQuery();
            int count = 0;
        
            while (result.next()){
                int obra_id = result.getInt(1);
                String obra_nombre = result.getString(2);
                String obra_tipo = result.getString(3);
                int obra_costo = result.getInt(4);
                String exposicion_nombre = result.getString(5);
                
                System.out.println("ID: " + obra_id + "\tNombre: " + obra_nombre + "\tTipo: "+ obra_tipo + 
                                    "\tCosto: "+ obra_costo + "\tExposicion: "+ exposicion_nombre);
                count += 1;
            }
            System.out.println("Obras obtenidas: " + count);
            return "Busqueda exitosa!\n";
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Busqueda fallida!\n";
        }
    }
    
 public String updatePiece(int piece_id, int cost){
        try {
            String sql = "UPDATE obra SET obr_costo = ? WHERE obr_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(2, piece_id);
            statement.setInt(1, cost);
            
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                return "Actualizacion exitosa!\n";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Actualizacion fallida!\n";
        }
        return "Error en Actualizacion\n";
    }
 
 public String deletePiece(int piece_id){
        try {
            String sql = "DELETE FROM obra WHERE obr_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, piece_id);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                return "Eliminacion exitosa!\n";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Eliminacion fallida!\n";
        }
        return "Error en Eliminacion\n";
    }
}
