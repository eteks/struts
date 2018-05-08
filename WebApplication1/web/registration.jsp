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
        <title>JSP Page</title>
    </head>
    <body>
<!--        <h1>Hello World!</h1>-->
        <html:form action = "/register" method="post" >
            <table border="0">
                <tbody>
                    <tr>
                        <td colspan="2">
                            <bean:write name="RegistrationForm" property="error" filter="false"/>
                            &nbsp;
                        </td>
                    </tr>
                    <tr>
                        <td>Enter your name:</td>
                        <td><html:text property= "name"/></td>
                    </tr>
                    <tr>
                        <td>Enter your Email ID:</td>
                        <td><html:text property= "email"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><html:submit value = "Register" /></td>
                    </tr>
                </tbody>
            </table>            
            
        </html:form>
    </body>
</html>
