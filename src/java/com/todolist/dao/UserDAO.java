/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.todolist.dao;

import com.todolist.model.user;
import com.todolist.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Mandeep
 */
public class UserDAO {

    public int registerEmployee(user employee) {
       String sql = "insert into users"+"(first_name , last_name, username,password)values" +"(?,?,?,?)";
       
       
       int result = 0;
        try
        {
            Connection con = JdbcUtils.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, employee.getFirstName());
            st.setString(2, employee.getLastName());
            st.setString(3, employee.getUsername());
            st.setString(4,employee.getPassword());
            
            System.out.println(st);
            result = st.executeUpdate();
        }catch(Exception e){System.out.println(e);}
        
        return result;
    }
    }
    
    

