<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Home Page</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=basePath%>css/navbar.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

      <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid" >
        
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Huiyi123</a>
          </div>
          
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#">News</a></li>
              <li><a href="#">Submission</a></li>
              <li><a href="#">Join US</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li class="active" ><a style="background-color: yellow;" href="#">SIGN UP<span class="sr-only">(current)</span></a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>

      <!-- Main component for a primary marketing message or call to action -->
   <div>
      <div class="jumbotron" style="width: 80%;height:350px ;float: left">
        <h1>Photo Change Area</h1>
        <p>
          <a class="btn btn-lg btn-primary" href="#" role="button">Link</a>
        </p>
      </div>
	  <div class="jumbotron" style="width: 20%;height:350px ;float: left;background-color:gray;">
        <ul>
        	<li><a href="#">News</a></li>
            <li><a href="#">Submission</a></li>
            <li><a href="#">Join US</a></li>
        </ul>
       </div>
   </div>

    <div >
       <h3>Recent Conference</h3>
       <div class="panel-body">
   			<table class="table table-hover">
   				<thead>
   					<tr>
   						<th>ConferenceName</th>
   						<th>ChineseConferenceLocation</th>
   						<!-- <th>ConferenceType</th> -->
   						<th>ConferenceBeginningDateTime</th>
   						<th>ConferenceEndingDateTime</th>
   						<th>CreatedDateTime</th>
   						<th>Action</th>
   					</tr>
   				</thead>
   				<tbody>
   				
   				<c:choose>
				   <c:when test="${not empty recenctConference}">  
	   				<c:forEach var="recentConference" items="${recenctConference}">
	   					<tr>
	   						<td>${recentConference.conferenceName}</td>
	   						<td>${recentConference.chineseConferenceLocation}</td>
	   						<%-- <td>${recentConference.conferenceType}</td> --%>
	   						<td>
	   							<fmt:formatDate value="${recentConference.conferenceBeginningDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	   						</td>
	   						<td>
	   							<fmt:formatDate value="${recentConference.conferenceEndingDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	   						</td>
	   						<td>
	   							<fmt:formatDate value="${recentConference.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	   						</td>
	   						<td>
	   							<a class="btn btn-info" href="${pageContext.request.contextPath}/conference/${recentConference.conferenceID}/edit" target="_blank">Update</a>
	   							<a class="btn btn-danger" href="${pageContext.request.contextPath}/conference/${recentConference.conferenceID}/delete" target="_blank">Delete</a>
	   						</td>
	   					</tr>
	   				</c:forEach>
				   </c:when>
				</c:choose>
				
   				</tbody>
   			</table>
   		</div>
    </div>

 	<div >
       <h3 style="width: 50%;float: left">SCIENCE_TYPE</h3>
       <a style="width: 10%;float: right" class="btn btn-info" href="${pageContext.request.contextPath}/conference/addNew/science" target="_blank">Add New</a>
       <div class="panel-body">
   			<table class="table table-hover">
   				<thead>
   					<tr>
   						<th>ConferenceName</th>
   						<th>ChineseConferenceLocation</th>
   						<th>ConferenceBeginningDateTime</th>
   						<th>ConferenceEndingDateTime</th>
   						<th>CreatedDateTime</th>
   						<th>Action</th>
   					</tr>
   				</thead>
   				<tbody>
   				
   				<c:choose>
				   <c:when test="${not empty scienceOfConference}">  
	   				<c:forEach var="scienceOfConference" items="${scienceOfConference}">
	   					<tr>
	   						<td>${scienceOfConference.conferenceName}</td>
	   						<td>${scienceOfConference.chineseConferenceLocation}</td>
	   						<td>
	   							<fmt:formatDate value="${scienceOfConference.conferenceBeginningDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	   						</td>
	   						<td>
	   							<fmt:formatDate value="${scienceOfConference.conferenceEndingDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	   						</td>
	   						<td>
	   							<fmt:formatDate value="${scienceOfConference.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	   						</td>
	   						<td>
	   							<a class="btn btn-info" href="${pageContext.request.contextPath}/conference/${scienceOfConference.conferenceID}/edit" target="_blank">Update</a>
	   							<a class="btn btn-danger" href="${pageContext.request.contextPath}/conference/${scienceOfConference.conferenceID}/delete" target="_blank">Delete</a>
	   						</td>
	   					</tr>
	   				</c:forEach>
				   </c:when>
				</c:choose>
				
   				</tbody>
   			</table>
   		</div>
    </div>

	<div >
       <h3 style="width: 50%;float: left">BIOLOGICAL_TYPE</h3>
       <a style="width: 10%;float: right" class="btn btn-info" href="${pageContext.request.contextPath}/conference/addNew/biological" target="_blank">Add New</a>
       <div class="panel-body">
   			<table class="table table-hover">
   				<thead>
   					<tr>
   						<th>ConferenceName</th>
   						<th>ChineseConferenceLocation</th>
   						<th>ConferenceBeginningDateTime</th>
   						<th>ConferenceEndingDateTime</th>
   						<th>CreatedDateTime</th>
   						<th>Action</th>
   					</tr>
   				</thead>
   				<tbody>
   				
   				<c:choose>
				   <c:when test="${not empty biologicalOfConference}">  
	   				<c:forEach var="biologicalOfConference" items="${biologicalOfConference}">
	   					<tr>
	   						<td>${biologicalOfConference.conferenceName}</td>
	   						<td>${biologicalOfConference.chineseConferenceLocation}</td>
	   						<td>
	   							<fmt:formatDate value="${biologicalOfConference.conferenceBeginningDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	   						</td>
	   						<td>
	   							<fmt:formatDate value="${biologicalOfConference.conferenceEndingDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	   						</td>
	   						<td>
	   							<fmt:formatDate value="${biologicalOfConference.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	   						</td>
	   						<td>
	   							<a class="btn btn-info" href="${pageContext.request.contextPath}/conference/${biologicalOfConference.conferenceID}/edit" target="_blank">Update</a>
	   							<a class="btn btn-danger" href="${pageContext.request.contextPath}/conference/${biologicalOfConference.conferenceID}/delete" target="_blank">Delete</a>
	   						</td>
	   					</tr>
	   				</c:forEach>
				   </c:when>
				</c:choose>
				
   				</tbody>
   			</table>
   		</div>
    </div>

	<div >
       <h3 style="width: 50%;float: left">MATH_TYPE</h3>
       <a style="width: 10%;float: right" class="btn btn-info" href="${pageContext.request.contextPath}/conference/addNew/math" target="_blank">Add New</a>
       <div class="panel-body">
   			<table class="table table-hover">
   				<thead>
   					<tr>
   						<th>ConferenceName</th>
   						<th>ChineseConferenceLocation</th>
   						<th>ConferenceBeginningDateTime</th>
   						<th>ConferenceEndingDateTime</th>
   						<th>CreatedDateTime</th>
   						<th>Action</th>
   					</tr>
   				</thead>
   				<tbody>
   				
   				<c:choose>
				   <c:when test="${not empty mathOfConference}">  
	   				<c:forEach var="mathOfConference" items="${mathOfConference}">
	   					<tr>
	   						<td>${mathOfConference.conferenceName}</td>
	   						<td>${mathOfConference.chineseConferenceLocation}</td>
	   						<td>
	   							<fmt:formatDate value="${mathOfConference.conferenceBeginningDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	   						</td>
	   						<td>
	   							<fmt:formatDate value="${mathOfConference.conferenceEndingDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	   						</td>
	   						<td>
	   							<fmt:formatDate value="${mathOfConference.createdDateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	   						</td>
	   						<td>
	   							<a class="btn btn-info" href="${pageContext.request.contextPath}/conference/${mathOfConference.conferenceID}/edit" target="_blank">Update</a>
	   							<a class="btn btn-danger" href="${pageContext.request.contextPath}/conference/${mathOfConference.conferenceID}/delete" target="_blank">Delete</a>
	   						</td>
	   					</tr>
	   				</c:forEach>
				   </c:when>
				</c:choose>
				
   				</tbody>
   			</table>
   		</div>
    </div>


    </div> <!-- /container -->


    <script src="<%=basePath%>js/jquery-3.3.1.min.js"></script>
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
  </body>
</html>

