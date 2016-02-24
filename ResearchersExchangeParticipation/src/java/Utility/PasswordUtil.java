/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
//import java.util.Base64;
import org.apache.tomcat.util.codec.binary.Base64;

public class PasswordUtil {
    
    /*  This code uses SHA-256. If this algorithm isn't available to you,
        you can try a weaker level of encryption such as SHA-128.
    */    
    public static String hashPasswordSalt(String passwordsalt)
            throws NoSuchAlgorithmException {        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.reset();
        md.update(passwordsalt.getBytes());
        byte[] mdArray = md.digest();
        StringBuilder sb = new StringBuilder(mdArray.length * 2);
        for (byte b : mdArray) {
            int v = b & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }        
        return sb.toString();        
    }
    
    public static String getSalt() {
        Random r = new SecureRandom();
        byte[] saltBytes = new byte[32];
        r.nextBytes(saltBytes);
      //  return Base64.getEncoder().encodeToString(saltBytes);
        return Base64.encodeBase64String(saltBytes);
    }
    
  /*  public static String hashAndSaltPassword(String saltpassword)
            throws NoSuchAlgorithmException {
       // String salt = getSalt();
        return hashPassword(saltpassword);
    }
    */
    
    public static boolean checkPasswordStrength(String password)  {
        if (password == null || password.trim().isEmpty() || password.length()<3) {
            return false;
           
        } 
        return true;
    }

    
    // check used or not
    public static boolean validatePassword(String password) {
        try {
            checkPasswordStrength(password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    /*  This code tests the functionality of this class.
    */ 
    /*
    public static void main(String[] args) {
        try {
            System.out.println("Hash for 'sesame':\n"
                    + hashPassword("sesame"));
            System.out.println("Random salt:\n"
                    + getSalt());
            System.out.println("Salted hash for 'sesame':\n"
                    + hashAndSaltPassword("sesame"));            
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
        
        try {
            checkPasswordStrength("sesame1776");
            System.out.println("Password is valid.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
    }
    
    */
}

