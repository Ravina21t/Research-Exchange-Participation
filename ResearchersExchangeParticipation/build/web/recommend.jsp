
<%@include file="header.jsp"%>

<h3 class="h3_label"><b>Recommend to a friend</b></h3>
<div class="confirmc">
    <a href="main.jsp"> <h4>Back to main page </h4> </a>
</div>

<div class="container">

    <form action="EmailController" method="get">
        <input type="hidden" name="action" value="recommendemail"/> 
        <label class="label-signup" for="name"> Name*</label>
        <input id="name" type="text" name="name" value="" required/><br>
        <br>

        <label class="label-signup" for="email">Email*</label>
        <input id="email" type="email" name="email" value="" required/><br>
        <br>

        <label class="label-signup" for="friendemail">Friend's Email*</label>
        <input id="friendemail" type="email" name="friendemail" value="" required/><br>
        <br>

        <label class="label-signup-big" for="message">Message*</label>
        <input class="big" id="message" type="text" name="message" value="" required/><br>
        <br>

         
        <input id="button" type="submit" name="button" value="Submit" />


    </form>

    <p><b> When your friend logs in and participates in one user study,you'll get 2 bonus points</b></p>
</div>

<footer>
    <%@include file="footer.jsp"%>
</footer>

</html>

