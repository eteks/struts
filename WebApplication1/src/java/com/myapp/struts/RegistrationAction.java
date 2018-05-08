/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Hari
 */
public class RegistrationAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    String name, email;

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
    LoginForm formBean = (LoginForm) form;
    name = formBean.getName();
    email = formBean.getEmail();
    
      String ret = "ERROR";
      String result = "";
      Connection conn = null;
      
      try {
         String URL = "jdbc:mysql://localhost/struts2";
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(URL, "root", "root");
         String sql = "INSERT INTO new_table (username,email) VALUES(?,?)";
//         System.out.println("SQL query " + sql);
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, name);
         ps.setString(2, email);
//         System.out.println("PS" + ps);
         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
            result = rs.getString(1);
            System.out.println("Name" + result);
            ret = SUCCESS;
         }
         
      } catch (Exception e) {
         ret = "ERROR";
      } finally {
         if (conn != null) {
            try {
               conn.close();
            } catch (Exception e) {
            }
         }
      }
    // perform validation
    if ((name == null) || // name parameter does not exist
            email == null || // email parameter does not exist
            name.equals("") || // name parameter is empty
            email.indexOf("@") == -1) {   // email lacks '@'
        
        formBean.setValidate();
//        return mapping.findForward(FAILURE);
    }
    if(result.equals(email)){
        return mapping.findForward(SUCCESS);
    }
        
        return mapping.findForward(SUCCESS);
    }
}
