/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tendie;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Tend
 */
public class Validations {
     public static boolean validEmail(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
   }
     
    private static final String PASSWORD_REGEX =
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,15}$";
 
    private static final Pattern PASSWORD_PATTERN =
                                Pattern.compile(PASSWORD_REGEX);
 
    public static boolean validPassword(String password)
    {
 
        // Validate a password
        if (PASSWORD_PATTERN.matcher(password).matches()) {
            return true;
        }
        else {
            return false;
        }
    }
 
    
    static String useremail;
 public static boolean checkEmail(String email)
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
                
                useremail = resultSet.getString("email");
              
                if(useremail.equals(email))
                    return true;
                else
                    return false;
                
            }
        }catch(Exception exception){
             String error = "Database error: " + exception.getMessage();
             System.out.println(error);
        }
    return false;

}

  static String firstname;
 public static boolean checkfirstname(String fname)
  {
    try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buse-ticketing","root","");
            
            String query =
                    "SELECT * FROM passenger WHERE firstname = '"
                    + fname + "'";
            
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();       
            
            
            while(resultSet.next())
            {
                
                firstname = resultSet.getString("firstname");
              
                if(firstname.equals(fname))
                    return true;
                else
                    return false;
                
            }
        }catch(Exception exception){
             String error = "Database error: " + exception.getMessage();
             System.out.println(error);
        }
    return false;

}

    
}
