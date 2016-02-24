


package rep.model;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class TempUser implements Serializable {
    private String uname;
    private String password;
   private String email;
   private String token;
   private String salt;
   private Timestamp expiryDate;
   
    public TempUser()
    {
        uname="";
        password="";
        email="";
        token="";
        salt="";
        expiryDate=null;
           
    }
    
    public TempUser(String uname, String password, String email, String token,String salt)       
    {
        this.uname=uname;
        this.password=password;
        this.email=email;
        this.token=token;
        this.salt=salt;
    }
    
     public TempUser(String email, String token)       
    {
        this.uname=uname;
        this.password=password;
        this.email=email;
        this.token=token;
        this.salt=salt;
    }
     
      public TempUser(String email, String token,Timestamp expiryDate)       
    {
        this.uname=uname;
        this.password=password;
        this.email=email;
        this.token=token;
        this.salt=salt;
        this.expiryDate = expiryDate;
        
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
   
   
   
   
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }
   
   
   
}