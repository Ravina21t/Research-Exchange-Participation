  
<%@include file="header.jsp"%>

<div class="section">
    ${msg}
    <form action="UserController" method="post">

        <input type="hidden" name="action" value="resetPassword"> 
        <input type="hidden" name="token" value="${usr.getToken()}">
        <label class="label-signup" for="email">e-mail*</label> 
        <input id="email" type="email" name="email" readonly="readonly" value="${usr.getEmail()}" required/><br>
        <br>
        <label class="label-signup" for="email">Reset Password*</label>
        <input id="newPassword" type="password" name="newPassword" value="" required/><br>
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