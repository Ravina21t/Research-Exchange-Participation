
<%@include file="header.jsp"%>

<h3 class="h3_label"><b>Contact</b></h3>
<div class="confirmc">
    <a href="main.jsp"> <h4>Back to main page </h4> </a>
</div>

<div class="container">

    <form action ="EmailController" method="get">
        <input type="hidden" name="action" value="contactemail"/> 
        
        <label class="label-signup" for="name"> Name*</label>
        <input id="name" type="text" name="name" value="" required/><br>
        <br>

        <label class="label-signup" for="email">Email*</label>
        <input id="email" type="email" name="email" value="" required/><br>
        <br>

        <label class="label-signup" for="message">Message*</label>
        <input class="big" id="message" type="text" name="message" value="" required/><br>
        <br>

        <input id="submit" type="submit" name="button" value="Submit" />
    </form> 

</div>

<footer>
    <%@include file="footer.jsp"%>
</footer>

</html>

