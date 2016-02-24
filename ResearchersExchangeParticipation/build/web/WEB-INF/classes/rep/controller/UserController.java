
package rep.controller;

import MyPackage.*;
import Utility.*;
import java.io.*;
import java.net.InetAddress;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import java.util.HashMap;
import java.util.UUID;

import javax.servlet.*;
import javax.servlet.http.*;
import rep.data.UserDB;
import rep.data.TempUserDB;


import rep.model.User;
import rep.model.TempUser;


public class UserController extends HttpServlet {
   // UserDB userDb = new UserDB();
   // HashMap<String,String> passwordDB = new HashMap<String,String>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       String url="home.jsp";
       
       HttpSession session = request.getSession();
       String action=request.getParameter("action");
      
       Cookie c = new Cookie("myCookie",InetAddress.getLocalHost().getHostName()+" "+request.getLocalName()+" "+ request.getLocalPort());
       c.setMaxAge(60*60*24*365*2);
       c.setPath("/");
       response.addCookie(c);
              
              
       if(action==null)
       {
           url="/home.jsp";
       }
       if(action.equals("login"))
       {
           session.invalidate();// check own
           url="/login.jsp";
       }
       else if(action.equals("how"))
        {
            // checks the session for "theUser" object
            User userexists=(User)session.getAttribute("theUser");
            //does not exist
            if(userexists==null)
            {
                url="/how.jsp";
            }
            //exists
            else
            {
                url="/main.jsp";
            }
        }
       
      
       else if (action.equals("about"))
       {
            // checks the session for "theUser" object
           User userexists=(User)session.getAttribute("theUser");
           // does no exists
            if(userexists==null)
            {
                url="/about.jsp";
            }
            // exists
            else
            {
                url="/aboutl.jsp";
            }
           
       }
        else if (action.equals("home"))
       {
           // checks the session
           User userexists=(User)session.getAttribute("theUser");
           //session object does not exists
            if(userexists==null)
            {
                url="/home.jsp";
            }
            // session object exists
            else
            {
                url="/main.jsp";
            }
           
       }
        else if (action.equals("main"))
       {
           // checks the session for object
           User userexists=(User)session.getAttribute("theUser");
           // if it does not exists
            if(userexists==null)
            {
                url="/login.jsp";
            }
            // if it exists
            else
            {
                url="/main.jsp";
            }
           
       }
        else if (action.equals("activate"))
        {
            String token=request.getParameter("token");
            
            //validate the token is present in db or not
            
             if(TempUserDB.tokenExists(token))
            {
                 /*//creates a user bean for the user
                User newuser=  new User(email,name);
                UserDB.addCredentials(email, password);
                UserDB.addUser(newuser);
                session.setAttribute("theUser", newuser);
                
                // dispatches to main.jsp
                url="/main.jsp";
                
                
                */
                
                //if token is present
                
                // move the user record from tempuser table to user table and creates a user bean for the user
                
                TempUser tempuser=TempUserDB.getTempUser(token);
               
                User newuser=  new User(tempuser.getEmail(),tempuser.getUname());
                UserDB.addCredentials(tempuser.getEmail(), tempuser.getPassword(),tempuser.getSalt());
                UserDB.addUser(newuser);
            
                
                
                //adds the user bean to current session
                 session.setAttribute("theUser", newuser);
    
                 // delete the tempuser
                 TempUserDB.deleteTempUser(token);
                 
                // dispatches to main.jsp
                url="/main.jsp";
                                
            }
             else
             {
                 // if token is not present
                 
                 // adds an error message
                 String err="LOGIN FAILED-This was one time activation link!";
                 request.setAttribute("msg", err);                  
                 // dispatches to signup.jsp
                 url="/signup.jsp";           
             }   
        }
       
