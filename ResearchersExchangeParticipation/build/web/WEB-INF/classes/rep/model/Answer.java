
package rep.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Answer implements Serializable {
    
    private String email;
    private int choice;
    private String SCode;
    private double average;
    private double minimum;
    private double maximum;
    private double SD;   
    private Date dateSubmitted;
     List<Answer> ansList = new ArrayList<Answer>();   
     private ArrayList<Answer> listAns;

    public Answer() {
        email="";
        choice=0;
        average=0;
        minimum=0;
        maximum=0;
        SD=0;
        SCode="";
        }

    public Answer(String email, int choice) {
        this.email = email;
        this.choice = choice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public String getSCode() {
        return SCode;
    }

    public void setSCode(String SCode) {
        this.SCode = SCode;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
    
    
     public Date getdateSubmitted() {
        return dateSubmitted;
    }

    public void setdateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }
  

    public void setAverage(double average) {       
        // code to calculate average
        this.average = average;
    }

    public void setMinimum(double minimum) {
        // code to calculate minimum
        this.minimum = minimum;
    }

    public void setMaximum(double maximum) {
        // code to calculate maximum
        this.maximum = maximum;
    }


    public void setSD(double SD) {
        // code to calculate SD
        this.SD = SD;
    }
    
    
   
    }
