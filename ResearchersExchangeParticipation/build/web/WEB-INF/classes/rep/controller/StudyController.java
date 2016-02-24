/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rep.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import rep.model.User;
import rep.model.Study;
import rep.data.StudyDB;
import rep.data.AnswerDB;
import rep.data.UserDB;
import rep.model.Answer;




public class StudyController extends HttpServlet {
    
     StudyDB obj = new StudyDB();
     UserDB userObj = new UserDB();
     AnswerDB ansdb = new AnswerDB();
     
     
    
       int count=0;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudyController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudyController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        String url ="";
        response.setContentType("text/html");
        String action = request.getParameter("action");
        PrintWriter out = response.getWriter();   
        HttpSession session = request.getSession();
               
        out.print(action);      
        if(action == null)
        {
            User UserObj = (User)session.getAttribute("theUser");
            if(UserObj != null)
            {
                out.print("object is not  null");
                url = "/main.jsp";
                out.print("url is" + url);
            }
            else
            {
                out.print("object is null");
                url = "/home.jsp";
            }
        }
        //   -----------------------------Participate -----------------------------
        
       
         else if (action.equalsIgnoreCase("Participate"))
        {  
           out.print("inside GET");
           List<Study> allStudies=  obj.getAllStudies("start");
           out.print("size is "+allStudies.size());
           if(allStudies.size() > 0)
           {
            request.setAttribute("allStudies", allStudies);
           }
           else
           {
               request.setAttribute("allStudies", null);
           }
           
                 url = ("/participate.jsp"); 
        }
         
        // ---------------------------MyStudies-----------------------------------
         
          else if (action.equalsIgnoreCase("studies"))
        {  
             User UserObj = (User)session.getAttribute("theUser");
             if(UserObj != null)
             {
             String email=UserObj.getEmail();
             
            out.print("inside GET in studies"+email);
           List<Study> allStudies1=  obj.getStudies(email);
           out.print("inside studies in my studies"+allStudies1.size());
           if(allStudies1.size() > 0)
           {
            request.setAttribute("newStudy", allStudies1);
           }
           else
           {
               request.setAttribute("newStudy", null);
           }
             url = ("/studies.jsp"); 
               }
             else
             {
              url = ("/login.jsp");
             }
        }
         
        // ------------------------edit -----------------------------------------
        else if (action.equalsIgnoreCase("edit"))
        {
           out.println("Action is" + action);
           User UserObj_edit = (User)session.getAttribute("theUser");
           String email = UserObj_edit.getEmail();
             if(UserObj_edit != null)
             {                
                 String code = request.getParameter("studyCode");
                 out.println("In edit Code is" + code + "email is" + email);   
                 
                 Study s = obj.getStudy(code, email);
                 out.println("data in new object" + s.getName() + s.getEmail() + s.getCode());
                 request.setAttribute("study", s);
                 
                 url = ("/editstudy.jsp"); 
                
             }
             else
             {
                 url = ("/login.jsp");
             }   
        }
       
        
        //------------------Start------------------------
        
        else if (action.equalsIgnoreCase("start"))
        {   
             out.print("Action is" + action);
             
             User UserObj_start = (User)session.getAttribute("theUser");
             String email = UserObj_start.getEmail();
             if(UserObj_start!= null)
             {   
                 String code = request.getParameter("studyCode");
                 Study s = obj.getStudy(code);  
                 if(s != null)
                 {
                 obj.updateStatus(s, "start");               
                 List<Study> newStudies = obj.getStudies(email);
                 request.setAttribute("newStudy", newStudies);

                url = ("/studies.jsp");
                 }
             }
             
        }
        //--------------------------------------stop-------------------------------
        else if (action.equalsIgnoreCase("stop"))
        {   out.print("Action is" + action);
             
             User UserObj_stop = (User)session.getAttribute("theUser");
             String email = UserObj_stop.getEmail();
             if(UserObj_stop!= null)
             {   
                 String code = request.getParameter("studyCode");
                 out.print("Code in stop is " + code);  
                 Study s = obj.getStudy(code);           
                 if(s != null)               
                 {
                 obj.updateStatus(s, "stop");
                 List<Study> newStudies = obj.getStudies(email);
                 request.setAttribute("newStudy", newStudies);
                 url = ("/studies.jsp"); 
                 }
             }            
             }  
        
        getServletContext().getRequestDispatcher(url).forward(request, response); 
       
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
         String url ="";
        response.setContentType("text/html");
        String action= request.getParameter("action");
        PrintWriter out = response.getWriter();   
        HttpSession session = request.getSession();
        //----------------------------Participate-------------------
        if (action.equalsIgnoreCase("Participate"))
        {             
            out.print("Action is" + action);
            User UserObj_participate = (User)session.getAttribute("theUser");
            if(UserObj_participate != null)
            {
                String code = request.getParameter("studycode");
                out.print("Code is" + code);
                if (code == null)
                {
                 List<Study> allStudies=  obj.getAllStudies();                
                out.print("size is "+allStudies.size());
                request.setAttribute("allStudies", allStudies);
                 url = ("/participate.jsp");
                }
                else
                {
                 
                 Study study=obj.getStudy(code);
                 request.setAttribute("study", study);
                  out.print("inside participate"+study.getQuestion());
                 url = ("/question.jsp");
                }
            }
            else
            {
                url = ("/login.jsp");
            }           
        }
        
        
         
