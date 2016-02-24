
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rep.model.Study"%>
<%@include file="header.jsp"%>
<script src="js/javascript.js"></script>

<div class="aboutl_table">
    <%@include file="navigation.jsp"%>
</div>

 <form action="StudyController" method="post">
<h4 class="h4_label">Studies</h4>

<div class="studies">

    <c:if test="${requestScope.allStudies != null}">
  

    <table class="table_participate">
        <tr class="table_participate">
            <th><b> Study Name</b></th>   
            <th><b> Image</b></th> 
            <th><b> Question</b></th> 
            <th><b> Action</b></th> 
        </tr>

        <c:forEach var="asd" items="${requestScope.allStudies}">   
         
            
            <tr>
                
                <td class="td_participate_odd"><b><c:out value="${asd.name}"/></b></td> 
                <td class="td_participate_odd" > <img src="images/tree.png" alt="tree" height="42" width="92"  ><b></b></td>
                <td class="td_participate_odd"><b><c:out value="${asd.question}"/></b></td>
                <td class="td_participate_odd"><input onclick="getCode(<c:out value="${asd.code}"/>)" class="part_button" type="submit" name="action" value="Participate" />
                
                </td>                       

            </tr>

                 </c:forEach>  
                
              </c:if>  
                   
           <c:if test="${requestScope.allStudies == null}"><c:out value="no entries found"/></c:if>      

           
        
    </table>
 
        <input id="code" type="hidden"  name="studycode" />
        
</div>
         
 </form>

        
        
<footer>
    <%@include file="footer.jsp"%>
</footer>


 <c:if test="${not empty duplicateanswer}">
              
                    <script>
                      
                       alert("You have already submitted answer to that question-Please select a new study to participate");
                        
                        </script>

            </c:if>
        


</html>
