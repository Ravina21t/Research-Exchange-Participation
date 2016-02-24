
package rep.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rep.model.Answer;
import rep.model.Study;


public class AnswerDB {

    List<Answer> ansList = new ArrayList<Answer>();   
    private ArrayList<Answer> listAns;
      
     public List<Answer> getAnswer() {            
		return ansList;
	}
    
     public void setAnswer(ArrayList<Answer> listAns) { 
        this.listAns = listAns;        
	}

     public void setAnswerObj(String email,int choice) {	 
        Answer ans = new Answer(email,choice);
        ansList.add(ans);       
	}
     
     public void addAnswer(Answer ans){  
         
         
        // DateUtil dateutil=new DateUtil();
        int choice = ans.getChoice();
        String email = ans.getEmail();
        String code = ans.getSCode();
        
        PreparedStatement ps = null;
        ResultSet resultSet = null;
         
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
       
        String query = "insert into answer"
				+ "(Email, Choice, SCode,DateSubmitted) VALUES"
				+ "(?,?,?,?)";
        
        try {
            System.out.println("I am inside try block in put");
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setInt(2, choice);
            ps.setString(3, code);
            
            
           //  ps.setDate(4, new java.sql.Date(dateutil.getDate().getTime()));
            
            java.util.Date date = new Date();
            ps.setTimestamp(4, new java.sql.Timestamp(date.getTime()));
            
           // ps.setTimestamp(4, new java.sql.Date(new java.util.Date()));
            //ps.setDate(4, dateCreated);
          
            ps.executeUpdate();
            
            System.out.println("Insertion done");
                
        } catch (SQLException e) {
            System.out.println(e);
         
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
          
     }
     
     
     public List<Answer> getAnswerByEmail(String e_mail)    //working with db      
    {                    
        System.out.println("inside get all studies using status function");        
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Answer> newStudies = new ArrayList<Answer>();         
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();       
        String query = "select * from answer where Email = '" + e_mail + "'";
        try {
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();           
            while(resultSet.next()) {
                    Answer ans = new Answer();
                    System.out.println("I am inside foooorrr");
                    String email =  resultSet.getString("Email");
                    int choice =  resultSet.getInt("Choice");
                   String code =  resultSet.getString("SCode");
                   // Date dateSubmitted =  resultSet.getDate("DateSubmitted");
                    ans.setEmail(email);
                    ans.setChoice(choice);
                    ans.setSCode(code);
                    //ans.setdateSubmitted(dateSubmitted);
                    newStudies.add(ans);
                 }
            
                  return newStudies;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }   
    }
         
     public List<Answer> getAnswerByCode(String SCode)    //working with db      
    {                                            
        System.out.println("inside get all studies using status function");        
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Answer> newStudies = new ArrayList<Answer>();         
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();       
        String query = "select * from answer where Email = '" + SCode + "'";
        try {
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();           
            while(resultSet.next()) {
                    Answer ans = new Answer();
                    System.out.println("I am inside foooorrr");
                    String email =  resultSet.getString("Email");
                    int choice =  resultSet.getInt("Choice");
                    String code =  resultSet.getString("SCode");
                   // Date dateSubmitted =  resultSet.getDate("DateSubmitted");
                    ans.setEmail(email);
                    ans.setChoice(choice);
                    ans.setSCode(code);
                    //ans.setdateSubmitted(dateSubmitted);
                    newStudies.add(ans);
                 }
            
                  return newStudies;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }   
     
    }
     
     
     
     
     public static boolean answerExists(String email,String code) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Email FROM answer "
                + "WHERE Email = ? AND SCode=? ";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
             ps.setString(2, code);
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
