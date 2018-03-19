<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="">

    <title>Signin</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=basePath%>css/signin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="${pageContext.request.contextPath}/signUp/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="loginName" class="sr-only">Login Name</label>
        <input type="text" id="loginName" name="loginName" class="form-control" placeholder="Login Name" required autofocus>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label style="margin-right: 125px;">
            <input type="checkbox" value="remember-me"> Remember me 
          </label>
          <a style="color:red" id="registButton" class="btn btn-sm btn-default" href="${pageContext.request.contextPath}/signUp/regist" role="button">Regist</a>
        </div>
        <button id="loginSubmit" class="btn btn-lg btn-primary btn-block" type="submit" >Sign in</button>
        
      </form>
	
    </div> <!-- /container -->
    
  </body>
</html>
