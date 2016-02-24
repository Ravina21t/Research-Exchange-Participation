package MyPackage;

public class MainClass {

	
	public void sendEmailRecommend(String name,String friendemail,String message, String token) {
		// TODO Auto-generated method stub
		String body =name+" recommended you to try Researchers Exchange Participation saying-"+message + "Please click the follwing link to activate your account-"+"  "
                        + "http://rep-charu.rhcloud.com/ResearchersExchangeParticipation/UserController?action=create&token="+token;
		String from ="nbad.charu@gmail.com"; // email of sender
		String sub ="Recommended-Researchers Exchange Participation";// subject of the mail
		String id = "nbad.charu@gmail.com"; // email of the sender
		String pass = "nbad.charu9339"; // password of the sender's email
		String to = friendemail;// email of the reciever//pass=nbad.charu9339
		GMailSender sender = new GMailSender(id, pass);
		
		try {
			sender.sendMail(sub, body, from, to);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
        
        	public void sendEmailContact(String name,String contactemail,String message) {
		// TODO Auto-generated method stub
		String body ="Hi I am "+name+" .Contact me back on "+contactemail+"--"+message;//Body of the mail
		String from ="nbad.charu@gmail.com"; // email of sender
		String sub ="Contact-Researchers Exchange Participation";// subject of the mail
		String id = "nbad.charu@gmail.com"; // email of the sender
		String pass = "nbad.charu9339"; // password of the sender's email
		String to ="nbad.charu@gmail.com" ;// email of the reciever//pass=nbad.charu9339
		GMailSender sender = new GMailSender(id, pass);
		
		try {
			sender.sendMail(sub, body, from, to);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
//return;
	}
                        
                public void sendEmailActivation(String email,String token) {
		// TODO Auto-generated method stub
		String body ="Please click the follwing link to activate your account-"+"  "
                        + "http://rep-charu.rhcloud.com/ResearchersExchangeParticipation/UserController?action=activate&token="+token;//Body of the mail
		String from ="nbad.charu@gmail.com"; // email of sender
		String sub ="Activate account-Researchers Exchange Participation";// subject of the mail
		String id = "nbad.charu@gmail.com"; // email of the sender
		String pass = "nbad.charu9339"; // password of the sender's email
		String to = email;// email of the reciever//pass=nbad.charu9339
		GMailSender sender = new GMailSender(id, pass);
		
		try {
			sender.sendMail(sub, body, from, to);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//return;
	}  
                
           
                public void forgotPassword(String email,String token) {
		String body ="Please click the follwing link to reset the password"+"  "
                        + "http://rep-charu.rhcloud.com/ResearchersExchangeParticipation/UserController?action=resetPassword&token="+token;//Body of the mail
		String from ="nbad.charu@gmail.com"; // email of sender
		String sub ="Forgot password-Researchers Exchange Participation";// subject of the mail
		String id = "nbad.charu@gmail.com"; // email of the sender
		String pass = "nbad.charu9339"; // password of the sender's email
		String to = email;// email of the reciever//pass=nbad.charu9339
		GMailSender sender = new GMailSender(id, pass);
		
		try {
			sender.sendMail(sub, body, from, to);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}                
}


