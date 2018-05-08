/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Hari
 */
public class LoginForm extends org.apache.struts.action.ActionForm {
    
    private String name;
    private String email;
    private String error;
    private String validate;
    private String available;
    private String usertype;

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(int count) {
        if(count == 0){
            this.available= "<span style='color:green'>Username is available</span>";
        }else{
            this.available = "<span style='color:red'>Username is not available</span>";
        }
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate() {
        this.error = "<span style='color:red'>Please provide valid entries for both fields</span>";
    }

    public String getError() {
        return error;
    }

    public void setError(int count) {
        this.error = "<span style='color:red'>Drunk? Credentials are wrong!</span>";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    private int number;

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param string
     */
    public void setName(String string) {
        name = string;
    }

    /**
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param i
     */
    public void setNumber(int i) {
        number = i;
    }

    /**
     *
     */
    public LoginForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
