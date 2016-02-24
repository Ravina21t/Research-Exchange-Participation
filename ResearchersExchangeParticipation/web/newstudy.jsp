
<%@include file="header.jsp"%>

<h3 class="h3_label"><b>Adding a study</b></h3>
<div class="confirmc">
    <a href="main.jsp"> <h4>Back to main page </h4> </a>
</div>

<div class="container">

    <form action="StudyController" method="post">
        <label class="label-signup" for="study_name">Study Name*</label>
        <input id="study_name" type="text" name="study_name" value="" required/><br>
        <br>

        <label class="label-signup" for="question_text">Question Text*</label>
        <input id="question_text" type="text" name="question_text" value="" required/><br>
        <br>

        <label class="label-signup">Image*</label>
        <input id="file-input" type="file" name="file"> <br><br>

        <label class="label-signup" for="no_of_participants"># of participants*</label>
        <input id="no_of_participants" type="text" name="no_of_participants" value="" required/><br>
        <br>

        <label class="label-signup" for="desc">Description*</label>
        <input class="big" id="desc" type="text" name="desc" value="" required/><br>
        <br>

        <input id="submit" type="submit" name="button" value="Submit" />
        <input type="hidden" name="action" value="add">
        <input type="hidden" name="studyCode" value="Study Code">
        <input type="hidden" name="status" value="start">

    </form> 
</div>

<footer>
    <%@include file="footer.jsp"%>
</footer>

</html>

