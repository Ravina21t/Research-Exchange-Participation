/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rep.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import rep.model.TempUser;


/**
 *
 * @author charu
 */
public class TempUserDB {
    
    
    
    
    
    //Adds the user in db    //added expiry date
     public static void addTempUser(TempUser tempuser) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO tempuser (UName,Email,Password,IssueDate,Token,Salt,ExpiryDate) "
                + "VALUES (?, ?, ?, ?, ?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, tempuser.getUname());
            ps.setString(2, tempuser.getEmail());
            ps.setString(3, tempuser.getPassword());
                    
            java.util.Date date = new Date();
            ps.setTimestamp(4, new java.sql.Timestamp(date.getTime()));
            
            ps.setString(5, tempuser.getToken());
            ps.setString(6,tempuser.getSalt());
            
              ps.setTimestamp(7, tempuser.getExpiryDate());
           
            
          
            
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return ;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
     
     
     
     
    
      public static TempUser getTempUser(String token) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM tempuser "
                + "WHERE Token = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, token);
            rs = ps.executeQuery();
            TempUser tempuser = null;
            if (rs.next()) {
                tempuser = new TempUser();
                tempuser.setUname(rs.getString("UName"));// note
                tempuser.setEmail(rs.getString("Email"));
                tempuser.setPassword(rs.getString("Password"));
                tempuser.setToken(rs.getString("Token"));
                tempuser.setSalt(rs.getString("Salt"));
                tempuser.setExpiryDate(rs.getTimestamp("ExpiryDate"));
            }
            return tempuser;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
        
        
        
    }
     
     
     
     
      public static void deleteTempUser(String token) {
          
          
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "Delete from tempuser "
                + "where Token = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, token);
               
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return ;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
          
      }
      
      
      
      // validating that the token exists or not in tempuser table
     public static boolean tokenExists(String token) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Email FROM tempuser "
                + "WHERE token = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, token);
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
     
     
    
    
//}
