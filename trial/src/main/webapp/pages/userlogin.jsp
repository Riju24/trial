<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<style>
#login .container #login-row #login-column #login-box {
  margin-top: 120px;
  max-width: 600px;
  height: 320px;
  border: 1px solid #9C9C9C;
  background-color: #EAEAEA;
}
#login .container #login-row #login-column #login-box #login-form {
  padding: 20px;
}
#login .container #login-row #login-column #login-box #login-form #register-link {
  margin-top: -85px;
}
</style>
</head>
<body>
<div id="login">
        <h3 class="text-center text-white pt-5">Login form</h3>
        <div class="container">
		<div class="alert alert-danger" role="alert">
  					${msg}
		</div>      
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        
                        <form:form action ="userlogin" method ="post" modelAttribute="user" id="login-form">
        
                            <h3 class="text-center text-info">Login</h3>
                            <div class="form-group">
                           
			
                                <label for="id" class="text-info">User Id:</label><br>
                                <form:input id ="id" class ="form-control" path="id"/>
                   				<form:errors path="id" cssStyle="color: red;" />
                            </div>
                            <div class="form-group">
                                <label for="name" class="text-info">User Name:</label><br>
                                <form:input id ="name" class ="form-control" path="name"/>
                   				<form:errors path="name" cssStyle="color: red;" />
                            	
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <form:input id ="password" class ="form-control" path="password"/>
                   				<form:errors path="password" cssStyle="color: red;" />
                            </div>
                            <div class="form-group">
                                 <input type="submit" name="submit" class="btn btn-info btn-md" value="Log in">
                            </div>
               
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>