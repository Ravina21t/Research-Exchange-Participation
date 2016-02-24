  
<%@include file="header.jsp"%>

<div class="section">
    ${msg}
    <form action="UserController" method="post">

        <input type="hidden" name="action" value="forgotPassword"> 
        <label class="label-signup" for="email">Please enter your registered e-mail*</label>
        <input id="email" type="email" name="email" value="" required/><br>
        <br>
        <label class="label-signup" for="login"></label>
        <br>
        <input id="login" type="submit" name="button" value="Submit" />
        <br><br>

    </form>
</div>   
<footer>
    <%@include file="footer.jsp"%>
</footer>
</html>