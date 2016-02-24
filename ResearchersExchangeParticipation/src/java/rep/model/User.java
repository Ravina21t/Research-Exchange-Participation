
package rep.model;
import java.io.Serializable;

public class User implements Serializable {
    private String email;
    private String name;
    private int coins;
    private int participants;
    private int participation;
    /*
    private double average;
    private double minimum;
    private double maximum;
    private double SD;
    */
    public User()
    {
        name="";
        email="";
        coins=0;
        participants=0;
        participation=0;
    }
    
    public User(String email, String name)       
    {
        
        this.email=email;
        this.name=name;
        this.coins=0;
        this.participants=0;
        this.participation=0;
    }
    
    public User( String email, String name, int coins, int participants, int participation)
    {      
        this.email=email;
        this.name=name;
        this.coins=coins;
        this.participants=participants;
        this.participation=participation;        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public int getParticipation() {
        return participation;
    }

    public void setParticipation(int participation) {
        this.participation = participation;
    }    
}





