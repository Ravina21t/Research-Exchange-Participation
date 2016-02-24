
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="rep.model.Study"%>
<%@include file="header.jsp"%>
<script src="js/javascript.js"></script>
<h3 class="h3_label"><b>My Studies </b></h3>
<p><a href="newstudy.jsp" >Add a new Study</a></p>
<a href="main.jsp"> <h4>Back to main page </h4> </a>


<div class="studies">
    <form action="StudyController" method="get">
        <table class="table_participate">
            
            <c:if test="${requestScope.newStudy != null}">
            
                    <tr class="table_participate">
                    <th><b> Study Name</b></th>   
                    <th><b> Requested participants</b></th> 
                    <th><b> Participations</b></th> 
                    <th><b> Status </b></th>
                    <th><b> Action</b></th> 
            </tr>
            
                <c:forEach var="asd" items="${requestScope.newStudy}">            
             <tr>            
                <td class="td_participate_odd"><b><c:out value="${asd.name}"/></b></td> 
                <td class="td_participate_odd" > <c:out value="${asd.requestedParticipants}"/> <b></b></td>
                <td class="td_participate_odd"><b> <c:out value="${asd.numOfParticipants}"/></b></td>
                <td class="td_participate_odd"><input onclick="getCode(<c:out value="${asd.code}"/>)" class="part_button" name="action" type="submit" value ="<c:if test="${asd.status == 'start'}"><c:out value="stop"/></c:if><c:if test="${asd.status == 'stop'}"><c:out value="start"/></c:if>"/>           
                </td> 
                <td class="td_participate_odd"><input onclick="getCode(<c:out value="${asd.code}"/>)" class="part_button" type="submit" name="action" value="edit" /></td> 
                            
            </tr>
           
                 </c:forEach>  
                
              </c:if>  
          
            <c:if test="${requestScope.newStudy == null}"><c:out value="no entries found"/></c:if>
            
            
                
                               
              </table>
                
                 <input type="hidden" id="code" name="studyCode" >            
    </form>
       
</div>

<footer>
    <%@include file="footer.jsp"%>
</footer>

</html>
