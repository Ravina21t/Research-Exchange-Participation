
package rep.model;
import java.io.Serializable;
import java.sql.Date;// check it should be util or sql
import java.util.ArrayList;
import java.util.List;

public class Study implements Serializable{
    
    private String name;
    private String code;
    private Date dateCreated;
    private String email;
    private String question;
    private int requestedParticipants;
    private int numOfParticipants;
    private String description;
    private String status;
    private String imageURL;
    private double average;
    private double minimum;
    private double maximum;
    private double SD;
    
   
   

    public Study() {
        name="";
        code="";
        //What to do for date
        email="";
        question="";
        requestedParticipants=0;
        numOfParticipants=0;
        description="";
        status=""; 
        imageURL="";       
    }
    
    public Study(String code,String name,String email,String question,int requestedParticipants,String description,String status)
    {
        this.code=code;
        this.name=name;
        this.email = email;
        this.question=question;
        this.requestedParticipants=requestedParticipants;
        this.description=description;
        this.status = status;
    
    }
    
    public Study(String name, String code,String email,String question,int requestedParticipants,int numOfParticipants, String description, String status)
    {
        this.name=name;
        this.code=code;
        //this.dateCreated=dateCreated;
        this.email=email;
        this.question=question;
        this.requestedParticipants=requestedParticipants;
        this.numOfParticipants=numOfParticipants;
        this.description=description;
        this.status=status;       
    }
    
    public String getName() {
        
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDateCreated() {
       // dateCreated = 1-1-2015;
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getEmail() {
        
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuestion() {      
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getRequestedParticipants() {
       
        return requestedParticipants;
    }

    public void setRequestedParticipants(int requestedParticipants) {
        this.requestedParticipants = requestedParticipants;
    }

    public int getNumOfParticipants() {
        
        return numOfParticipants;
    }

    public void setNumOfParticipants(int numOfParticipants) { 
        
        this.numOfParticipants = numOfParticipants;
    }

    public String getDescription() {
        
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {       
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
// Will have to manupulate them
    public String getImageURL() {
        return imageURL;
    }

    
    public void setImageURL(String imageURL) {
        // code to generate imageURL from Study code
        this.imageURL = imageURL;
    }
    
    
     public double getMinimum() {
        return minimum;
        }
      
      
    public double getMaximum() {
        return maximum;
        }
    
     public double getAverage() {
        return average;
    }
     
     
    public double getSD() {
        return SD;
    }
    
     
     
     
    
    
    
}
