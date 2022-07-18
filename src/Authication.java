import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tend
 */
public class Authication {
    public static String username;
    public static String useremail;
    public static String id;
    public static boolean isPassengerLogin(String email, String password, JFrame frame)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buse-ticketing","root","");
            
            String query =
                    "SELECT * FROM passenger WHERE email = '"
                    + email + "'";
            
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();       
            
            
            while(resultSet.next())
            {
                String pass = resultSet.getString("password");
                  id = String.valueOf(resultSet.getInt("passenger_id"));
                if(pass.equals(password))
                    return true;
                else
                    return false;
                
            }
        }catch(Exception exception){
            //JOptionPane.showMessageDialog(frame, "Database error: " + exception.getMessage());
        }
        
        return false;
    }
    
    public static boolean isAdminLogin(String email, String password, JFrame frame)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buse-ticketing","root","");
            
            String query =
                    "SELECT * FROM admin WHERE email = '"
                    + email + "'";
            
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();       
            
            
            while(resultSet.next())
            {
                String pass = resultSet.getString("password");
                
                if(pass.equals(password))
                    return true;
                else
                    return false;
                
            }
        }catch(Exception exception){
            //JOptionPane.showMessageDialog(frame, "Database error: " + exception.getMessage());
        }
        
        return false;
    }   
}