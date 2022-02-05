<%@ page isELIgnored = "false"  session="false" %>
<!DOCTYPE html>
<!-- Designined by CodingLab - youtube.com/codinglabyt -->
<html lang="en" dir="ltr">
<head>
    <title> Costaff | Login </title>
	<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <link rel="stylesheet" href="css/login.css">
	<script src="js/script.js"></script>
</head>
<body>

<div class="container" id="container">
	<div class="form-container sign-up-container">
		<form action="#">
			<h1>Create Account</h1>
			<div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div>
			<span>or use your email for registration</span>
			<input type="text" placeholder="Name" />
			<input type="email" placeholder="Email" />
			<input type="password" placeholder="Password" />
			<button>Sign Up</button>
		</form>
	</div>
	<div class="form-container sign-in-container">
		<form action="login" name="loginForm" id="loginForm" method="POST" onsubmit="return validateLogin()">
			<h1>Sign in</h1>
			<div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div>
			<span>or use your account</span>
			<span class="error">${message}</span>
			<input type="email" name="userName" title="UserName is required" placeholder="Email" required />
			<input type="password"  name="password" title="Password is required" placeholder="Password" required/>
			<a href="#">Forgot your password?</a>
			<input type="submit" value="Sign In"/>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>Welcome Back!</h1>
				<p>To keep connected with us please login with your personal info</p>
				<button class="ghost" id="signIn">Sign In</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1><img src="http://costaffglobal.com/includefiles/assets/images/costaff_logo.png" width="400px"/></h1>
				<p>Enter your personal details and start journey with us</p>
				<button class="ghost" id="signUp"><a href="register.html">Sign Up</a></button>
			</div>
		</div>
	</div>
</div>
<body>
</html>