        else if(action.equalsIgnoreCase("resetPassword"))
        {           
             String token=request.getParameter("token");           
            //validate the token is present in db or not          
             if(TempUserDB.tokenExists(token))
            {
                TempUser usr = TempUserDB.getTempUser(token);
                //check expiry
                System.out.println("expiry is" + usr.getExpiryDate());
                Timestamp exp = usr.getExpiryDate();
                long retryDate = System.currentTimeMillis();
                Timestamp original = new Timestamp(retryDate);
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(original.getTime());
                System.out.println("current time" + original);
                request.setAttribute("usr", usr);
                if(original.before(exp))
                {
                    System.out.println("not expired");
                    url = "/resetPassword.jsp";        
                }
                else
                {
                    System.out.println("expired");
                    String err="Token Expired";
                    request.setAttribute("msg", err);
                    url="/login.jsp";
                }
                //TempUserDB.deleteTempUser(token);        
            }   
        }
       
       else if (action.equals("create"))
        {
            session.invalidate();
        System.out.println("Create for friend");
        String token = request.getParameter("token");
        request.setAttribute("token", token);
        url="/signup.jsp";
        }
       
       // forward request and response objects to specified URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
      // UserDB test = new UserDB();
       // Object message;
        HttpSession session = request.getSession();
    
       String action=request.getParameter("action");
      
        Cookie c = new Cookie("myCookie",InetAddress.getLocalHost().getHostName()+" "+request.getLocalName()+" "+ request.getLocalPort());
      c.setMaxAge(60*60*24*365*2);
       c.setPath("/");
       response.addCookie(c);
       
