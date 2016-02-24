  
<%@include file="header.jsp"%>

<div class="section">
    ${msg}
    <form action="UserController" method="post">

        <input type="hidden" name="action" value="login"> 
        <label class="label-signup" for="email">Email*</label>
        <input id="email" type="email" name="email" value="" required/><br>
        <br>
        <label class="label-signup" for="password">Password*</label>
        <input id="password" type="password" name="password" value="" required/><br>
        <br><!--Add value/EL to retain initial value-->

        <label class="label-signup" for="login"></label>
        <br>
        <input id="login" type="submit" name="button" value="Log In" />
        <br><br>
        <p>
            <a href="signup.jsp">Sign up for a new account</a>
        </p>
        <p>
            <a href="forgotPassword.jsp">Forgot password</a>
        </p>

    </form>
</div>   
<footer>
    <%@include file="footer.jsp"%>
</footer>
</html>