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
public class VehicleAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private String vehicleNo;
    private String colour;
    private String engineNo;
    private String vehicleType;
    private String type;

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
        
        VehicleForm formBean = (VehicleForm) form;
        vehicleNo = formBean.getVehicleNo();
        colour = formBean.getColour();
        engineNo = formBean.getEngineNo();
        vehicleType = formBean.getVehicleType();
        type = formBean.getType();
        System.out.println(vehicleNo + colour + engineNo + vehicleType + type);
        
        String ret = "ERROR";
        String result = "";
        Connection conn = null;
        
        if(type.equals("GET")){
          try {
             String URL = "jdbc:mysql://localhost/struts2";
             Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(URL, "root", "root");
             String sql = "SELECT vehicleColour,vehicleEngineNo,vehicleType FROM struts2.vehicle WHERE ";
             sql+="vehicleNo = ?";
    //         System.out.println("SQL query " + sql);
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, vehicleNo);
    //         ps.setString(2, email);
             System.out.println("PS" + ps);
             ResultSet rs = ps.executeQuery();

             while (rs.next()) {
//                result = rs.getString(2);
//                System.out.println("Name" + result);
//                ret = SUCCESS;
                  formBean.setColour(rs.getString(1));
                  formBean.setEngineNo(rs.getString(2));
                  formBean.setVehicleType(rs.getString(3));
                  formBean.setStatus("Retrieved Successfully");
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
        }else if(type.equals("POST")){
            try {
             String URL = "jdbc:mysql://localhost/struts2";
             Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(URL, "root", "root");
             String sql = "insert into struts2.vehicle (vehicleNo,vehicleColour,vehicleEngineNo,vehicleType) VALUES(?,?,?,?)";
//             sql+="vehicleNo = ?";
    //         System.out.println("SQL query " + sql);
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, vehicleNo);
             ps.setString(2, colour);
             ps.setString(3, engineNo);
             ps.setString(4, vehicleType);
             System.out.println("PS" + ps);
             ps.executeUpdate();
             formBean.setStatus("Added Successfully");
//             System.out.println("Result");

//             while (rs.next()) {
//                 System.out.println(rs.next());
//                result = rs.getString(2);
//                System.out.println("Name" + result);
////                ret = SUCCESS;
////                  formBean.setColour(rs.getString(1));
////                  formBean.setEngineNo(rs.getString(2));
////                  formBean.setVehicleType(rs.getString(3));
//             }

          } catch (Exception e) {
              System.out.println(e);
             ret = "ERROR";
          } finally {
             if (conn != null) {
                try {
                   conn.close();
                } catch (Exception e) {
                }
             }
          }
        }else if(type.equals("UPDATE")){
            try {
             String URL = "jdbc:mysql://localhost/struts2";
             Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(URL, "root", "root");
             String sql = "UPDATE struts2.vehicle SET vehicleColour = ?, vehicleEngineNo = ?, vehicleType=? where vehicleNo = ?";
//             sql+="vehicleNo = ?";
    //         System.out.println("SQL query " + sql);
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(4, vehicleNo);
             ps.setString(1, colour);
             ps.setString(2, engineNo);
             ps.setString(3, vehicleType);
             System.out.println("PS" + ps);
             ps.executeUpdate();
             formBean.setStatus("Updated Successfully");
//             System.out.println("Result");

//             while (rs.next()) {
//                 System.out.println(rs.next());
//                result = rs.getString(2);
//                System.out.println("Name" + result);
////                ret = SUCCESS;
////                  formBean.setColour(rs.getString(1));
////                  formBean.setEngineNo(rs.getString(2));
////                  formBean.setVehicleType(rs.getString(3));
//             }

          } catch (Exception e) {
              System.out.println(e);
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
        
        return mapping.findForward(SUCCESS);
    }
}