       // -------------------------------------add--------------------------
        
           else if (action.equalsIgnoreCase("add"))
        {  
             out.print("Action is" + action); 
             System.out.println("Action is" + action); 
             User UserObj_add = (User)session.getAttribute("theUser");
             String email = UserObj_add.getEmail(); 
             if(UserObj_add != null)
             { 
                 count=UserObj_add.getParticipants();
                 count++;
                 out.print("object not null");
                 String name = request.getParameter("study_name");
                 String question = request.getParameter("question_text");
                 int requestedParticipants = Integer.parseInt(request.getParameter("no_of_participants"));
                 String description = request.getParameter("desc");
                 String code = request.getParameter("studyCode");
                 String status = request.getParameter("status");
                 out.print(name + question + requestedParticipants + description);  
                 UserObj_add.setParticipants(count);
                 UserDB.updateUserStudies(UserObj_add);// updating in DB
                 Study study = new Study(code,name,email,question,requestedParticipants,description,status);
                 out.print("After creating object");
                 out.print(study.getName() + study.getCode()+ study.getQuestion() + study.getRequestedParticipants() + study.getDescription() +study.getStatus());                  
                 obj.putStudies(study);
                 List<Study> newStudies = obj.getStudies(email);
                 request.setAttribute("newStudy", newStudies);                         
                 url = ("/studies.jsp");
             }
             else
             { 
                 out.print("object is null");
                 url = ("/login.jsp");
             }         
        }
        
        /// Add done
        
         // --------------------------Update-----------------------
        else if (action.equalsIgnoreCase("update"))
        {
             out.print("Action is" + action);             
             String code = request.getParameter("studyCode");
             out.print("Code is" + code);
             User UserObj_update = (User)session.getAttribute("theUser");
             String email = UserObj_update.getEmail();
             if(UserObj_update!= null)
             {                                 
                 String name = request.getParameter("study_name");
                 String question = request.getParameter("question_text");
                 int requestedParticipants = Integer.parseInt(request.getParameter("no_of_participants"));
                 String description = request.getParameter("desc");
                 Study study = obj.getStudy(code);
                 out.print("/////Before update///" +study.getName() + study.getQuestion() + study.getNumOfParticipants() + study.getDescription()+ study.getCode());
                 obj.updateRecord(code,name,question,requestedParticipants,description);
                 out.print("/////After update///" +study.getName() + study.getQuestion() + study.getNumOfParticipants() + study.getDescription()+ study.getCode());
                 List<Study> newStudies = obj.getStudies(email);
                 out.println("size of list in update is" + newStudies.size());
                 request.setAttribute("newStudy", newStudies);
                 url = ("/studies.jsp");                 
             }       
             else{
                 url = ("/login.jsp");
             }        
        }
        
      // ---------------------------------answer ------------------
        if (action.equalsIgnoreCase("answer"))
        {   
           int coins;
           int participation; 
           int numOfParticipants;
           Answer ans = new Answer() ;
           String code = request.getParameter("studycode");
           int choice = Integer.parseInt(request.getParameter("choice"));
            
           out.print("Action is" + action);
           User UserObj_participate = (User)session.getAttribute("theUser");
           String email=UserObj_participate.getEmail();
            if(UserObj_participate != null)
            {
                
               
                out.print("Code is" + code);
                if (code != null )
                {                   
                        ans.setChoice(choice);
                        ans.setEmail(email);
                        ans.setSCode(code);
                        
                        if(!AnswerDB.answerExists(email, code))
                            
                        {
                            out.print("ANSWER DOES NOT EXISTS");
                        ansdb.addAnswer(ans);
                        //Insert code for updating coin and participation in DB
                        coins=UserObj_participate.getCoins();
                        participation = UserObj_participate.getParticipation();
                        participation++;
                        coins++;                     
                       // UserObj_participate.setCoins(coins);
                      //  UserDB.updateParticipations(UserObj_participate);
                      //  UserDB.updateCoins(UserObj_participate);  
                        email=UserObj_participate.getEmail();
                        Study study = obj.getStudy(code);
                        numOfParticipants = study.getNumOfParticipants();
                        numOfParticipants++;
                        study.setNumOfParticipants(numOfParticipants);
                        UserObj_participate.setCoins(coins);
                        UserObj_participate.setParticipation(participation);  
                        obj.updateActParticipants(code, numOfParticipants);
                        
                        
                        
                        UserDB.updateParticipations(UserObj_participate);
                        UserDB.updateCoins(UserObj_participate); 
                        
                        List list = obj.getAllStudies("start");
                        request.setAttribute("allStudies", list);
                        url= ("/participate.jsp");    
                }
                        else
                        {
                            
                            out.print("ANSWER EXISTS");
                            System.out.println("You have already given answ");
                            request.setAttribute("duplicateanswer", "duplicateanswer");
                            List list = obj.getAllStudies("start");
                            request.setAttribute("allStudies", list);
                            url=("/participate.jsp");
                        }
                }  
            
               
                
                    }
            else
            {
                url = ("/login.jsp");
            }          
        }
        
          getServletContext().getRequestDispatcher(url).forward(request, response);      
    }
   
    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }// </editor-fold>

   
}
