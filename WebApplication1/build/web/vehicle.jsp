<%-- 
    Document   : vehicle
    Created on : May 8, 2018, 12:56:06 PM
    Author     : Hari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body ng-app="">
        <!--<h1>Hello World!</h1>-->
    <html:form action="vehicle" method="post">
        <tr>
            <td>
                 <bean:write name="VehicleForm" property="status" filter="false"/>
                 </br>
            </td>
            <td>
                Vehicle No. : 
            </td>
            <td>
                <html:text property="vehicleNo" styleId="vehicleNo"/>
            </td>
        </tr>
        </br>
        </br>
        <tr>
            <td>
                Vehicle Colour. : 
            </td>
            <td>
                <!--<input type="text" ng-model="vehicleColour" required my-directive id="vehicleColour"/>-->
                <html:text property="colour" styleId="vehicleColour"/>
            </td>
        </tr>
        </br>
        </br>
        <tr>
            <td>
                Vehicle Engine No. : 
            </td>
            <td>
                <!--<input type="text" ng-model="vehicleEngine" required my-directive id="vehicleEngine"/>-->
                <html:text property="engineNo" styleId="vehicleEngine"/>
            </td>
        </tr>
        </br>
        </br>
        <tr>
            <td>
                Vehicle Type : 
            </td>
            <td>
                <html:radio  property = "vehicleType" value="Hatchback" /> Hatchback
                <html:radio  property = "vehicleType" value="Sedan" /> Sedan
               <html:radio  property = "vehicleType" value="SUV" /> SUV
<!--                <input type="radio" ng-model="vehicleType" value="hatchback">HatchBack
                <input type="radio" ng-model="vehicleType" value="sedan">Sedan
                <input type="radio" ng-model="vehicleType" value="suv">SUV-->
                <html:hidden property="type" styleId="dummy" value=""/>
                <!--<input type="text" ng-model="dummy" id = "dummy" value="">-->
            </td>
        </tr>
        </br>
        </br>
        <tr>
            <td>
                <input type="button" ng-model="buttons" value="GET" onclick="clickedGET()"/>
            </td>
            <td>
                <input type="button" ng-model="buttons" value="POST" onclick="clickedPOST()"/>
            </td>
            <td>
                <input type="button" ng-model="buttons" value="UPDATE" onclick="clickedUPDATE()"/>
            </td>
        </tr>
    </html:form>
        <script>
//            console.log(document.getElementById("dummy"));
//            document.getElementById("vehicleNo").value = "";
//            document.getElementById("vehicleColour").value = "";
////            document.getElementById("vehicleType").value = "";
//            document.getElementById("vehicleEngine").value = "";
            function clickedGET(){
                document.getElementById("dummy").value = "GET";
                document.forms[0].submit();
            }
            function clickedPOST(){
                console.log("post");
                document.getElementById("dummy").value = "POST";
                document.forms[0].submit();
            }
            function clickedUPDATE(){
                document.getElementById("dummy").value = "UPDATE";
                document.forms[0].submit();
            }
            
        </script>
    </body>
</html>
