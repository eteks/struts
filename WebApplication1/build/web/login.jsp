<%-- 
    Document   : login
    Created on : Apr 19, 2018, 4:10:01 PM
    Author     : Hari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
        <title>JSP Page</title>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-route.min.js"></script>
    </head>
    <body ng-app="myApp">
        
        <!--<h1>Hello World!</h1>-->
        <br/>
        <html:form action = "/login" method="post">
           
                        <td colspan="2">
                            <bean:write name="LoginForm" property="error" filter="false"/>
                            </br>
                            <bean:write name="LoginForm" property="available" filter="false"/>
                            
                        </td>
                   
                    <tr>
                        </br>
                        Enter your name:
                        <!--<input type="text" property = "name" ng-model="name" required my-directive ng-pattern="/^[0-9]{1,7}$/" ng-keyup='checkUsername()' id="username">-->
                        <html:text property= "name" onblur="checkUsername()" styleId="username" />
                        <!--<p>{{name}}</p>-->
                    </tr>
                    <tr>
                        </br>
                        Enter your Email ID:
                        <!--<input type="text"  property = "email" ng-model="email" required my-directive >-->
                        <html:text property= "email" />
                    </tr>
                    <tr>
                        <html:select property="usertype" >
                            <html:option value="0">Select Country</html:option>
                            <html:optionsCollection name="LoginForm" property="usertype" label="countryName" value="countryId" />
                        </html:select>
                    </tr>
                    <tr>
                        <br/>
                        <html:submit style = "margin:25%; margin-top:5%" value = "Login" onclick="login()"/></td>
                    </tr>
        </html:form>
<script>
var app = angular.module('myApp', []);
app.directive('myDirective', function() {
  return {
    require: 'ngModel',
    link: function(scope, element, attr, mCtrl) {
//        console.log(attr.ngModel);
        function myValidation(value){
            if(value)
                return value;
            }         
     mCtrl.$parsers.push(myValidation);
    }
  };
});

function checkUsername(){
    console.log("inside checkeUsername");
    var name = document.getElementById("username").value;
//    System.out.println("Username & Email" + name + email);
    console.log("Username"+name );
    document.forms[0].submit();
//   LoginAction.execute();
}

function login(){
//    console.log("login");
    document.forms[0].submit();
//    LoginAction.execute();
}
</script>

</body>
    
</html>
