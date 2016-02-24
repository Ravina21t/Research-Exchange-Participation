
package rep.data;
//import java.io.IOException;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.HashMap;
import rep.model.Study;
//import rep.model.User;
import java.util.*;
import rep.model.Answer;

public class StudyDB {
          
    int count=1;
   // Study study3 = new Study("1001","Study3 Code","study3@gmail.com","Study3 Question",30,30,"study3 Decsription","stop");
   // Study  study2 = new Study("1002","Study2 Code","study2@gmail.com","Study2 Question",20,20,"study2 Decsription","stop");
  //  Study study1 = new Study("1003","Study1 Code","study1@gmail.com","Study1 Question",10,10,"study1 Decsription","stop");
    public HashMap<String, Study> studies = new HashMap<String, Study>(); 
       
    public StudyDB() {
        
          
    }
      
    public void updateActParticipants(String code,int numofParticipants)
    {
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE study SET "
                + "ActParticipants = ? "
                 +"WHERE SCode= ?";
               
        try {
          
            ps = connection.prepareStatement(query);
           
            ps.setInt(1, numofParticipants);
            ps.setString(2, code);
       
           
          

           ps.executeUpdate();
        } catch (SQLException e) {
            
            System.out.println(e);
            return ;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
         
        
        
        
        
    }
    
    
    public void putStudies(Study study){       //working with db  
     
        System.out.println("I am inside put");
        String code;
        code= codeGenerator();
        study.setCode(code);
        String sName=study.getName();
        String desc=study.getDescription();
        String email=study.getEmail();
        Date dateCreated=study.getDateCreated();
        String question=study.getQuestion();
        String imageURL=study.getImageURL();
        int reqParticipants =study.getRequestedParticipants();
        int actParticipants=study.getNumOfParticipants();
        String sStatus=study.getStatus();
        
        PreparedStatement ps = null;
        ResultSet resultSet = null;
         
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
       
        String query = "insert into study"
				+ "(SName, SCode, Description, Email,DateCreated,Question,ImageURL,ReqParticipants,SStatus) VALUES"
				+ "(?,?,?,?,?,?,?,?,?)";
        try {
            System.out.println("I am inside try block in put");
            ps = connection.prepareStatement(query);
            ps.setString(1, sName);
            ps.setString(2, code);
            ps.setString(3, desc);
            ps.setString(4, email );
             java.util.Date date = new Date();
            ps.setTimestamp(5, new java.sql.Timestamp(date.getTime()));
            //ps.setDate(5, dateCreated);
            ps.setString(6, question);
            ps.setString(7, imageURL);
            ps.setInt(8,reqParticipants );
          //  ps.setInt(9, actParticipants);
            ps.setString(9, sStatus);
            ps.executeUpdate();
            
            System.out.println("Insertion done");
                
        } catch (SQLException e) {
            System.out.println(e);
         
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
         
    }
    
    public String codeGenerator()
    {
        StringBuilder sb=new StringBuilder();
        String code = "";
        Random randomGenerator = new Random();
        int num = randomGenerator.nextInt(100) + 1;
        sb.append(num);
        sb.append(count);
        code=sb.toString();       
        count++;
        return code;
    }
    
    
    public Study getStudy(String code)      //working with DB         
    {      
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Study study = new Study();
         
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
       
        String query = "select * from study where Scode = '" + code + "'";
        try {
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            if(resultSet.next()) {
  
                    System.out.println("I am inside foooorrr");
                    String sName =  resultSet.getString("SName");
                    String sCode =  resultSet.getString("SCode");
                    String description =  resultSet.getString("Description");
                    String email =  resultSet.getString("Email");
                   // Date dateCreated =  resultSet.getDate("DateCreated");
                    String question =  resultSet.getString("Question");
                    String imageURL =  resultSet.getString("ImageURL");
                    int reqParticipants =  resultSet.getInt("ReqParticipants");
                    int actParticipants =  resultSet.getInt("ActParticipants");
                    String sStatus =  resultSet.getString("SStatus");
                    System.out.println("Study details is " + sName);
                    study.setName(sName);
                    study.setCode(sCode);
                    study.setDescription(description);
                    study.setEmail(email);
                    //study.setDateCreated(dateCreated);
                    study.setQuestion(question);
                    study.setImageURL(imageURL);
                    study.setRequestedParticipants(reqParticipants);
                    study.setNumOfParticipants(actParticipants);
                    study.setStatus(sStatus);
                  
                 }
                  return study;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    
    }
    

     public Study getStudy(String code,String e_mail) //not yet done
    {
       
         PreparedStatement ps = null;
        ResultSet resultSet = null;
        Study study = new Study();
         
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
       
        String query = "select * from study where Scode = '" + code + "' and Email = '" + e_mail + "'";
        try {
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            if(resultSet.next()) {
  
                    System.out.println("I am inside foooorrr");
                    String sName =  resultSet.getString("SName");
                    String sCode =  resultSet.getString("SCode");
                    String description =  resultSet.getString("Description");
                    String email =  resultSet.getString("Email");
                   // Date dateCreated =  resultSet.getDate("DateCreated");
                    String question =  resultSet.getString("Question");
                    String imageURL =  resultSet.getString("ImageURL");
                    int reqParticipants =  resultSet.getInt("ReqParticipants");
                    int actParticipants =  resultSet.getInt("ActParticipants");
                    String sStatus =  resultSet.getString("SStatus");
                    System.out.println("Study details is " + sName);
                    study.setName(sName);
                    study.setCode(sCode);
                    study.setDescription(description);
                    study.setEmail(email);
                    
                   // java.util.Date date = new Date();
          //  ps.setTimestamp(4, new java.sql.Timestamp(date.getTime()));
                    
                    
                   // study.setDateCreated(new java.sql.Date(dateCreated.getTime()));// check
                    study.setQuestion(question);
                    study.setImageURL(imageURL);
                    study.setRequestedParticipants(reqParticipants);
                    study.setNumOfParticipants(actParticipants);
                    study.setStatus(sStatus);
                  
                 }
                  return study;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
    }
     public List<Study> getAllStudies()    //working with db      
    {             
        
        System.out.println("inside get all studies function"); 
        
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Study> newStudies = new ArrayList<Study>();         
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
       
        String query = "select * from study ";
        try {
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while(resultSet.next()) {
                    Study study = new Study();  
                    System.out.println("I am inside foooorrr");
                    String sName =  resultSet.getString("SName");
                    String sCode =  resultSet.getString("SCode");
                    String description =  resultSet.getString("Description");
                    String email =  resultSet.getString("Email");
                   // Date dateCreated =  resultSet.getDate("DateCreated");
                    String question =  resultSet.getString("Question");
                    String imageURL =  resultSet.getString("ImageURL");
                    int reqParticipants =  resultSet.getInt("ReqParticipants");
                    int actParticipants =  resultSet.getInt("ActParticipants");
                    String sStatus =  resultSet.getString("SStatus");
                    System.out.println("Study details is " + sName);
                    study.setName(sName);
                    study.setCode(sCode);
                    study.setDescription(description);
                    study.setEmail(email);
                    
                   //  study.setDateCreated(new java.sql.Date(dateCreated.getTime()));// check
                    //study.setDateCreated(dateCreated);
                    study.setQuestion(question);
                    study.setImageURL(imageURL);
                    study.setRequestedParticipants(reqParticipants);
                    study.setNumOfParticipants(actParticipants);
                    study.setStatus(sStatus);                         
                    newStudies.add(study);
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
     
     
     public List<Study> getAllStudies(String status)    //working with db      
    {             
        
        System.out.println("inside get all studies using status function");        
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Study> newStudies = new ArrayList<Study>();         
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
       
        String query = "select * from study where SStatus = '" + status + "'";
        try {
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            
            while(resultSet.next()) {
                    Study study = new Study();  
                    System.out.println("I am inside foooorrr");
                    String sName =  resultSet.getString("SName");
                    String sCode =  resultSet.getString("SCode");
                    String description =  resultSet.getString("Description");
                    String email =  resultSet.getString("Email");
                   // Date dateCreated =  resultSet.getDate("DateCreated");
                    String question =  resultSet.getString("Question");
                    String imageURL =  resultSet.getString("ImageURL");
                    int reqParticipants =  resultSet.getInt("ReqParticipants");
                    int actParticipants =  resultSet.getInt("ActParticipants");
                    String sStatus =  resultSet.getString("SStatus");
                    System.out.println("Study details is " + sName);
                    study.setName(sName);
                    study.setCode(sCode);
                    study.setDescription(description);
                    study.setEmail(email);
                   //  study.setDateCreated(new java.sql.Date(dateCreated.getTime()));// check
                    
                    //study.setDateCreated(dateCreated);
                    study.setQuestion(question);
                    study.setImageURL(imageURL);
                    study.setRequestedParticipants(reqParticipants);
                    study.setNumOfParticipants(actParticipants);
                    study.setStatus(sStatus);                         
                    newStudies.add(study);
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
    
    public List<Study> getStudies(String e_mail)       //working with DB           
    {                    
        System.out.println("inside get studies using email function"); 
          
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Study> newStudies = new ArrayList<Study>();
         
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
       
        String query = "select * from study where Email = '" + e_mail + "'";
        try {
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
                    Study study = new Study();
                    System.out.println("I am inside foooorrr");
                    String sName =  resultSet.getString("SName");
                    String sCode =  resultSet.getString("SCode");
                    String description =  resultSet.getString("Description");
                    String email =  resultSet.getString("Email");
                   // Date dateCreated =  resultSet.getDate("DateCreated");
                    String question =  resultSet.getString("Question");
                    String imageURL =  resultSet.getString("ImageURL");
                    int reqParticipants =  resultSet.getInt("ReqParticipants");
                    int actParticipants =  resultSet.getInt("ActParticipants");
                    String sStatus =  resultSet.getString("SStatus");
                    System.out.println("Study details is " + sName);
                    study.setName(sName);
                    study.setCode(sCode);
                    study.setDescription(description);
                    study.setEmail(email);
                    // study.setDateCreated(new java.sql.Date(dateCreated.getTime()));// check
                    
                    //study.setDateCreated(dateCreated);
                    study.setQuestion(question);
                    study.setImageURL(imageURL);
                    study.setRequestedParticipants(reqParticipants);
                    study.setNumOfParticipants(actParticipants);
                    study.setStatus(sStatus);      
                    
                    newStudies.add(study);
                 
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
    
    
    public void updateRecord(String code,String name,String question,int reqOfParticipants,String desc)
    {
        
        PreparedStatement ps = null;
        ResultSet resultSet = null;
         
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
       
       String query = "update study SET SName = ?,Question = ?, ReqParticipants=? ,  Description=?"
				                  + " WHERE SCode = ?";
        try {
            System.out.println("I am inside try block in put");
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, question);
            ps.setInt(3, reqOfParticipants);
            ps.setString(4, desc );
            ps.setString(5, code);
            ps.executeUpdate();
            
            System.out.println("Insertion done");
                
        } catch (SQLException e) {
            System.out.println(e);
         
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
        
        
    }
    
    
    
    
    
    
    
    
    
    public void updateStatus(Study s,String status)
    {
        String code = s.getCode();
        System.out.println("code in update func is" + code);
          PreparedStatement ps = null;
        ResultSet resultSet = null;
        Study study = new Study();
         
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
       
        String query = "update study SET SStatus = ? "
				                  + " WHERE SCode = ?";

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, status);
            ps.setString(2, code);
            ps.executeUpdate();
            System.out.println("status updated");
           
                
        } catch (SQLException e) {
            System.out.println(e);
        
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    
        
    }
    
    
    
     
    
    
   
}
    
    
 