        String url="/home.jsp";
       try{ 
       if(action==null)
       {
           url="/home.jsp";
       }
       else if(action.equals("login"))
        {  // checks the http request for the parameter email and password
            String email=request.getParameter("email");
            String password=request.getParameter("password");
           // User user;
            // validates if the combination exists
           
          //  user=userDb.getUser(email);
           
            
           
          int x=UserDB.validateUser(email, password);
            
               if(x==1)
               {
                   User user=UserDB.getUser(email);
                   
                    //System.out.println("CHARUUUUU"+user.getParticipants()+user.getEmail()+user.getCoins()+user.getParticipation());
                    
                    session.setAttribute("theUser", user);
                    url="/main.jsp";
               }
               // if incorrect
               else
               {
                   System.out.println("password incorrect");
                   request.setAttribute("msg","LOGIN FAILD-USERNAME-PASSWORD DOES NOT EXIST");
                   
                    url="/login.jsp";
               }
            
        }
       else if(action.equals("create"))
       {
           // checks the http request for parameters
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            
            String password=request.getParameter("password");
            String cpassword=request.getParameter("cpassword");
            String task=request.getParameter("task");
            // validates the above information
            String token_recommendation = request.getParameter("token");
            //for recommendation
            System.out.println("-------------token" + token_recommendation);
            
            
            
            if(TempUserDB.tokenExists(token_recommendation))
            {
                String tmpemail;
                System.out.println("token exists in database");
                TempUser tmp = TempUserDB.getTempUser(token_recommendation);
                System.out.println("&&& email is" + tmp.getEmail());
                tmpemail = tmp.getEmail();
                // update coins in DB
                User usr = UserDB.getUser(tmpemail);
                int originalCoins = usr.getCoins();
                System.out.println("original coins" + originalCoins);
                int updatedParticipants = originalCoins + 2;
                System.out.println("updated coins" + updatedParticipants);
                usr.setCoins(updatedParticipants);
                //Update coins in session
                User userObj=(User)session.getAttribute("theUser");
                if(userObj != null)
                {             
                int updateCoinSession = userObj.getCoins() + 2;
                userObj.setCoins(updateCoinSession);
                session.setAttribute("theUser",userObj );
                }
                
                UserDB.updateCoins(usr);
                TempUserDB.deleteTempUser(token_recommendation);//check
                url="/login.jsp";
            }
       
            
            //if there are no errors
            if(!UserDB.emailExists(email))
            {
                // checking password strength
            if (password.equals(cpassword) && PasswordUtil.checkPasswordStrength(password))
            {
                
               
                /*//creates a user bean for the user
                User newuser=  new User(email,name);
                UserDB.addCredentials(email, password);
                UserDB.addUser(newuser);
                session.setAttribute("theUser", newuser);
                
                // dispatches to main.jsp
                url="/main.jsp";
                        
                        
                        */
                
                /*
                 try {
            hashedPassword = PasswordUtil.hashPassword(password);
            salt = PasswordUtil.getSalt();
            saltedAndHashedPassword = PasswordUtil.hashAndSaltPassword(password);                    
            
        } catch (NoSuchAlgorithmException ex) {
            hashedPassword = ex.getMessage();
            saltedAndHashedPassword = ex.getMessage();
        }
                */
  
                // generating salt for the password
                
                String salt=PasswordUtil.getSalt();
                
                
                //hashing password+Salt
                
                String hashedPasswordSalt =PasswordUtil.hashPasswordSalt(password+salt);
              
                //Generates a unique Token
                UUID id = UUID.randomUUID();
                String token=id.toString();
                System.out.println("Token is " +id);
                
                //cretes a TempUser bean for the temporary user
                TempUser tempuser=new TempUser(name,hashedPasswordSalt,email,token,salt);
                
                // adds the tempuser and token to temuser table in DB
                
                TempUserDB.addTempUser(tempuser);
                
                // send email with activation link
                
                MainClass e= new MainClass();
                e.sendEmailActivation(email, token);
                request.setAttribute("msg", "Check your email for activation link");
                
                url="/login.jsp";
              
            }
            // if there is an error
            else
            {
                // adds the error message to http request object
                String err="SIGNUP FAILED-password should match the confirm password, should be more than 3 characters in length";
                request.setAttribute("msg", err);
                // dispatches to signup.jsp
                url="/signup.jsp";
                
            }
            }
            else
            {
                String err="SIGNUP FAILED-EMAIL ALREADY EXISTS";
                request.setAttribute("msg", err);
                // dispatches to signup.jsp
                url="/signup.jsp";
            }
       
            
       }
       
       else if(action.equals("forgotPassword"))
       {
                String e = request.getParameter("email");
                UUID id = UUID.randomUUID();
                String t=id.toString();
                long retryDate = System.currentTimeMillis();
                int sec = 300;
                Timestamp original = new Timestamp(retryDate);
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(original.getTime());
                cal.add(Calendar.SECOND, sec);
                Timestamp later = new Timestamp(cal.getTime().getTime());
                TempUser tempuser=new TempUser(e,t,later);
                tempuser.setExpiryDate(later);
                              
                if(UserDB.emailExists(e))
                {
                TempUserDB.addTempUser(tempuser); //check
                MainClass forgot= new MainClass();
                forgot.forgotPassword(e, t); 
                request.setAttribute("msg", "Check your email for resetting the password");               
                url="/login.jsp";
                }      
                else
                {
                request.setAttribute("msg", "Invalid email");               
                url="/forgotPassword.jsp";
                }
       }
       
        else if(action.equals("resetPassword"))
       {
           
           String e = request.getParameter("email");
           String token = request.getParameter("token");
           String newPassword = request.getParameter("newPassword");
           
            //validate the token is present in db or not
            
             if(TempUserDB.tokenExists(token))
            {
                TempUser usr = TempUserDB.getTempUser(token);
                //check expiry
                System.out.println("latest expiry is" + usr.getExpiryDate());
                Timestamp exp = usr.getExpiryDate();
                long retryDate = System.currentTimeMillis();
                Timestamp original = new Timestamp(retryDate);
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(original.getTime());
                System.out.println("latest current time" + original);
                request.setAttribute("usr", usr);
                if(original.before(exp))
                {
                    System.out.println("not expired");
                    String salt=PasswordUtil.getSalt();
                    String hashedPasswordSalt =PasswordUtil.hashPasswordSalt(newPassword+salt);
                    System.out.println("salt is" + salt + "hashedPasswordSalt" + hashedPasswordSalt);
                    UserDB.updateCredentials(e, hashedPasswordSalt, salt);
                    request.setAttribute("msg", "Password Reset successfully");
                    url = "/login.jsp";
                    
                }
                else
                {
                    System.out.println("expired");
                    String err="Token Expired";
                    request.setAttribute("msg", err);
                    url="/login.jsp";
                }
                 
            }
           TempUserDB.deleteTempUser(token);  //check
       } 
      
       
        // forward request and response objects to specified URL
       getServletContext().getRequestDispatcher(url).forward(request, response);
    }
        catch(Exception e)
        {
            System.out.println("User not valid" + e);
        }
       
    }
        
    }
    
    


