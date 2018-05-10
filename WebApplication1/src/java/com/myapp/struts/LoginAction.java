/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hari
 */
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SYSTEM = "system";
    private static final String PDB = "pdb";
    private final static String FAILURE = "failure";
    private final static String VALIDATE = "validate";
    private String name, email, usertype;
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
        
        // extract user data
    LoginForm formBean = (LoginForm) form;
    name = formBean.getName();
    email = formBean.getEmail();
    usertype = formBean.getUsertype();
    System.out.println("Username & Email" + name + email + usertype);
    
      String ret = "ERROR";
      String result = "";
      Connection conn = null;
      
      if(formBean.getAction().equals("checkUsername")){
         try {
         String URL = "jdbc:mysql://localhost/struts2";
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(URL, "root", "root");
         String sql = "SELECT COUNT(username) FROM new_table WHERE ";
         sql+=" username = ?";
//         System.out.println("SQL query " + sql);
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, name);
//         ps.setString(2, email);
//         System.out.println("PS" + ps);
         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
            result = rs.getString(1);
            System.out.println("Name" + result);
            ret = SYSTEM;
         }
         if(Integer.parseInt(result) == 1){
             formBean.setAvailable(1);
             return mapping.findForward(FAILURE);
         }else{
             formBean.setAvailable(0);
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
      }else if(formBean.getAction().equals("login")){
         try {
         String URL = "jdbc:mysql://localhost/struts2";
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(URL, "root", "root");
         String sql = "SELECT COUNT(*) FROM new_table WHERE ";
         sql+=" username = ? and usertype = ? and email = ?";
//         System.out.println("SQL query " + sql);
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, name);
         ps.setString(2, usertype);
         ps.setString(3, email);
//         System.out.println("PS" + ps);
         ResultSet rs = ps.executeQuery();

         while (rs.next()) {
            result = rs.getString(1);
            System.out.println("Name" + result);
            ret = SYSTEM;
         }
         if((Integer.parseInt(result) == 1) && (usertype.equals("system"))){
//             formBean.setAvailable(1);
             return mapping.findForward(SYSTEM);
         }else if((Integer.parseInt(result) == 1) && (usertype.equals("pdb"))){
             return mapping.findForward(PDB);
         }else{
             formBean.setError();
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
      
      }

      
    // perform validation
    if ((name == null) || // name parameter does not exist
            email == null || // email parameter does not exist
            name.equals("") || // name parameter is empty
            email.indexOf("@") == -1) {   // email lacks '@'
        
        formBean.setValidate();
        return mapping.findForward(FAILURE);
    }
//    if(result.equals(email)){
//        return mapping.findForward(SUCCESS);
//    }
          
//    formBean.setError();
    return mapping.findForward(FAILURE);
        
   
    
//    public String execute() {
//        
//      System.out.println("hi");
//      String ret = "ERROR";
//      Connection conn = null;
//
//      try {
//         String URL = "jdbc:mysql://localhost/struts2";
//         Class.forName("com.mysql.jdbc.Driver");
//         conn = DriverManager.getConnection(URL, "root", "root");
//         String sql = "SELECT username FROM new_table WHERE";
//         sql+=" username = ? AND email = ?";
//         System.out.println("SQL query " + sql);
//         PreparedStatement ps = conn.prepareStatement(sql);
//         ps.setString(1, name);
//         ps.setString(2, email);
//         ResultSet rs = ps.executeQuery();
//
//         while (rs.next()) {
//            name = rs.getString(1);
//            ret = SUCCESS;
//         }
//      } catch (Exception e) {
//         ret = "ERROR";
//      } finally {
//         if (conn != null) {
//            try {
//               conn.close();
//            } catch (Exception e) {
//            }
//         }
//      }
//      return ret;
//   }
    
    
//    return mapping.findForward(FAILURE);
    }
}