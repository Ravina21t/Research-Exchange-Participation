
<%@include file="header.jsp"%>

<div class="aboutl_table">
    <%@include file="navigation.jsp"%>
</div>


<h4 class="h4_label">Question</h4>

<div class="studies">
    <form action="StudyController" method="post">
        <img src="images/tree.png"  alt="tree">
        <p>${study.getQuestion()}</p>

        <span>
            <select name="choice">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
            </select>
        </span>
        &nbsp;&nbsp;
        <span>
            <input type="hidden" name="studycode" value="${study.getCode()}"> 
            <input type="hidden" name="action" value="answer"> 

            <input type="submit" value="Submit" name="submit" />

        </span>
            <div>${error_ans}</div>


    </form>
            
            
                         
         
</div>

<footer>
    <%@include file="footer.jsp"%>
</footer>

</html>
