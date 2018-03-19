<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Regist Page</title>

    <!-- Bootstrap -->
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
  
  <div class="container"  style="margin-top: 50px;">
   <form class="form-signin" action="${pageContext.request.contextPath}/signUp/regist/submit" method="post">
    <div class="input-group" style="margin-top: 20px;">
	  <span class="input-group-addon" id="basic-addon1">Login Name</span>
	  <input id="loginName" name="loginName" type="text" class="form-control" placeholder="Login Name" aria-describedby="basic-addon1" required>
	</div>
	
	<div class="input-group" style="margin-top: 20px;">
	  <span class="input-group-addon" id="basic-addon2">Password</span>
	  <input id="password" name="password" type="text" class="form-control" placeholder="Password" aria-describedby="basic-addon2" required>
	</div>
	
	<div class="input-group" style="margin-top: 20px;">
	  <span class="input-group-addon" id="basic-addon3">Login Name</span>
	  <input id="name" name="name" type="text" class="form-control" placeholder="Name" aria-describedby="basic-addon3">
	</div>
	<button id="loginSubmit" class="btn btn-lg btn-primary btn-block" type="submit" style="width: 50%;margin-left:auto;margin-right:auto;margin-top: 20px;" >Submit</button>
   </form>
  </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=basePath%>js/jquery-3.3.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
  </body>
</html>
