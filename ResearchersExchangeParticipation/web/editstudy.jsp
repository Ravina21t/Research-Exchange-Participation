
<%@include file="header.jsp"%>

<h3 class="h3_label"><b>Editing a study</b></h3>
<div class="confirmc">
    <a href="main.jsp"> <h4>Back to main page </h4> </a>
</div>

<div class="container">

    <form action="StudyController" method="post">
        <label class="label-signup" for="study_name">Study Name*</label>
        <input id="study_name" type="text" name="study_name" value="${study.getName()}" required/><br>
        <br>

        <label class="label-signup" for="question_text">Question Text*</label>
        <input id="question_text" type="text" name="question_text" value="${study.getQuestion()}" required/><br>
        <br>

        <label class="label-signup" for="file">Image*</label>
        <input id="file" type="file" name="file"> <br><br>

        <label class="label-signup" for="no_of_participants"># of participants*</label>
        <input id="no_of_participants" type="text" name="no_of_participants" value="${study.getRequestedParticipants()}" required/><br>
        <br>

        <label class="label-signup" for="desc">Description*</label>
        <input class="big" id="desc" type="text" name="desc" value="${study.getDescription()}" required/><br>
        <br>


        <input id="submit" type="submit" name="button" value="Update" />
        <input type="hidden" name="action" value="update"> 
        <input type="hidden" name="studyCode" value="${study.getCode()}">

    </form>  
</div>

<footer>
    <%@include file="footer.jsp"%>
</footer>

</html>

