        
<%@include file="header.jsp"%>

<div class="section">
    ${msg}
    <form action="UserController" method="post">

        <input type="hidden" name="action" value="create">
         <input type="hidden" name="token" value="${token}">
        <label class="label-signup" for="name">Name*</label>
        <input id="name" type="text" name="name" value="" required/><br>
        <br>
        <label class="label-signup" for="email">Email Address*</label>
        <input id="email" type="email" name="email" value="" required/><br>
        <br><!--Add value/EL to retain initial value-->
        <label class="label-signup" for="password">Password*</label>
        <input id="password" type="password" name="password" value="" required/><br>
        <br>
        <label class="label-signup" for="password">Confirm Password*</label>
        <input id="cpassword" type="password" name="cpassword" value="" required/><br>
        <br>
        <label class="label-signup" for="submit"></label>
        <br>
        <input id="submit" type="submit" name="button" value="Create Account" />
    </form>
</div>   
<footer>
    <%@include file="footer.jsp"%>
</footer>
</html>