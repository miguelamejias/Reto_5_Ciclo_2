package redflixP;

import repositories.Director;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Redflix157 {

    private Director director1;

    public Redflix157() {
        this.director1 = new Director();
    }

    public String testConnection() {
        try {
            Connection conn = ConnectionJDBC.getConnection();
            if (conn != null) {
                return "Conectado";
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Falla conexion";
        }
        return "Error en la conexion";
    }

    public static void main(String[] args) {
        Redflix157 redflix157 = new Redflix157();
        System.out.println(redflix157.testConnection());

        JFrame frame = new JFrame("CRUD Director");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLayout(null);

        JLabel codigoLabel = new JLabel("Código");
        codigoLabel.setBounds(10, 10, 80, 25);
        frame.add(codigoLabel);

        JTextField codigoText = new JTextField(20);
        codigoText.setBounds(100, 10, 160, 25);
        frame.add(codigoText);
        
        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setBounds(10, 40, 80, 25);
        frame.add(nombreLabel);

        JTextField nombreText = new JTextField(20);
        nombreText.setBounds(100, 40, 160, 25);
        frame.add(nombreText);
        
        JLabel apellidoLabel = new JLabel("Apellido");
        apellidoLabel.setBounds(10, 70, 80, 25);
        frame.add(apellidoLabel);

        JTextField apellidoText = new JTextField(20);
        apellidoText.setBounds(100, 70, 160, 25);
        frame.add(apellidoText);
        
        JLabel nacionalidadLabel = new JLabel("Nacionalidad");
        nacionalidadLabel.setBounds(10, 100, 80, 25);
        frame.add(nacionalidadLabel);

        JTextField nacionalidadText = new JTextField(20);
        nacionalidadText.setBounds(100, 100, 160, 25);
        frame.add(nacionalidadText);

        JButton crearButton = new JButton("Crear");
        crearButton.setBounds(10, 130, 250, 25);
        frame.add(crearButton);
        
        JButton leerButton = new JButton("Leer");
        leerButton.setBounds(10, 160, 250, 25);
        frame.add(leerButton);
        
        JButton actualizarButton = new JButton("Actualizar");
        actualizarButton.setBounds(10, 190, 250, 25);
        frame.add(actualizarButton);
        
        JButton borrarButton = new JButton("Borrar");
        borrarButton.setBounds(10, 220, 250, 25);
        frame.add(borrarButton);
        
        crearButton.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
                System.out.println(redflix157.director1.insertDirector(Integer.parseInt(codigoText.getText()), nombreText.getText(), apellidoText.getText(), nacionalidadText.getText()));}
        });
        leerButton.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
                System.out.println(redflix157.director1.searchDirector(Integer.parseInt(codigoText.getText())));}
        });
        actualizarButton.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
                System.out.println(redflix157.director1.updateDirector(Integer.parseInt(codigoText.getText()),nacionalidadText.getText()));}
        });
        borrarButton.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
                System.out.println(redflix157.director1.deleteDirector(Integer.parseInt(codigoText.getText())));}
        });
        frame.setVisible(true);
    }
}
