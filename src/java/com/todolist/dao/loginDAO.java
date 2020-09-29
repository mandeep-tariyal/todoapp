/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.todolist.dao;

import com.todolist.model.login;
import com.todolist.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.*;


public class loginDAO extends HttpServlet 
{
    public boolean validate(login user) throws ClassNotFoundException
    {
        boolean  status =false;
        
        try
        {
            Connection con = JdbcUtils.getConnection();
            PreparedStatement st = con.prepareStatement("select * from users where username=? and password=?");
            st.setString(1, user.getUserName());
            st.setString(2, user.getPassword());
            
            ResultSet rs = st.executeQuery();
            status= rs.next();
        }
        catch(Exception e){System.out.println(e);}
        return status;
    }
    
}
