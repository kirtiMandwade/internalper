<!DOCTYPE html>
<html lang="en" >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<script type="text/javascript">
function validate() {
    if (document.f.j_username.value == "" && document.f.j_password.value == "") {
        alert("Username and password are required");
        document.f.j_username.focus();
        return false;
    }
    if (document.f.j_username.value == "") {
        alert("Username is required");
        document.f.j_username.focus();
        return false;
    }
    if (document.f.j_password.value == "") {
    alert("Password is required");
    document.f.j_password.focus();
        return false;
    }
}
</script>
  <meta charset="UTF-8">
  <title>Admin Portal</title>
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

      

  <link rel="stylesheet"
	href="/adminportal/resources/css/styleforlogin.css">

</head>

<body onload='document.f.j_username.focus();'>


<!-- Form Mixin-->
<!-- Input Mixin-->
<!-- Button Mixin-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>Admin Portal</h1><!-- <span>Pen <i class='fa fa-paint-brush'></i> + <i class='fa fa-code'></i> by <a href='http://andytran.me'>Andy Tran</a></span> -->
</div>
<!-- Form Module-->
<div class="module form-module">
  <div class="toggle"><i class="fa fa-times fa-pencil"></i>
    <div class="tooltip">Click Me</div>
  </div>
  <div class="form">
 		<c:if test="${param.error == 'true'}">
    <h1><span>Bad Credentials</span></h1>
</c:if><br><br>
 	 
    <h2>Login to your account</h2>
    <form name='f' action='/adminportal/j_spring_security_check'
		method='POST'>
      <input type="text" placeholder="Username" name='j_username' value=''/>
      <input type="password" placeholder="Password" name='j_password'/>
      <button onclick="return validate();">Login</button>
    </form>
  </div>
  <div class="form">
    <h2>Create an account</h2>
    <form>
      <input type="text" placeholder="Username"/>
      <input type="password" placeholder="Password"/>
      <input type="email" placeholder="Email Address"/>
      <input type="tel" placeholder="Phone Number"/>
      <button>Register</button>
    </form>
  </div>
  <!-- <div class="cta"><a href="http://">Forgot your password?</a></div> -->
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>


  



<script src="/adminportal/resources/js/index.js"></script>


</body>

</html>
