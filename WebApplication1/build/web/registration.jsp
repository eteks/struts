<%-- 
    Document   : registration
    Created on : Apr 20, 2018, 12:33:43 PM
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
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-route.min.js"></script>
        <title>Registration</title>
    </head>
    <body>
<!--        <h1>Hello World!</h1>-->
        <html:form action="registration" method="post" >
            <table border="0">
                <tbody>
                    <tr>
                        <td colspan="2">
                            <bean:write name="RegistrationForm" property="error" filter="false"/>
                            &nbsp;
                            <bean:write name="RegistrationForm" property="available" filter="false"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Enter your name:</td>
                        <td><html:text property= "name" styleId="name" onblur="checkUsername()"/></td>
                    </tr>
                    <tr>
                        <td>Enter your Email ID:</td>
                        <td><html:text property= "email"/></td>
                    </tr>
                    <tr>
                        <td>Enter your Usertype:</td>
                        <td>
                        <html:select property="usertype" styleId="usertype">
                            <html:option value="System">System</html:option>
                            <html:option value="PDB">PDB</html:option>
                            <%--<html:optionsCollection name="LoginForm" property="usertype" label="countryName" value="countryId" />--%>
                        </html:select>
                            <html:text property = "action" styleId="action"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><html:submit value = "Register" /></td>
                    </tr>
                </tbody>
            </table>             
        </html:form>

<script>
    
    function checkUsername(){
    console.log("inside checkeUsername");
    window.name = document.getElementById("name").value;
//    System.out.println("Username & Email" + name + email);
//    console.log("Username"+name );
    document.getElementById("action").value = "checkUsername";
    document.forms[0].submit();
//   LoginAction.execute();
}
</script>
    </body>
</html>
