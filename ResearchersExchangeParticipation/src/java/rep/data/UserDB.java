
package rep.data;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import rep.model.User;
import Utility.*;

public class UserDB {
    
    // returns the user object
    
    public static User getUser(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM user "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setName(rs.getString("UName"));// note
                user.setEmail(rs.getString("Email"));
                user.setParticipants(rs.getInt("Studies"));
                user.setParticipation(rs.getInt("Participation"));
                user.setCoins(rs.getInt("Coins"));
                
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
        
        
        
    }
    
    // Validates the user
     public static int validateUser(String Email, String Password)
     {
         
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM credentials "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, Email);
            rs = ps.executeQuery();
            
            
            
            
            
            while(rs.next())
            {
                String salt= rs.getString("Salt");
            String hashedPasswordSalt=rs.getString("Password");
            if(hashedPasswordSalt.equals(PasswordUtil.hashPasswordSalt(Password+salt)))
            {
                System.out.println("Inside one");
                return 1;
            }
            }
            System.out.println("outside 1");
            return 0;
          /*  while(rs.next())
            {
               if(rs.getString(1).equals(Password))
               {
                   return 1;
               }
            }
            
            return 0;
           */ 
        } catch (Exception e) {
            System.out.println("Exception is at :"+e);
            return 0;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
         
         
         
         
         
         
         // return 1 or 0
         
         }
    
   
     
    
     public static void addCredentials(String Email, String Password,String Salt)
    {
        
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO credentials (Email,Password,Salt) "
                + "VALUES (?, ?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, Email);
            ps.setString(2, Password);
            ps.setString(3, Salt);
           
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return ;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
     
     // Update Credentials for forgot password 
     
     
     public static void updateCredentials(String Email, String Password,String Salt)
    {
        System.out.println("I am inside func" + "values here is" + Email + " pass " + Password + " salt " + Salt);
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

          String query = "UPDATE credentials SET Password = ?,Salt = ? "
				                  + " WHERE Email = ?";
          
          
        try {
          
            ps = connection.prepareStatement(query);
            ps.setString(1, Password);
            ps.setString(2, Salt);
            ps.setString(3, Email);
           
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
          
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
     
     
     //*************modification*********************
    //Adds the user in db
     public static void addUser(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO user (UName,Email,Studies,Participation,Coins) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setInt(3, user.getParticipants());
            ps.setInt(4, user.getParticipation());
            ps.setInt(5, user.getCoins());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return ;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
     
     
     // Update the participation if user participates in a study
      public static void updateParticipations(User user)
     {
          ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE user SET "
                + "Participation = ? "
                 +"WHERE Email= ?";
               
        try {
          
            ps = connection.prepareStatement(query);
           
            ps.setInt(1, user.getParticipation());
            ps.setString(2, user.getEmail());
       
           
          

           ps.executeUpdate();
        } catch (SQLException e) {
            
            System.out.println(e);
            return ;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
         
         
         
         }
      
      
      
        public static void updateCoins(User user)
     {
          ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE user SET "
                + "Coins = ? "
                +"WHERE Email= ?";
               
        try {
          
            ps = connection.prepareStatement(query);
           
            ps.setInt(1, user.getCoins());
       
             ps.setString(2, user.getEmail());
          

           ps.executeUpdate();
        } catch (SQLException e) {
            
            System.out.println(e);
            return ;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
         
         
         
         }
      
      
      
      
    
     // updates the study in db
    public static void updateUserStudies(User user)
     {
         
         
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE user SET "
                + "Studies = ? "
                 +"WHERE Email= ?";
               
        try {
          
            ps = connection.prepareStatement(query);
           
            ps.setInt(1, user.getParticipants());
             ps.setString(2, user.getEmail());
          
       
           
          

           ps.executeUpdate();
        } catch (SQLException e) {
            
            System.out.println(e);
            return ;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
         }
    
    
    //******check if it creates prob***************
     public static boolean emailExists(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Email FROM credentials "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    



}























/*
public class UserDB {
    
     
     HashMap<String, User> list = new HashMap<String, User>(); 
            
      
     public UserDB()
     {
         
     }
      
      public void setUser(User user)
   {
       list.put(user.getEmail(), user);
   }
     
       public User getUser() 
     {
       return null;
         }
      
      public User getUser(String emailAddress) {
        
        User user =list.get(emailAddress);
        if(user != null)
        {
            return user;
        }
        return null;
         }
      
      // returning all users 
     public  HashMap<String, User> getUsers() {
  
         return null;
     
     }
    
  
   
}
*/