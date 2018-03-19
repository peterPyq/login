<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Conference Edit Page</title>

    <!-- Bootstrap -->
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
  
  <div class="container"  style="margin-top: 50px;">
  
  <c:choose>
   <c:when test="${not empty entity}">  
   	
   	<form class="form-signin" action="${pageContext.request.contextPath}/conference/${entity.conferenceID}/update" method="post">
    <input id="conferenceID" name="conferenceID" type="hidden" value="${entity.conferenceID}"/>
    
    <div class="input-group" style="margin-top: 20px;">
	  <span class="input-group-addon" id="basic-addon1">ConferenceName</span>
	  <input id="conferenceName" name="conferenceName" type="text" class="form-control" aria-describedby="basic-addon1" required value="${entity.conferenceName}"/>
	</div>
	
	<div class="input-group" style="margin-top: 20px;">
	  <span class="input-group-addon" id="basic-addon2">ChineseConferenceLocation</span>
	  <input id="chineseConferenceLocation" name="chineseConferenceLocation" type="text" class="form-control" aria-describedby="basic-addon2" required value="${entity.chineseConferenceLocation}"/>
	</div>
	
	<div class="input-group" style="margin-top: 20px;">
	  <span class="input-group-addon" id="basic-addon3">ConferenceType</span>
	  <input id="conferenceType" name="conferenceType" type="text" class="form-control" readonly aria-describedby="basic-addon3" required value="${entity.conferenceType}"/>
	</div>
	
	<div class="input-group" style="margin-top: 20px;">
	  <span class="input-group-addon" id="basic-addon4">ConferenceBeginningDateTime</span>
	  
	  <input id="conferenceBeginningDateTime" name="conferenceBeginningDateTime" type="text" class="form-control" aria-describedby="basic-addon4" value="${entity.conferenceBeginningDateTime}"/>
	</div>
	
	<div class="input-group" style="margin-top: 20px;">
	  <span class="input-group-addon" id="basic-addon5">ConferenceEndingDateTime</span>
	 
	  <input id="conferenceEndingDateTime" name="conferenceEndingDateTime" type="text" class="form-control" aria-describedby="basic-addon5" value="${entity.conferenceEndingDateTime}"/>
	</div>
	
	<button id="loginSubmit" class="btn btn-lg btn-primary btn-block" type="submit" style="width: 50%;margin-left:auto;margin-right:auto;margin-top: 20px;" >Submit</button>
   </form>

   </c:when>
   
   <c:otherwise> 
      <form class="form-signin" action="${pageContext.request.contextPath}/conference/insert" method="post">
    <div class="input-group" style="margin-top: 20px;">
	  <span class="input-group-addon" id="basic-addon1">ConferenceName</span>
	  <input id="conferenceName" name="conferenceName" type="text" class="form-control" aria-describedby="basic-addon1" required/>
	</div>
	
	<div class="input-group" style="margin-top: 20px;">
	  <span class="input-group-addon" id="basic-addon2">ChineseConferenceLocation</span>
	  <input id="chineseConferenceLocation" name="chineseConferenceLocation" type="text" class="form-control" aria-describedby="basic-addon2" required/>
	</div>
	
	<div class="input-group" style="margin-top: 20px;">
	  <span class="input-group-addon" id="basic-addon3">ConferenceType</span>
	  <input id="conferenceType" readonly name="conferenceType" type="text" class="form-control" aria-describedby="basic-addon3" value="${conferenceType}"/>
	</div>
	
	<div class="input-group" style="margin-top: 20px;">
	  <span class="input-group-addon" id="basic-addon4">ConferenceBeginningDateTime</span>
	  <input id="conferenceBeginningDateTime" name="conferenceBeginningDateTime" type="text" class="form-control" aria-describedby="basic-addon4" required/>
	</div>
	
	<div class="input-group" style="margin-top: 20px;">
	  <span class="input-group-addon" id="basic-addon5">ConferenceEndingDateTime</span>
	  <input id="conferenceEndingDateTime" name="conferenceEndingDateTime" type="text" class="form-control" aria-describedby="basic-addon5" required/>
	</div>
	
	<button id="loginSubmit" class="btn btn-lg btn-primary btn-block" type="submit" style="width: 50%;margin-left:auto;margin-right:auto;margin-top: 20px;" >Submit</button>
   </form>
   
   </c:otherwise>
</c:choose>
  
  
   
   
  </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=basePath%>js/jquery-3.3.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
  </body>
</html>
